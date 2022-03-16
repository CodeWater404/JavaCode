# JavaCode

命名规则
**注意：** 包名小驼峰，类名大驼峰，方法名小驼峰

记录学习Java的过程、知识点、bug等等。
个人详细学习记录[博客](https://www.cnblogs.com/CodeWater404/)
***





## Algorithm

算法练习
### [acwing](https://www.acwing.com/activity/)

注意类名要改为Main，去掉包路径；即可运行在acwing上。

***

#### basic算法基础课
提示：没有报名的，看不了题目。所以我就不粘贴题目链接了。网站的链接在上面。
1. chapter1(基础算法)
    1. QuickSort快速排序
    2. NumberK第k个数
    3. MergeSort归并排序
    4. ReverseOrderNumber逆序对的数量（归并）
    5. RangOfNumber数的范围（二分）
    6. TheCubicRootOfANumber数的三次方根（二分）
    7. HighPrecisionAddition高精度加法
    8. HighPrecisionSubtraction高精度减法
    9. HighPrecisionMultiply高精度乘法
    10. HighPrecisionDivider高精度除法
    11. PrefixAnd前缀和
    12. SumOfSubmatrix子矩阵的和
    
***

### leetCode力扣

提示：力扣上面的题目不需要处理输入，直接写思路在函数里面即可。

1. 1051[高度检查器](https://leetcode-cn.com/problems/height-checker/)
2. 



#### offer

题源：剑指offer

| [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/) | [剑指 Offer 04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/) | [剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/) |
| [剑指 Offer 07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/) | [剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/) |
| [剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/) |                                                              |
|                                                              |                                                              |
|                                                              |                                                              |
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









***



# Git

1. git add添加文件的时候区分大小写的，不然会添加不成功。
2. git push远程分支的时候也是需要区分大小写，不然还是会push不成功。


***

# 遇到的问题及遗忘

1. comparator的排序规则如何定义([详情](https://www.cnblogs.com/CodeWater404/p/15922537.html))
    > 规则：
    > 从小到大排序，当前对象-比较对象；
    > 从大到小排序，比较对象-当前对象。
2. 泛型的上下限
    > 1. 设置泛型对象的**上限**使用extends,表示参数类型只能是该类型或该类型的子类<br>
    >     格式：< ? extends 类>       <br>
    > 2. 设置泛型对象的**下限**使用super,表示参数类型只能是该类型或该类型的父类：<br>
    >    格式：< ? super 类> 


