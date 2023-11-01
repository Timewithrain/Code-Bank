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
