# Write your MySQL query statement below
SELECT World.name, World.population, World.area
FROM World
WHERE World.population > 25000000 OR World.area > 3000000