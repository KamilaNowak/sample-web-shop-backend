
-- version 1.0
-- IBM DB2

CREATE TABLE item_category (
  category_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  category_title VARCHAR(255) DEFAULT NULL
);


CREATE TABLE item (
   item_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
   serial_number VARCHAR(255) DEFAULT NULL,
   title VARCHAR(255) DEFAULT NULL,
   item_description VARCHAR(255) DEFAULT NULL,
   price DECIMAL(10,2) DEFAULT NULL,
   image_url VARCHAR(255) DEFAULT NULL,
   is_active SMALLINT DEFAULT 1,
   item_availability BIGINT DEFAULT NULL,
   created_at DATE DEFAULT NULL,
   last_updated_at DATE DEFAULT NULL,
   category_id INT NOT NULL,

  CONSTRAINT fk_category_id 
        FOREIGN KEY (category_id) 
        REFERENCES item_category ( category_id )
        ON DELETE CASCADE

);

CREATE TABLE customer (
    customer_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    firstName VARCHAR(255) DEFAULT NULL,
    lastName VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    phoneNumber VARCHAR(255) DEFAULT NULL
);

CREATE TABLE payment (
    payment_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    cardType VARCHAR(255) DEFAULT NULL,
    cardNumber VARCHAR(255) DEFAULT NULL,
    securityCode VARCHAR(255) DEFAULT NULL,
    expirationDate VARCHAR(255) DEFAULT NULL
);

CREATE TABLE shipping (
    shipping_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    postalCode VARCHAR(255) DEFAULT NULL,
    country VARCHAR(255) DEFAULT NULL,
    city VARCHAR(255) DEFAULT NULL,
    street VARCHAR(255) DEFAULT NULL,
    building VARCHAR(255) DEFAULT NULL
);

CREATE TABLE purchase (
    purchase_id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    serialNumber VARCHAR(255) DEFAULT NULL,
    title VARCHAR(255) DEFAULT NULL,
    price VARCHAR(255) DEFAULT NULL,
    imageUrl VARCHAR(255) DEFAULT NULL,
    quantity VARCHAR(255) DEFAULT NULL,

    customer_id INT NOT NULL,
    shipping_id INT NOT NULL,
    payment_id INT NOT NULL,

   CONSTRAINT fk_customer_id
        FOREIGN KEY (customer_id)
        REFERENCES customer ( customer_id )
        ON DELETE CASCADE,

   CONSTRAINT fk_shipping_id
        FOREIGN KEY (shipping_id)
        REFERENCES shipping ( shipping_id )
        ON DELETE CASCADE,

   CONSTRAINT fk_payment_id
        FOREIGN KEY (payment_id)
        REFERENCES payment ( payment_id )
        ON DELETE CASCADE
);



