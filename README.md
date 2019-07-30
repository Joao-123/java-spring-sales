# java-spring-sales

### USERS

```
GET USERS
{Host}:{Port}/api/v1/users
{Host}:{Port}/api/v1/users/{user_id}
localhost:8080/api/v1/users
localhost:8080/api/v1/users/5814525

POST USERS
{Host}:{Port}/api/v1/users
localhost:8080/api/v1/users
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

PUT USERS
{Host}:{Port}/api/v1/users/{user_id}
localhost:8080/api/v1/users/5814527
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

DELETE USERS
{Host}:{Port}/api/v1/users/{user_id}
localhost:8080/api/v1/users/5814527
```

### ITEMS

```
GET ITEMS
{Host}:{Port}/api/v1/items
{Host}:{Port}/api/v1/items/{item_id}
localhost:8080/api/v1/items
localhost:8080/api/v1/items/1001

POST ITEMS
{Host}:{Port}/api/v1/items
localhost:8080/api/v1/items
BODY:
{
    "name": "Drink RedBeer",
    "price": 35,
    "stock": 25
}

PUT ITEMS
{Host}:{Port}/api/v1/items/{item_id}
localhost:8080/api/v1/items/1001
BODY:
{
    "name": "Drink GreenBeer",
    "price": 25,
    "stock": 15
}

DELETE ITEMS
{Host}:{Port}/api/v1/items/{item_id}
localhost:8080/api/v1/items/1001
```

### SALES

```
GET SALES
{Host}:{Port}/api/v1/sales
{Host}:{Port}/api/v1/sales/{sale_id}
localhost:8080/api/v1/sales
localhost:8080/api/v1/sales/1001

POST SALES
{Host}:{Port}/api/v1/sales
localhost:8080/api/v1/sales
BODY:
{
    "idSeller": "9988555",
    "idClient": "7766776",
    "date": "2019-07-25"
}

PUT SALES
{Host}:{Port}/api/v1/sales/{sale_id}
localhost:8080/api/v1/sales/1001
BODY:
{
    "idSeller": "9988555",
    "idClient": "7766777",
    "date": "2019-07-25"
}

DELETE SALES
{Host}:{Port}/api/v1/sales/{sale_id}
localhost:8080/api/v1/sales/1001
```

### SALES ITEMS

```
GET SALES_ITEMS
{Host}:{Port}/api/v1/sales/items
{Host}:{Port}/api/v1/sales/items/{sale_item_id}
localhost:8080/api/v1/sales/items
localhost:8080/api/v1/sales/items/1001

POST SALES_ITEMS
{Host}:{Port}/api/v1/sales/items
localhost:8080/api/v1/sales/items
BODY:
{
    "idSale": 1001,
    "idItem": 1005,
    "quantity": 1
}

PUT SALES_ITEMS
{Host}:{Port}/api/v1/sales/items/{sale_item_id}
localhost:8080/api/v1/sales/items/1001
BODY:
{
    "idSale": 1010,
    "idItem": 1020,
    "quantity": 5
}

DELETE SALES_ITEMS
{Host}:{Port}/api/v1/sales/items/{sale_item_id}
localhost:8080/api/v1/sales/items/1001
```
