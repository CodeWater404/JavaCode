[TOC]



## JavaCode

命名规则
**注意：** 包名小驼峰，类名大驼峰，方法名小驼峰

记录学习Java的过程、知识点、bug等等。
个人详细学习记录[博客](https://www.cnblogs.com/CodeWater404/)
***





## Algorithm

算法练习。

> 调试代码：
>
> 1. 一般**cout**输出中间变量；
> 2. 遇到***\*Runtime Error\**** (RE)、segment fault一个个删除代码看那部分对结果有影响的。





### [acwing](https://www.acwing.com/activity/)

注意类名要改为Main，去掉包路径；即可运行在acwing上。





***











***

### leetCode力扣

提示：力扣上面的题目不需要处理输入，直接写思路在函数里面即可。







### offer

题源：剑指offer

| [_3FindRepeatNumber](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/) | [_4FindNumber](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [_5ReplaceSpace](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/) | [_6ReversePrint](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/) |
| [_7BuildTree](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/) | [_9CQueue](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/) |
| [_10_1Fib](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/) | [_10_2FrogJumpingSteps](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/) |
| [_11MinimumNumberOfRotationArray](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/) | [_12PathInMatrix](https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/)矩阵中的路径 |
| _13RangeOfMotionOfRobot机器人的运动范围                      |                                                              |
|                                                              |                                                              |
|                                                              |                                                              |
|                                                              |                                                              |
|                                                              |                                                              |



***





## Basics

Java基础复习

1. collection集合
2. file类
3. io流
4. net网络编程
5. lambda函数式编程
6. stream流
7. reflect反射
8. annotation注解

***



## notes



各种代码笔记





## SQL

mysql语句练习，理论参考[博客](https://www.cnblogs.com/CodeWater404/p/15972099.html)



### sql

1. tab_user建表
2. multiTableExample多表例子
3. multiTableExercise多表查询练习
4. grantAndRevoke管理用户和授权



### jdbc

java连接数据库；db3.sql需要用到练习的sql数据

1. JdbcDemo01快速入门
2. JdbcDemo02-05 添加、修改、删除数据（DML）、创建表（DDL）
3. JdbcDemo06查询语句（DQL）if判断
4. JdbcDemo07查询语句（DQL）while判断
5. JdbcDemo08、09、10：封装数据、防止sql注入、事务
6. 除此之外的就是数据库连接池的练习和例子



***



## Web



Javaweb学习



### bootstrap

一个前端框架练习



### xml

xml解析练习





***





## WebTomcat



Javaweb学习：涉及到服务器，需要Tomcat等新环境，开的模块。

Servlet是sun公司制定的一种用来扩展web服务器功能的一种组件规范，web服务器只能只能处理静态资源的请求；使用Servlet来扩展web服务器功能，web服务器收到请求之后就会调用相应的Servlet来处理请求。

1. servlet
2. request对象；test包下是个总和案例
3. response对象
4. cookie（客户端）
5. session（服务端）
6. el表达式
7. jstl  jsp标准标签库
8. jspCase jsp、el、jstl的一个总和案例
9. filter 过滤器
10. filterCase 过滤器的案例练习（有错误）
11. listener 监听器





***





## JQuery

JQuery、Ajax暂时不做了解；了解一下json

1. 







***





## Spring5

spring学习

1. demo1入门
2. demo2依赖注入（对象属性的、属性是集合的、bean的单例多例）
3. demo3使用注解进行配置
4. demo4 Aop切面
5. demo5 jdbctemplate
6. demo6 事务、log4j2





## SpringMVC

入门练习





## SpringMVC-demo2



1. @RequestMapping的各种属性
2. @RequestParam请求参数
3. @RequestHeader头
4. @CookieValue值
5. 通过实体类参数获取请求参数
6. 解决乱码问题





## SpringMVC-demo3



1. 使用servletAPI获取request域对象共享数据
2. 使用ModelAndView获取request域对象共享数据
3. 使用Model获取request域对象共享数据
4. 使用Map获取request域对象共享数据
5. 使用modelMap获取request域对象共享数据
6. 使用servletAPI获取session域对象共享数据
7. 使用servletAPI获取application域对象共享数据
8. thymeleafView视图
9. InternalResourceView转发视图
10. RedirectView重定向视图
11. 视图控制器spingmvc.xml中配置view-controller







## SpringMVC-jsp

1. 基本运行入门



## SpringMVC-rest

1. 显示用户信息
2. 删除用户
3. 添加用户
4. 修改用户





## Spring-demo4

HttpMessageController

1. requestBody请求体
2. requestEntity请求实体
3. responseBody响应体
4. responseEntity响应实体
5. 文件下载
6. 文件上传





## SpringMVC-demo5

1. 拦截器
2. 异常处理





## SpringMVC-annotation

全部采用注解来配置实现



## MyBatis

1. 快速入门



## MyBatis-demo2

1. 增删改查
2. 方法里有不同参数进行查询
3. 不同返回值类型进行查询
4. 添加主键自增





## MyBatis-demo3

1. 实体类和数据库列名的自定义映射
2. 分步查询、延迟加载
3. 一对多的查询
4. 动态sql
5. 一级、二级缓存、整合第三方缓存



## MyBatis-MBG

1. 逆向工程：根据数据库表生成具体的实现类
2. 使用分页插件



## MybatisPlus

练习



## SpringBoot

1. springboot-demo1  boot入门
2. springboot-helloworld 使用spring Initializer创建模板
3. springboot-web01   web方面的注解使用



### boot项目创建的pom模板文件

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        这里的版本可以不同，！！！用模板创建的需要删除这里以外的就能运行
        <version>2.3.4.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.codewater</groupId>
    <artifactId>web</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>web</name>
    <description>Demo project for Spring Boot</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
        
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>jquery</artifactId>
            <version>3.5.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>

```





## Design Pattern

设计模式

笔记在notes中



## Redis

nosql数据库，笔记在notes中





# Git

1. git add添加文件的时候区分大小写的，不然会添加不成功。
2. git push远程分支的时候也是需要区分大小写，不然还是会push不成功。
3. 


***





# 遇到的问题及遗忘

1. comparator的排序规则如何定义([详情](https://www.cnblogs.com/CodeWater404/p/15922537.html))
    > 规则：
    > 从小到大排序，当前对象-比较对象；
    > 从大到小排序，比较对象-当前对象。
    >
    > 
    >
    > 实现比较的两种方法：
    >
    > 1. Comparable：类继承接口的：
    >
    >    ~~~java
    >    public class Student implements Comparable<Student>{
    >         private int age;
    >        @Override
    >        public int compareTo(Student o) {
    >            return this.age-o.age;//升序
    >        }
    >    }
    >    ~~~
    >
    > 2. Comparator：排序时直接写规则如Collections.sort或 Arrays.sort
    >
    >    ~~~java
    >    Collections.sort(list, new Comparator<Student>() {
    >        @Override
    >        public int compare(Student o1, Student o2) {
    >            return o2.getAge()-o1.getAge();//以学生的年龄降序
    >        }
    >    });
    >    ~~~
    >
    >    

2. 泛型的上下限
    > 1. 设置泛型对象的**上限**使用extends,表示参数类型只能是该类型或该类型的子类<br>
    >     格式：< ? extends 类>       <br>
    > 2. 设置泛型对象的**下限**使用super,表示参数类型只能是该类型或该类型的父类：<br>
    >    格式：< ? super 类> 
    
3. Java是向下取整（浮点数到整数）

4. 

