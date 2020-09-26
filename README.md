# coding-excercise
coding-exercise
Objective:
To make sure our application is accessed by humans and not a by any computers or bot.
Description:
We want to make sure that the users who are using our application knows how to add numbers. To achieve this, we want to provide the user/client with a question and then allow the user/client to submit an answer. If the user/client and the service were both real person, then they would have interacted in the following manner:
Client: Hey Service, can you provide me a question with numbers to add?
Service: Here you go, solve the question: “Please sum the numbers 9,5,3”.
Client: Great. The original question was “Please sum the numbers 9,5,3” and the answer is 15.
Service: That’s wrong. Please try again.
Client: Sorry, the original question was “Please sum the numbers 9,5,3” and the answer is 17.
Service: That’s great

Requirements:
Create a server that does two things:
1.	Respond to a client HTTP request
Respond to a client HTTP request with a minimum following in the response body
a)	A question with random numbers in the response body.
(Some Sample questions could be: 
Please sum the numbers 9,5,3
Please sum the numbers 10,2
Please sum the numbers 5,7,1)

2.	Receive a client HTTP request
Receive a client HTTP request with a minimum following in the request
a)	The question with the random numbers which was send earlier in the response of the first request.
b)	The sum of the numbers in the question.
And respond with,
a)	If the sum of the numbers is correct, then return a HTTP 200 OK
b)	If the sum of the numbers is wrong or if it’s an invalid request, then return a HTTP 400 Bad Request.
You are not required to write the client application, but you can assume that a client for this server should:
a)	Send a request to Service 1 and receives a response body with the question.
b)	Sum the numbers in the question
c)	Send the sum of the numbers to the service 2 along with the original response body from 1 which had the question.

Tests:
Please include tests to automatically validate the correctness of your code. You can write unit tests that can validate the correctness of individual small pieces of code or functional test to verify the expected responses from the two endpoints. Whatever you choose to implement these tests, it must be automated and simple to run. It should not be manually driven steps to test and compare results.





