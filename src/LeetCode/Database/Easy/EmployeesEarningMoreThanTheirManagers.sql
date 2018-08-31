# Write your MySQL query statement below
SELECT
    e1.Name As Employee
FROM
    Employee e1, Employee e2
WHERE
    e1.ManagerId = e2.Id AND e1.Salary > e2.Salary