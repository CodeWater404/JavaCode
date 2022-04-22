/*
多表查询
f5刷新；f9执行选中的语句
*/

-- 部门表
CREATE TABLE dept(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20)
);

-- 员工表
CREATE TABLE emp(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(10),
	gender CHAR(1),
	salary DOUBLE,
	join_date DATE,
	dept_id INT,
	FOREIGN KEY (dept_id) REFERENCES dept(id)
);

INSERT INTO dept( NAME ) VALUE( '划水部' );
INSERT INTO dept( NAME ) VALUE( '打架部' );
INSERT INTO dept( NAME ) VALUE( '嘴炮部' );


-- 插入,dept_id不能插
-- insert into emp( name , gender , salary , join_date , dept_id) values("孙悟空",'男',7200,'2013-02-24',1);
INSERT INTO emp( NAME , gender , salary , join_date ) VALUES("孙悟空",'男',7200,'2013-02-24');
INSERT INTO emp(NAME,gender,salary,join_date) VALUES('猪八戒','男',3600,'2010-12-02');
INSERT INTO emp(NAME,gender,salary,join_date) VALUES('唐僧','男',9000,'2008-08-08');
INSERT INTO emp(NAME,gender,salary,join_date) VALUES('白骨精','女',5000,'2015-10-07');
INSERT INTO emp(NAME,gender,salary,join_date) VALUES('蜘蛛精','女',4500,'2011-03-14');
-- 在emp的中插入数据后，emp表的外检就可以插入了
INSERT INTO emp(NAME,gender,salary,join_date , dept_id) VALUES('牛魔王','男',8000,'2011-05-23' , 1);


-- 1. 隐式内连接
-- 查询所有员工信息和对应的部门信息
SELECT * FROM emp e, dept d
WHERE e.dept_id = d.id;

-- 查询员工表的名称，性别。部门表的名称
SELECT e.name , e.gender , d.name
FROM emp e , dept d
WHERE e.dept_id = d.`id`

-- 2. 显示内连接
SELECT * 
FROM emp e INNER JOIN dept d ON e.dept_id = d.`id`;

SELECT * FROM emp e JOIN dept d ON e.dept_id = d.id; 

-- 3.左外链接：查询的是左表以及交集的数据
-- 查询所有员工信息，如果员工有部门，则查询部门名称，没有部门，则不显示部门名称
SELECT e.* , d.name 
FROM emp e LEFT JOIN dept d ON e.dept_id = d.id;

-- 4. 右外连接：查询的是右表所有数据以及其交集部分。
SELECT * 
FROM dept d RIGHT JOIN emp e ON e.dept_id = d.id;

-- 5. 子查询:查询工资最高员工信息
SELECT * 
FROM emp e WHERE e.salary = (
	SELECT MAX(salary)
	FROM emp
	);
-- 查询员工工资小于平均工资的人
SELECT *
FROM emp e
WHERE e.salary < (
	SELECT AVG(salary)
	FROM emp
	);
	
-- 查询'划水部'和'嘴炮部'所有的员工信息
SELECT * 
FROM emp e 
WHERE e.dept_id IN (
	SELECT id 
	FROM dept 
	WHERE NAME = '划水部' OR NAME = '嘴炮部'
	);

-- 查询员工入职日期是2011-11-11日之后的员工信息和部门信息
SELECT *
FROM dept t1 , ( SELECT * FROM emp WHERE emp.join_date > '2011-11-11' ) t2
WHERE t1.id = t2.dept_id;
-- 内连接
SELECT * 
FROM emp e , dept d
WHERE e.dept_id = d.id AND e.join_date > '2011-11-11';

