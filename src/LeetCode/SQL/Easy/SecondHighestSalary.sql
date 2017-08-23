# Write your MySQL query statement below
SELECT
    IF(COUNT(tmp.Salary) >= 1, tmp.Salary, NULL) AS SecondHighestSalary
FROM
    (SELECT DISTINCT Employee.Salary
     FROM
        Employee
     ORDER BY Employee.Salary DESC
     LIMIT 1, 1) tmp