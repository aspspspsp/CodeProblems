# Write your MySQL query statement below
SELECT
    w1.Id
FROM
    Weather w1, Weather w2
WHERE
    w1.Temperature > w2.Temperature AND DATEDIFF(w1.Date, w2.Date) = 1