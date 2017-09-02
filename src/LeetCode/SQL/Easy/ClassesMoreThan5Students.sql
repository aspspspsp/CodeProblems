# Write your MySQL query statement below
SELECT
    courses.class
FROM
    courses
GROUP BY courses.class
HAVING COUNT(DISTINCT courses.student) >= 5