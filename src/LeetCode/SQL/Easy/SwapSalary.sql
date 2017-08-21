# Write your MySQL query statement below
UPDATE salary SET salary.sex = IF(salary.sex = 'm', 'f', 'm')