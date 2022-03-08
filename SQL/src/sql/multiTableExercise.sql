/*multiTableExercise
多表查询练习
*/

CREATE DATABASE multiTableExercise;
USE multiTableExercise;

-- 部门表
CREATE TABLE dept(
	id INT PRIMARY KEY ,
	dname VARCHAR(50),
	loc VARCHAR(50)
);

-- 添加4个部门
INSERT INTO dept(id , dname , loc ) VALUES 
	( 10 , '教研部' , '北京' ),
	( 20 , '学工部' , '上海' ),
	( 30 , '销售部' , '广州' ),
	( 40 , '财务部' , '深圳' );
	

-- 职务表，职务名称，职务描述
CREATE TABLE job(
	id INT PRIMARY KEY ,
	jname VARCHAR(20) ,
	description VARCHAR(50) 
);

-- 添加4个职务
INSERT INTO job(id , jname , description ) VALUES 
	( 1 , '董事长' , '管理公司' ),
	( 2 , '经理' , '管理部门员工' ),
	( 3 , '销售员' , '推销' ),
	( 4 , '文员' , '使用办公软件' );
	
-- 员工表
CREATE TABLE emp(
	id INT PRIMARY KEY ,
	ename VARCHAR(50) ,
	job_id INT ,
	mgr INT ,
	joindate DATE,
	salary DECIMAL( 7 , 2 ),
	bonus DECIMAL( 7 , 2 ),
	dept_id INT , 
	CONSTRAINT emp_jobid_ref_job_id_fk FOREIGN KEY ( job_id ) REFERENCES job ( id ) ,
	CONSTRAINT emp_deptid_ref_dept_id_fk FOREIGN KEY ( dept_id ) REFERENCES dept( id )
);	
	
-- 添加员工
INSERT INTO emp(id,ename,job_id,mgr,joindate,salary,bonus,dept_id) VALUES 
	(1001,'孙悟空',4,1004,'2000-12-17','8000.00',NULL,20),
	(1002,'卢俊义',3,1006,'2001-02-20','16000.00','3000.00',30),
	(1003,'林冲',3,1006,'2001-02-22','12500.00','5000.00',30),
	(1004,'唐僧',2,1009,'2001-04-02','29750.00',NULL,20),
	(1005,'李逵',4,1006,'2001-09-28','12500.00','14000.00',30),
	(1006,'宋江',2,1009,'2001-05-01','28500.00',NULL,30),
	(1007,'刘备',2,1009,'2001-09-01','24500.00',NULL,10),
	(1008,'猪八戒',4,1004,'2007-04-19','30000.00',NULL,20),
	(1009,'罗贯中',1,NULL,'2001-11-17','50000.00',NULL,10),
	(1010,'吴用',3,1006,'2001-09-08','15000.00','0.00',30),
	(1011,'沙僧',4,1004,'2007-05-23','11000.00',NULL,20),
	(1012,'李逵',4,1006,'2001-12-03','9500.00',NULL,30),
	(1013,'小白龙',4,1004,'2001-12-03','30000.00',NULL,20),
	(1014,'关羽',4,1007,'2002-01-23','13000.00',NULL,10);
	
-- 工资等级表
CREATE TABLE salarygrade(
	grade INT PRIMARY KEY ,
	losalary INT ,
	hisalary INT 
);

-- 添加5个工资等级
INSERT INTO salarygrade(grade,losalary,hisalary) VALUES 
		(1,7000,12000),
		(2,12010,14000),
		(3,14010,20000),
		(4,20010,30000),
		(5,30010,99990);
		
-- 题目

-- 1.查询所有员工信息。查询员工编号，员工姓名，工资，职务名称，职务描述
SELECT e.id '编号' , e.ename , e.salary , j.jname , j.description
FROM emp e , job j
WHERE e.job_id = j.id

-- 2.查询员工编号，员工姓名，工资，职务名称，职务描述，部门名称，部门位置
SELECT e.id , e.ename , e.salary , j.jname , j.description , d.dname , d.loc
FROM emp e , job j , dept d
WHERE e.job_id = j.id AND e.dept_id = d.id;

-- 3.查询员工姓名，工资，工资等级
SELECT e.ename , e.salary , s.grade
FROM emp e , salarygrade s
WHERE e.salary BETWEEN s.losalary AND s.hisalary;

-- 4.查询员工姓名，工资，职务名称，职务描述，部门名称，部门位置，工资等级
SELECT e.ename , e.salary , j.jname , j.description , d.dname , d.loc , s.grade
FROM emp e , job j , dept d , salarygrade s
WHERE e.job_id = j.id AND e.dept_id = d.id AND e.salary BETWEEN s.losalary AND s.hisalary;

-- 5.查询出部门编号、部门名称、部门位置、部门人数
SELECT d.id , d.dname , d.loc , t.total
FROM dept d , ( SELECT e.dept_id , COUNT(id) total FROM emp e GROUP BY e.dept_id ) t
WHERE d.id = t.dept_id;

-- 6.查询所有员工的姓名及其直接上级的姓名,没有领导的员工也需要查询
SELECT e1.ename , e1.mgr , e2.id , e2.ename 
FROM emp e1 LEFT JOIN  emp e2
ON e1.mgr = e2.id;