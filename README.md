# coding-excercise
Description:
============
We want to make sure that the users who are using our application knows how to add numbers. To achieve this,
we want to provide the user/client with a question and then allow the user/client to submit an answer. If the
user/client and the service were both real person, then they would have interacted in the following manner:

Client: Hey Service, can you provide me a question with numbers to add?
Service: Here you go, solve the question: “Please sum the numbers 9,5,3”.
Client: Great. The original question was “Please sum the numbers 9,5,3” and the answer is 15.
Service: That’s wrong. Please try again.
Client: Sorry, the original question was “Please sum the numbers 9,5,3” and the answer is 17.
Service: That’s great



Tools/Technologies Used
========================

1. Java 8
2. Spring Boot 2.3.4.RELEASE
3. JUnit 5
4. Maven 3.6
5. Postman client (Desktop or Chrome extension)
5. IDE : IntelliJ or Eclipse

Setup
=====

1. Make sure you have installed JDK 8 and Maven in your machine

2. Clone the project in your local machine using command "git clone {repository-path}".

3. Move to the "coding-exercise" directory and build the project by following maven command "mvn clean install".

4. Double click on the "startCodingExerciseServer.bat" file to start the server.

P.S. By default it runs on the port 8080.

5. Now the service is available on " http://localhost:8088" with HTTP POST method.


Test the Service:
=================

P.S: Use the id=1 to generate a new question and id=2 to answer the question.

1. Open the Postman client and hit the http://localhost:8088" with HTTP POST method with the following JSON message in the request body:

{	
   "id": 1,
   "message": "Hey Service, can you provide me a question with numbers to add?"
}

It's give you a random to be sum like:

Here you go, solve the question: "Please sum the numbers 91,59,58".

2. Replace the request body with following to answer the question:

{	
   "id": 2,
   "message": "Great. The original question was \"Please sum the numbers 91,59,58\" and the answer is 47"
}

2.1 If the answer is correct, it will return "That's great"

2.2 If the answer is incorrect, it will return "That's wrong. Please try again."
