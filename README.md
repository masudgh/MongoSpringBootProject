# MongoSpringBootProject
A Sample Spring Boot and Mongo DB integration Example

In this example I have use:
1) Spring boot 1.5.1
2) Mongo DB v3.2.8
3) Compiled in Java 1.8

This is an example rest API interfacing the mongoDB to perform CRUD operations.

The APIs are:
GET http://localhost:8080/mongo-api/people  . List of people documents in the database
GET http://localhost:8080/mongo-api/people/{lastName} List of people documents  with the provided last name from the database.

POST http://localhost:8080/mongo-api/people . Payload {
	"id":"1",
	"firstName":"matt",
	"lastName":"winsor"
}

BYW, The Id won't be acceptable even provided.

DELETE  http://localhost:8080/mongo-api/people/{lname} Delete an entry by its last name


