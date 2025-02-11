CREATE DATABASE store
    WITH
    OWNER = postgres;

CREATE TABLE categories (
	id SERIAL PRIMARY KEY,
	category varchar(100) UNIQUE
);

CREATE TABLE products (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	price DOUBLE PRECISION NOT NULL,
	description TEXT NOT NULL,
	category_id INT NOT NULL,
	CONSTRAINT fk_product_categories FOREIGN KEY (category_id) REFERENCES categories(id) ON DELETE CASCADE
);
\dt
CREATE TABLE customers (
	id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	address VARCHAR(255)
);

CREATE TABLE orders (
	id SERIAL PRIMARY KEY,
	customer_id INT NOT NULL,
	order_date DATE NOT NULL,
	CONSTRAINT fk_order_customers FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);

CREATE TABLE order_items (
	id SERIAL PRIMARY KEY,
	order_id INT NOT NULL,
	product_id INT NOT NULL,
	qty int NOT NULL,
	CONSTRAINT fk_items_orders FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE,
	CONSTRAINT fk_items_products FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

CREATE TABLE product_reviews (
	id SERIAL PRIMARY KEY,
	product_id INT NOT NULL,
	customer_id INT NOT NULL,
	review INT NOT NULL,
	CONSTRAINT fk_review_products FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE,
	CONSTRAINT fk_review_customers FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE
);

CREATE TABLE payment_details (
	id SERIAL PRIMARY KEY,
	order_id INT NOT NULL,
	status BOOLEAN NOT NULL,
	CONSTRAINT fk_payment_orders FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE CASCADE
);

-- INSERT SAMPLE DATA

INSERT INTO categories (category)
VALUES	('FOOD'),
		('SMARTPHONE'),
		('LAPTOP'),
		('FASHION');

INSERT INTO products (name, price, description, category_id)
VALUES	('Bakso', 15000, 'Bakso bulat seperti bola pingpong', 1),
		('Mie Ayam', 20000, 'Mie ayam tidak bulat beda dengan bola pingping', 1),
		('Samsung Galaxy', 1500000, 'Smartphone Samsung', 2),
		('Samsung S23', 15000000, 'Smartphone Samsung ultra s23', 2),
		('Infinix 500s', 5000000, 'Smartphone Infinix ultra s23', 2),
		('Laptop Thinkpad', 5000000, 'Lapop Samsung ultra s23', 3),
		('Baju Batik', 150000, 'Baju batik nyaman', 4),
		('Celana Batik', 200000, 'Celana batik nyaman', 4);

INSERT INTO customers (name, address)
VALUES	('Fachri', 'Priuk'),
		('Alwi', 'Tangsel'),
		('Dimas', 'Tangsel'),
		('Maruf', 'Maja'),
		('Darma', 'Bekasi'),
		('Rido', 'Jaksel'),
		('Imron', 'Bekasi');

INSERT INTO orders (customer_id, order_date)
VALUES	('1', '2025-02-11'),
		('2', '2025-02-10'),
		('3', '2025-02-09'),
		('4', '2025-02-08'),
		('5', '2025-02-11'),
		('6', '2025-02-11'),
		('7', '2025-02-11');

INSERT INTO order_items (order_id, product_id, qty)
VALUES	(1, 1, 1),
		(1, 4, 1),
		(2, 1, 1),
		(2, 7, 2),
		(2, 8, 1),
		(4, 2, 1),
		(4, 3, 2),
		(4, 7, 2),
		(4, 6, 1),
		(5, 2, 1),
		(5, 5, 1),
		(6, 5, 1),
		(7, 1, 2);

INSERT INTO product_reviews (product_id, customer_id, review)
VALUES	(2, 1, 5), -- mie ayam oleh fachri dengan review * 5
		(4, 2, 4), -- samsung s23 oleh alwi review * 4
		(3, 3, 3), -- samsung galaxy oleh dimas * 5
		(6, 4, 5); -- laptop thinkpad oleh maruf * 5

INSERT INTO payment_details (order_id, status)
VALUES 	(1, TRUE),
		(2, TRUE),
		(3, TRUE),
		(4, TRUE),
		(5, TRUE),
		(6, TRUE);


-- SELECT TABLE
SELECT * FROM categories;
SELECT * FROM products;
SELECT * FROM customers;
SELECT * FROM orders;
SELECT * FROM order_items;
SELECT * FROM product_reviews;
SELECT * FROM payment_details;


-- SELECT JOIN TABLE
SELECT p.id, p.name, p.price, p.description, p.category_id, c.category FROM products p
INNER JOIN categories c
ON p.category_id = c.id;

SELECT o.id, o.order_date, o.customer_id, c.name AS customer_name FROM orders o
INNER JOIN customers c
ON o.customer_id = c.id;

SELECT i.id, i.order_id, i.qty, i.product_id, p.name, p.price, p.description
FROM order_items i
INNER JOIN products p
ON i.product_id = p.id;

SELECT *
FROM orders o
INNER JOIN order_items i ON o.id = i.order_id
INNER JOIN products p ON p.id = i.product_id;

SELECT *
FROM product_reviews r
INNER JOIN products p ON r.product_id = p.id
INNER JOIN customers c ON r.customer_id = c.id;



-- CREATE VIEW
CREATE VIEW product_details AS
SELECT p.id, p.name, p.price, p.description, p.category_id, c.category FROM products p
INNER JOIN categories c
ON p.category_id = c.id;

-- SELECT * FROM product_details;

CREATE VIEW customer_orders AS
SELECT o.id, o.order_date, o.customer_id, c.name AS customer_name FROM orders o
INNER JOIN customers c
ON o.customer_id = c.id;

-- SELECT * FROM customer_orders;

CREATE VIEW order_items_details AS
SELECT i.id, i.order_id, i.qty, i.product_id, p.name, p.price, p.description
FROM order_items i
INNER JOIN products p
ON i.product_id = p.id;

-- SELECT * FROM order_items_details;

CREATE VIEW product_reviews_details  AS
SELECT r.id, r.customer_id, c.name as customer_name, r.product_id, p.name as product_name, p.price, p.description, r.review
FROM product_reviews r
INNER JOIN products p ON r.product_id = p.id
INNER JOIN customers c ON r.customer_id = c.id;

-- SELECT * FROM product_reviews_details;

-- DELETE TABLES
DROP TABLE payment_details;
DROP TABLE product_reviews;
DROP TABLE order_items;
DROP TABLE orders;
DROP TABLE products;
DROP TABLE customers;
DROP TABLE categories;

-- DELETE VIEWS
DROP VIEW product_details;
DROP VIEW customer_orders;
DROP VIEW order_items_details;
DROP VIEW product_reviews_details;

-- UPDATE TABLE --
UPDATE customers SET name = 'Customer Update' WHERE id = 5;
UPDATE products SET name = 'Food Update', price = 10000, description = 'Sample Update', category_id = 1 WHERE id = 4;

-- DELETE DATA
DELETE FROM products where id = 4;

-- ALTER TABLE ADD COLUMN
ALTER TABLE customers ADD COLUMN age INT;
-- ALTER TABLE DELETE COLUMN
--ALTER TABLE customers DELETE COLUMN age INT;


-- PRODUK DENGAN HARGA TERMAHAL
SELECT * FROM products WHERE price = (SELECT MAX(price) FROM products);
-- PRODUK DENGAN HARGA TERMURAH
SELECT * FROM products WHERE price = (SELECT MIN(price) FROM products);
-- JUMLAH TOTAL BERLANJA PER CUSTOMER
SELECT o.id as order_id,c.name AS customer_name, SUM(i.qty * p.price) AS total_order FROM orders o
INNER JOIN order_items i ON o.id = i.order_id
RIGHT JOIN customers c on o.customer_id = c.id
FULL JOIN products p on i.product_id = p.id
GROUP BY o.id, c.name
ORDER BY o.id;
