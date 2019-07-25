CREATE TABLE users(
   id VARCHAR(7) NOT NULL,
   password VARCHAR(20) NOT NULL,
   name VARCHAR(20) NOT NULL,
   last_name VARCHAR(20) NOT NULL,
   birth_date DATE NOT NULL,
   email TEXT NOT NULL,
   type VARCHAR(6) NOT NULL,
   PRIMARY KEY (id)
);

CREATE TABLE items(
   id INT AUTO_INCREMENT,
   name TEXT NOT NULL,
   price DOUBLE NOT NULL,
   stock INT NOT NULL,
   PRIMARY KEY (id)
)AUTO_INCREMENT=1000;

CREATE TABLE sales (
    id INT AUTO_INCREMENT,
    id_seller VARCHAR(7) NOT NULL,
    id_client VARCHAR(7) NOT NULL,
    date DATE NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (id_seller) REFERENCES users(id),
    FOREIGN KEY (id_client) REFERENCES users(id)
)AUTO_INCREMENT=1000;

CREATE TABLE sales_items (
    id INT AUTO_INCREMENT,
    id_sale INT NOT NULL,
    id_item INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_sale) REFERENCES sales(id),
    FOREIGN KEY (id_item) REFERENCES items(id)
)AUTO_INCREMENT=1000;
