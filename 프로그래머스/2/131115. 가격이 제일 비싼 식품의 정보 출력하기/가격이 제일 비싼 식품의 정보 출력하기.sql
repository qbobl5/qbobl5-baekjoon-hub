SELECT *
FROM food_product
WHERE price in
(SELECT MAX(price)
FROM food_product);