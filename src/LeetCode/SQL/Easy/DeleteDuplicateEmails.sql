# Write your MySQL query statement below
DELETE FROM
p1
USING
Person p1
INNER JOIN
Person p2
WHERE p1.Email = p2.Email AND p1.Id > p2.Id