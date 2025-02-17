CREATE TABLE logistics (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    price DECIMAL(10, 2)
);

INSERT INTO logistics (name, price)
VALUES
    ('Transportation Services', 12000),
    ('Setup and Tear-down Crew', 8000),
    ('Equipment Rental', 15000);