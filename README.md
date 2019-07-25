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
    "birthDate": "1994-05-26",
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
    "birthDate": "1994-05-26",
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
    "stock": 25
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
    "stock": 15
}
```

### DELETE ITEMS

```
DELETE:            {Host}:{Port}/api/v1/items/{item_id}
DELETE EXAMPLE:    localhost:8080/api/v1/items/1001
```

## SALES
### GET SALES
```
GET:            {Host}:{Port}/api/v1/sales
GET:            {Host}:{Port}/api/v1/sales/{sale_id}
GET EXAMPLE:    localhost:8080/api/v1/sales
GET EXAMPLE:    localhost:8080/api/v1/sales/1001
```

### POST SALES

```
POST:            {Host}:{Port}/api/v1/sales
POST EXAMPLE:    localhost:8080/api/v1/sales
BODY:
{
    "idSeller": "9988555",
    "idClient": "7766776",
    "date": "2019-07-25"
}
```

### PUT SALES

```
PUT:            {Host}:{Port}/api/v1/sales/{sale_id}
PUT EXAMPLE:    localhost:8080/api/v1/sales/1001
BODY:
{
    "idSeller": "9988555",
    "idClient": "7766777",
    "date": "2019-07-25"
}
```

### DELETE SALES

```
DELETE:            {Host}:{Port}/api/v1/sales/{sale_id}
DELETE EXAMPLE:    localhost:8080/api/v1/sales/1001
```
