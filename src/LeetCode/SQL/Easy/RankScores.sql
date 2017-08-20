# Write your MySQL query statement below
# 用户自定义的变量可以先在用户变量中保存值，然后再以后引用它。
# 这样，可以将值从一个语句传递到另一个语句。用户变量与连接有关
#，也就是说，一个客户端定义的变量不能被其它客户端看到或使用。
# 当客户端退出时，该客户端连接的所有变量都将自动释放。
#　在select语句中赋值给用户变量的语法是：
# @var_name := value，这里的var_name是变量名，
# value是你正在检索的值。

SELECT `Score`, `Rank` 
FROM(SELECT `Score`, @curRank := @curRank + IF(@prevScore = `Score`, 0, 1) AS `Rank`,
       @prevScore := `Score`
     FROM `Scores` AS `s`, (SELECT @curRank := 0) AS `curRank`,
       (SELECT @prevScore := NULL) AS `pervScore`
ORDER BY `Score` DESC) AS `result`;