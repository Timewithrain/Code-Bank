
-- 创建学生表
create table student
(
    id     varchar(255) not null,
    name   varchar(255) not null,
    birth  date         null,
    gender varchar(10)  not null,
    constraint student_pk
        primary key (id)
);

-- 创建课程表
create table course
(
    id     varchar(255) not null,
    name   varchar(255) not null,
    teacher_id varchar(255)  not null,
    constraint course_pk
        primary key (id)
);

-- 创建教师表
create table teacher
(
    id   varchar(255) not null,
    name varchar(255) not null,
    constraint teacher_pk
        primary key (id)
);

-- 创建成绩表
create table score
(
    student_id   varchar(255) not null,
    course_id   varchar(255) not null,
    score float not null,
    constraint score_pk
        primary key (student_id, course_id)
);

-- 查询姓可的学生名单
select * from student where name like '可%';
-- 查询姓名中最后一个字是可的学生名单
select * from student where name like '%乐';
-- 查询姓名中带有可字的学生名单
select * from student where name like '%乐%';
-- 查询姓百的老师的个数
select count(*) from teacher where name like '百%';
-- 查询名字长度为2的老师的名单
select * from teacher where char_length(name)=2;

-- 查询学生号为0002的学生的总成绩
select sum(score) from score where student_id='0002';
-- 查询所有选了课的学生人数
select count(distinct student_id) as number from score;
-- 查询各科成绩的最高分和最低分
select course.name as name, max(score), min(score) from course, score
where course.id=score.course_id group by course.name;
-- 查询每门课程被选修的学生人数
select count(distinct student_id) as number from score group by course_id;
-- 查询男生女生的人数
select gender, count(id) as number from student group by gender;
-- 查询平均分大于60的学生学号和平均成绩  使用having作条件限制
select student_id, avg(score) from score group by student_id having avg(score.score)>60;
-- 查询至少选修两门课的学生学号
select student_id from score group by student_id having count(student_id)>=2;
-- 查询同名同姓的人的名单，统计同名同姓人的人数
select name, count(name) from student group by name having count(name)>1;
-- 查询不及格课程并按照课程号从大到小排列
select course_id from score where score<60 order by course_id desc;
-- 查询每门课程的平均成绩，结果按平均成绩升序排列，平均成绩相同时，按课程号降序排列
select course_id, avg(score) from score group by course_id order by avg(score) asc, course_id desc;
-- 检索课程号为'0004'且分数小于60的学生学号，结果按分数降序排序
select student_id from score where course_id='0004' and score<60 order by score desc;
-- 统计每门课程的学生选修人数，要求输出课程号和选修人数，查询结果按照人数降序排序，若人数相同按照课程号升序排列
select course_id, count(student_id) as number from score group by course_id
having count(student_id)>1 order by number desc, course_id asc;
-- 查询两门以上不及格课程的同学的学号及其平均成绩
select student_id, avg(score) from score where score<60 group by student_id having count(course_id)>2;
-- 查询学生的总成绩并进行排名
select student_id, sum(score) from score group by student_id order by desc;


-- 查询所有课程成绩小于60分学生的学号、姓名（使用子查询）
select id as 学号, name as 姓名 from student where id in (select student_id from score where score<60);
-- 查询没有学全所有课程的学生的学号、姓名
select id as 学号, name as 姓名 from student where id in
(select student_id from score group by student_id having count(course_id)<(select count(*) from course));
-- 查询只选修了两门课程的全部学生的学号和姓名
select id as 学号, name as 姓名 from student where id in
(select student_id from score group by student_id having count(course_id)=2);

-- 查询1999年出生的学生名单
select * from student where year(birth)=1999;
-- 查询学生年龄(精确到月份) 使用timestampdiff函数实现
select name, timestampdiff(month, birth, now())/12 from student;
-- 查询本月过生日的学生名单
select name from student where month(birth)=month(now());
-- 查询当前日期
select current_date;
-- 查询当前日期和时间
select now();

-- 查询所有学生的学号、姓名、选课数、总成绩
select student.id, student.name, count(course_id), sum(score)
from student, score where student.id=student_id group by student.id;
-- 查询平均成绩大于85的所有学生的学号、姓名、平均成绩
select student.id, student.name, avg(score) from student, score
where student.id=score.student_id group by student.id having avg(score)>85;
-- 查询学生的选课情况，学号、姓名、课程号、课程名  where子句实现
select student.id, student.name, course_id, course.name from student, score, course
where student.id=score.student_id and score.course_id=course.id;
-- 查询学生的选课情况，学号、姓名、课程号、课程名  inner join子句实现
select student.id, student.name, course_id, course.name
from student inner join score on student.id = score.student_id inner join course on course_id=course.id;
-- 查询每门课的及格人数和不及格人数  case表达式
select course_id, sum(case when score>=60 then 1 else 0 end) as 及格人数,
sum(case when score<60 then 1 else 0 end) as 不及格人数 from score group by course_id;
-- 使用分段[100-85],[85-70],[70-60],[60>]来统计各科成绩，分别统计：各分数段人数，课程号和课程名称
select course_id, course.name,
sum(case when score between 85 and 100 then 1 else 0 end) as '[100-85]',
sum(case when score>=70 and score<85 then 1 else 0 end) as '(80-70]',
sum(case when score>=60 and score<70 then 1 else 0 end) as '(70-60]',
sum(case when score<60 then 1 else 0 end) as '(60-0]'
from course inner join score on course.id=score.course_id group by course_id;
-- 查询课程编号为0003且成绩在80分以上的学生的学号和姓名
select id, name from student where id in
(select student_id from score where course_id='0003' and score>80);

