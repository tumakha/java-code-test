-- 1.	Create a query to return the unique rows in a table

SELECT DISTINCT * FROM table_name;

-- 2.	Write a command to insert values into a table

INSERT INTO table_name (id, name)
VALUES
    (1, 'name1'),
    (2, 'name2');

-- 3.	Create a query that joins two tables together. Note, all rows from the first table must be in the result-set (e.g. given customer and order tables, return all customers and any orders for each customer)

SELECT c.*, o.*, COUNT(o.order_id) from CUSTOMER c
LEFT JOIN CUSTOMER_ORDER o ON c.customer_id = o.customer_id
GROUP BY c.customer_id

