-- LeetCode SQL练习
-- 1757. 可回收且低脂的产品
select product_id
from Products
where low_fats='Y' and recyclable='Y';

-- 584. 寻找用户推荐人
select name
from Customer
where referee_id!=2 or referee_id is null;

-- 595. 大的国家
select name, population, area
from World
where area >= 3000000 or population >= 25000000;

-- 1378. 使用唯一标识码替换员工ID
select unique_id, name
from Employees, EmployeeUNI
where Employees left join EmployeeUNI on Employees.id=EmployeeUNI.id;

-- 1068. 产品销售分析
select product_name, year, price
from Sales inner join product on Sales.product_id=product.product_id;

-- 1581. 进店却未进行过交易的顾客
select customer_id, count(v.visit_id) count_no_trans
from Visits v left join Transactions t on v.visit_id = t.visit_id
where t.transaction_id is null
group by customer_id;