-- 检索"0001"课程分数小于60，按分数降序排列的学生信息
select * from student where id in (select student_id from score where course_id='0001' and score<60) order by score desc;
-- 查询不同老师所教不同课程的平均分，从高到低显示  三表连接
select teacher_id, course_id, avg(score) from
score s inner join course c on s.course_id = c.id inner join teacher t on t.id = c.teacher_id
group by teacher_id, course_id order by avg(score) desc;
-- 查询课程名为"数学"，且分数低于60的学生姓名和分数  三表连接实现
select s.name, score from
student s inner join score on s.id = score.student_id inner join course c on score.course_id = c.id
where c.name='数学' and score<60;
-- 查询课程名为"数学"，且分数低于60的学生姓名和分数  子查询实现
select id, name from student where id in
(select student_id from score where score<60 and course_id in (select id from course where name='数学'));
-- 查询任意一门课程成绩在70分以上的姓名、课程姓名、和分数
select s.name, c.name, score from
student s inner join score on s.id=score.student_id inner join course c on score.course_id = c.id
where score>70;
-- 查询两门及以上不及格课程的同学的学号，姓名及其平均成绩  表连接+条件+分组
select s.id, s.name, avg(score) from student s inner join score on s.id=score.student_id
where score<60 group by s.id having count(course_id)>=2;
-- 查询不同课程成绩相同的学生的学生编号、课程编号、学生成绩
select distinct a.student_id, a.course_id, a.score from score as a inner join score as b
where a.score = b.score and a.course_id != b.course_id;
-- 查询课程编号为'0001'的课程比编号'0002'的课程成绩高的所有学生的学号
select a.student_id from score a inner join score b on a.student_id=b.student_id
where a.course_id='0001' and b.course_id='0002' and a.score>b.score group by a.student_id;
-- 查询学过课程号为'0001'和课程号为'0002'的课程的学生、姓名
select id, name from student where id in (select a.student_id from
(select * from score where course_id='0001') as a inner join (select * from score where course_id='0002') as b
on a.student_id=b.student_id);
--(错误！！！) 查询学过'百岁山'老师所教的所有课程的同学的学号、姓名  子查询
select id, name from student where id in
(select distinct student_id from score where course_id in
(select c.id from course c inner join teacher t on c.teacher_id=t.id where t.name='百岁山'));
--(错误！！！) 查询学过'百岁山'老师所教的所有课程的同学的学号、姓名  多表连接
select s.id, s.name from student s
inner join score on s.id=score.student_id
inner join course c on score.course_id=c.id
inner join teacher t on c.teacher_id=t.id where t.name='百岁山';
-- 查询没学过"百岁山"老师任何课程的学生姓名
select id, name from student where id not in
(select student_id from score inner join course c on score.course_id = c.id
inner join teacher t on c.teacher_id=t.id where t.name='百岁山');
-- 查询没学过全部课程的同学
select id, name from student where id not in
(select student_id from score group by student_id having count(course_id)=(select count(*) from course));
-- 查询没学过"百岁山"老师所教全部课的学生姓名
select id, name from student where id not in
(select student_id from score where course_id in
(select c.id from course c inner join teacher t on t.id = c.teacher_id where t.name='百岁山')
group by student_id having count(course_id)=(
(select count(c.id) from course c inner join teacher t on t.id = c.teacher_id where t.name='百岁山')));
-- 查询选修"百岁山"老师所教授课程学生中成绩最高的学生姓名及其成绩
select name, score from student inner join score on student.id=score.student_id
where course_id in (select id from course where teacher_id in (select id from teacher where name='百岁山'))
order by score desc limit 1;
-- 查询至少有一门课与学号'0001'的学生所学课程相同的学生的学号和姓名
select id, name from student where id in
(select distinct student_id from score where course_id in
(select course_id from score where student_id='0001') and student_id!='0001');
-- 按平均成绩从高到底显示所有学生的所有课程的成绩及其平均成绩
select s.id, s.name, cname, score, avgs from student s
inner join (select student_id out_sid, c.name cname, score,
(select avg(score) from score where student_id=out_sid group by student_id) avgs from
score inner join course c on score.course_id=c.id) b on b.out_sid=s.id order by avgs desc;
