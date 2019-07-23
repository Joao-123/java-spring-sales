# java-spring-sales

## USERS
### GET USERS

```
GET:            {Host}:{Port}/api/v1/users
GET:            {Host}:{Port}/api/v1/users/{user_id}
GET EXAMPLE:    localhost:8080/api/v1/users
GET EXAMPLE:    localhost:8080/api/v1/users/5814525
```

### POST USERS

```
POST:            {Host}:{Port}/api/v1/users
POST EXAMPLE:    localhost:8080/api/v1/users
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
```

### PUT USERS

```
PUT:            {Host}:{Port}/api/v1/users/{user_id}
PUT EXAMPLE:    localhost:8080/api/v1/users/5814527
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
```

### DELETE USERS

```
DELETE:            {Host}:{Port}/api/v1/users/{user_id}
DELETE EXAMPLE:    localhost:8080/api/v1/users/5814527
```

## ITEMS
### GET ITEMS

```
GET:            {Host}:{Port}/api/v1/items
GET:            {Host}:{Port}/api/v1/items/{item_id}
GET EXAMPLE:    localhost:8080/api/v1/items
GET EXAMPLE:    localhost:8080/api/v1/items/1001
```

### POST ITEMS

```
POST:            {Host}:{Port}/api/v1/items
POST EXAMPLE:    localhost:8080/api/v1/items
BODY:
{
    "name": "Drink RedBeer",
    "price": 35,
    "stock": 25,
}
```
    
### PUT ITEMS

```
PUT:            {Host}:{Port}/api/v1/items/{item_id}
PUT EXAMPLE:    localhost:8080/api/v1/items/1001
BODY:
{
    "name": "Drink GreenBeer",
    "price": 25,
    "stock": 15,
}
```

### DELETE USERS

```
DELETE:            {Host}:{Port}/api/v1/items/{item_id}
DELETE EXAMPLE:    localhost:8080/api/v1/items/1001
```