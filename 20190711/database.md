1. 大小写不区分
2.SQL 中最重要的 DDL 语句:

CREATE DATABASE - 创建新数据库
ALTER DATABASE - 修改数据库
CREATE TABLE - 创建新表
ALTER TABLE - 变更（改变）数据库表
DROP TABLE - 删除表
CREATE INDEX - 创建索引（搜索键）
DROP INDEX - 删除索引
3. SQL SELECT 语法
选取列： SELECT 列名称 FROM 表名称
以及：
选取所有列： SELECT * FROM 表名称 
4. 关键词 DISTINCT 用于返回唯一不同的值。
语法： SELECT DISTINCT 列名称 FROM 表名称
5. 如需有条件地从表中选取数据，
语法: SELECT 列名称 FROM 表名称 WHERE 列 运算符 值
6. SQL 使用单引号来环绕文本值（大部分数据库系统也接受双引号）。如果是数值，请不要使用引号。
7. AND 和 OR 可在 WHERE 子语句中把两个或多个条件结合起来。
如果第一个条件和第二个条件都成立，则 AND 运算符显示一条记录。
如果第一个条件和第二个条件中只要有一个成立，则 OR 运算符显示一条记录。
8. ORDER BY 语句用于根据指定的列对结果集进行排序。
ORDER BY 语句默认按照升序对记录进行排序。
按照降序对记录进行排序，可以使用 DESC 关键字。
9. INSERT INTO 语句用于向表格中插入新的行。
语法
INSERT INTO 表名称 VALUES (值1, 值2,....)
指定所要插入数据的列：
INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
10. Update 语句用于修改表中的数据。
语法：
UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
更新某一行中若干列：
UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing'
WHERE LastName = 'Wilson'
11. DELETE 语句用于删除表中的行。
语法
DELETE FROM 表名称 WHERE 列名称 = 值
12. 可以在不删除表的情况下删除所有的行。这意味着表的结构、属性和索引都是完整的：
DELETE FROM table_name
或者：
DELETE * FROM table_name
