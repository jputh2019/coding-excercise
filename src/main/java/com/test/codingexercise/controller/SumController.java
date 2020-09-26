package com.test.codingexercise.controller;

import com.test.codingexercise.model.RequestDTO;
import com.test.codingexercise.utility.SumUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SumController {

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity questionAnswer(@RequestBody RequestDTO requestDTO) {
        try {
            String message = requestDTO.getMessage();
            int id = requestDTO.getId();

            if (id == 1) { // if ID==1, ->> return a new question
                String question = new SumUtility().getQuestion();
                return new ResponseEntity<String>(question, HttpStatus.OK);
            } else if (id == 2) {// if ID==2, ->> validate the answer
                try {
                    boolean isCorrentAnswer = new SumUtility().validateAnswer(message);
                    String respMsg = "";
                    if (isCorrentAnswer) {
                        respMsg = "That's great";
                        return new ResponseEntity<String>(respMsg, HttpStatus.OK);
                    } else {
                        respMsg = "That's wrong. Please try again.";
                        return new ResponseEntity<String>(respMsg, HttpStatus.BAD_REQUEST);
                    }
                } catch (Exception ex) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                }
            } else { // if ID is NULL or nothing --> throw the exception
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
