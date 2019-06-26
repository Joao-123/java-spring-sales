# java-spring-sales

## USERS
### GET USERS
GET: 			{Host}:{Port}/api/v1/users

GET: 			{Host}:{Port}/api/v1/users/{user_id}

GET EXAMPLE:	10.31.35.100:8080/api/v1/users

GET EXAMPLE:	10.31.35.100:8080/api/v1/users/5814525


### POST USERS

POST:			{Host}:{Port}/api/v1/users

POST EXAMPLE:	10.31.35.100:8080/api/v1/users

BODY:
{
    "id": "5814525",
    "password": "pass123",
    "name": "Sheldon",
    "lastName": "Cooper",
    "birthDate": "11/10/1999",
    "email": "Sheldon.Cooper@gmail.com",
    "type": "admin"
}

### PUT USERS
PUT:			{Host}:{Port}/api/v1/users/{user_id}

PUT EXAMPLE:	10.31.35.100:8080/api/v1/users/5814527

BODY:
{
    "id": "5814525",
    "password": "secret123",
    "name": "Sheldon",
    "lastName": "Cooper",
    "birthDate": "11/10/2001",
    "email": "Sheldon_Cooper@gmail.com",
    "type": "student"
}

### DELETE USERS
DELETE: 			{Host}:{Port}/api/v1/users/{user_id}

DELETE EXAMPLE:		10.31.35.100:8080/api/v1/users/5814527
