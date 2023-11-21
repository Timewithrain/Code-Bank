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

-- 197. 上升的温度 (考察cross join交叉连接)
-- 使用datediff(date1, date2)函数实现交叉连接，返回date1和date2相差的天数，date1晚于date2返回正数，否则返回负数
select w1.id
from Weather w1 inner join Weather w2 on datediff(w1.recordDate, w2.recordDate)=1
where w1.temperature > w2.temperature;
-- 使用timestampdiff(type, time1, time2)函数实现交叉连接，返回time1和time2以type为单位的时间差，time1早于time2返回正数，否则返回负数
select w1.id
from Weather w1 inner join Weather w2 on timestampdiff(day, w1.recordDate, w2.recordDate)=-1
where w1.temperature > w2.temperature

-- 1661. 每台机器的进程平均运行时间
-- 使用子查询对齐启动和关闭时间，avg求均值，round保留3位小数
select a1.machine_id, round(avg(a2.timestamp-a1.timestamp), 3) processing_time
from (select * from Activity where activity_type='start') a1
inner join (select * from Activity where activity_type='end') a2
on a1.process_id=a2.process_id and a1.machine_id=a2.machine_id
group by machine_id;

-- 577. 员工奖金
select e.name, b.bonus
from Employee as e left join Bonus as b on e.empId=b.empId
where b.bonus < 1000 or b.bonus is null;
-- 使用ifnull函数实现
select e.name, b.bonus
from Employee as e left join Bonus as b on e.empId=b.empId
where ifnull(b.bonus, 0) < 1000;

-- 570. 至少有5名直接下属的经理
select name
from Employee
where id in
(select managerId from Employee group by managerId having count(id)>=5);

-- 620. 有趣的电影
select *
from cinema
where id%2=1 and description!='boring'
order by rating desc;
-- 使用mod函数实现，效率更高
select *
from cinema
where mod(id, 2)=1 and description!='boring'
order by rating desc;

-- 1251. 平均售价 (聚合函数考察)
select p.product_id, round(sum(p.price*ifnull(u.units, 0))/sum(ifnull(u.units, 1)), 2) average_price
from Prices p left join UnitsSold u
on p.product_id=u.product_id
where (u.purchase_date>=p.start_date and u.purchase_date<=p.end_date) or u.purchase_date is null
group by p.product_id;


-- 1148. 文章浏览I
select distinct author_id as id
from Views
where author_id=viewer_id
order by author_id asc;

-- 183. 无效的推文
select tweet_id
from Tweets
where char_length(content)>15;

-- 1280. 学生们参加各科测试的次数 (使用join求笛卡尔积)
select s1.student_id, s1.student_name, s2.subject_name, count(e.subject_name) attended_exams
from Students s1 join Subjects s2 left join Examinations e
    on s1.student_id=e.student_id and e.subject_name=s2.subject_name
group by s1.student_id, s2.subject_name
order by s1.student_id, s2.subject_name;

-- 1934. 确认率
select sa.user_id, round(ifnull(sc.num, 0)/ifnull(sa.num, 1), 2) confirmation_rate
from
    (select s.user_id, count(*) num
     from Signups s left join Confirmations c on s.user_id=c.user_id
     group by s.user_id) sa
        left join
    (select  s.user_id, count(*) num
     from Signups s left join Confirmations c on s.user_id=c.user_id
     where c.action='confirmed'
     group by s.user_id) sc
    on sa.user_id=sc.user_id
order by confirmation_rate asc;

-- 1075. 项目员工I
select p.project_id, round(avg(e.experience_years), 2) average_years
from Project p inner join Employee e on p.employee_id=e.employee_id
group by p.project_id;


-- 1633. 各项赛事的用户注册率
select contest_id, 100*(round(count(user_id)/(select count(*) num from Users), 4)) percentage
from Register
group by contest_id
order by percentage desc, r.contest_id asc;

-- 1211. 查询结果的质量和占比
select q.query_name, round(avg(q.rating/q.position), 2) quality, ifnull(c.poor_query_percentage, 0) poor_query_percentage
from Queries q
left join
    (select a.query_name, round(100*a.num/b.num, 2) poor_query_percentage
    from (select query_name, count(rating) num from Queries where rating<3 group by query_name) a
    inner join (select query_name, count(rating) num from Queries group by query_name) b
    on a.query_name=b.query_name) c
on q.query_name=c.query_name
group by query_name;

-- 1193. 每月交易I (子查询+date_format函数)
select tall.m month, tall.country, tall.cnt trans_count, ifnull(tapv.cnt, 0) approved_count,
       tall.amt trans_total_amount, ifnull(tapv.amt, 0) approved_total_amount
from (select country, date_format(trans_date, '%Y-%m') m, count(id) cnt, sum(amount) amt
      from Transactions group by m, country) tall
left join (select country, date_format(trans_date, '%Y-%m') m, count(id) cnt, sum(amount) amt
           from Transactions where state='approved' group by m, country) tapv
on tall.country=tapv.country and tall.m=tapv.m;

-- 2356. 每位教师所教授的科目种类的数量
select teacher_id, count(distinct subject_id) cnt
from Teacher
group by teacher_id;

-- 1141. 查询近30天活跃用户数
select activity_date day, count(distinct user_id) active_users
from Activity
where timestampdiff(day, activity_date, '2019-07-27') < 30
and timestampdiff(day, activity_date, '2019-07-27') >= 0
group by activity_date;

-- 1084. 销售分析III
select p.product_id, product_name
from Product p inner join Sales s on p.product_id=s.product_id
where p.product_id not in
      (select product_id
         from Sales
         where sale_date < '2019-01-01' or sale_date > '2019-03-31');

-- 596. 超过5名学生的课
select class from Courses
group by class having count(student) >= 5;

-- 1729. 求关注者的数量
select user_id, count(follower_id) followers_count
from Followers
group by user_id order by user_id;

-- 1174. 即时食物配送II
-- 首次配送
select customer_id, min(order_date) date
from Delivery
group by customer_id having min(order_date)
-- 即时配送
select customer_id, order_date date
from Delivery
where order_date=customer_pref_delivery_date
-- 联合首次和即时，查询首次即为即时配送的订单数量，除以总的首次订单数量
select round(100 * (a.cnt / b.cnt), 2) immediate_percentage
from (select count(a1.customer_id) cnt
      from (select customer_id, min(order_date) date
            from Delivery
            group by customer_id having min(order_date)) a1
      inner join (select customer_id, order_date date
                  from Delivery
                  where order_date=customer_pref_delivery_date) a2
      on a1.customer_id=a2.customer_id and a1.date=a2.date) a,
     (select count(distinct customer_id) cnt from Delivery) b;




