# digitalentBackend

# Running a Java Fat JAR

A Fat JAR is a Java Archive (JAR) file that contains all the necessary dependencies to run a Java application. To run a Fat JAR, follow these steps:

## Prerequisites

- You must have Java (JRE or JDK) installed on your computer.

## Steps

1. **Download the Fat JAR**: If you haven't already, download the Fat JAR file to your computer.

2. **Open a Terminal or Command Prompt**: Use your operating system's terminal or command prompt to run the Java application.

3. **Navigate to the Directory Containing the Fat JAR**: Use the `cd` command to change the current directory to the one where your Fat JAR is located.

   ```shell
   cd /path/to/your/fat-jar-directory
   run : java -jar fat.jar

# Create User - POST Request

## Description

This Markdown document provides instructions for making a POST request to create a user with the specified details. The request includes a JSON request body containing user information.

## Request

- **Method**: POST
- **URL**: `http://0.0.0.0:8080/createUser`

### Request Body

The request body should be a JSON object containing the following user details:

```json
{
    "firstName": "Pasaka",
    "lastName": "Mutuku",
    "age": 21,
    "town": "Thika",
    "gender": "Male"
}

## Request

- **Method**: POST
- **URL**: `http://0.0.0.0:8080/updateUser?id=6544a352e04fd8423fd0f70f`

### Request Body

The request body should be a JSON object containing the updated user details:

```json
{
    "firstName": "Lazarus",
    "lastName": "Mutuku",
    "age": 21,
    "town": "Thika",
    "gender": "Male"
}

### Request

```http
GET http://0.0.0.0:8080/getUser?id=6544a1b3b310b15f98e5545b

HTTP/1.1 200 OK

{
    "userId": "6544a1b3b310b15f98e5545b",
    "firstName": "Pasaka",
    "lastName": "Mutuku",
    "age": 21,
    "town": "Thika",
    "gender": "Male"
}

### Request

```http
DELETE http://0.0.0.0:8080/deleteUser?id=6544a1b3b310b15f98e5545b

HTTP/1.1 200 OK

{
    "status": false,
    "message": "User was deleted successfully"
}


