package com.test.codingexercise;

import com.test.codingexercise.model.RequestDTO;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CodingExerciseApplicationTests {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void testGetQuestion() throws Exception {
        RequestDTO reqMsg = new RequestDTO();
        reqMsg.setMessage("Hey Service, can you provide me a question with numbers to add?");
        reqMsg.setId(1);

        ResponseEntity<String> response = template.postForEntity(base.toString(), reqMsg,
                String.class);

        System.out.println(response.getBody());
        Assert.assertThat(response.getBody(), containsString("Here you go, solve the question"));
    }

    @Test
    public void testIncorrectAnswer() throws Exception {
        RequestDTO reqMsg = new RequestDTO();
        reqMsg.setMessage("Great. The original question was \"Please sum the numbers 9,5,3\" and the answer is 15.");
        reqMsg.setId(2);

        ResponseEntity<String> response = template.postForEntity(base.toString(), reqMsg,
                String.class);
        System.out.println(response.getBody());
        Assert.assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        Assert.assertThat(response.getBody(), containsString("That's wrong. Please try again"));
    }

    @Test
    public void testCorrectAnswer() throws Exception {
        RequestDTO reqMsg = new RequestDTO();
        reqMsg.setMessage("Great. The original question was \"Please sum the numbers 9,5,3\" and the answer is 17.");
        reqMsg.setId(2);

        ResponseEntity<String> response = template.postForEntity(base.toString(), reqMsg,
                String.class);
        System.out.println(response.getBody());
        Assert.assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        Assert.assertThat(response.getBody(), containsString("That's great"));
    }

    @Test
    public void testBadRequest() throws Exception {
        RequestDTO reqMsg = new RequestDTO();
        reqMsg.setMessage("Great. The original item was 17.");
        reqMsg.setId(2);

        ResponseEntity<String> response = template.postForEntity(base.toString(), reqMsg,
                String.class);
        Assert.assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        Assert.assertThat(response.getStatusCode().BAD_REQUEST, equalTo(HttpStatus.BAD_REQUEST));
    }

    @Test
    public void testNonServices() throws Exception {
        RequestDTO reqMsg = new RequestDTO();
        reqMsg.setMessage("Great. The the result is 17.");
        reqMsg.setId(3);

        ResponseEntity<String> response = template.postForEntity(base.toString(), reqMsg,
                String.class);
        Assert.assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
        Assert.assertThat(response.getStatusCode().BAD_REQUEST, equalTo(HttpStatus.BAD_REQUEST));
    }

}
