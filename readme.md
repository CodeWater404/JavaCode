[TOC]



## JavaCode

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
1. chapter1

    快排、归并、二分、高精度（没有手动模拟）、前缀和、差分、双指针、位运算、

    |               基础算法               |                                                     |
    | :----------------------------------: | :-------------------------------------------------: |
    |          QuickSort快速排序           |                   NumberK第k个数                    |
    |          MergeSort归并排序           |       ReverseOrderNumber逆序对的数量（归并）        |
    |     RangOfNumber数的范围（二分）     |      TheCubicRootOfANumber数的三次方根（二分）      |
    |   HighPrecisionAddition高精度加法    |         HighPrecisionSubtraction高精度减法          |
    |   HighPrecisionMultiply高精度乘法    |           HighPrecisionDivider高精度除法            |
    |           PrefixAnd前缀和            |     SumOfSubmatrix子矩阵的和（前缀和二维应用）      |
    |  Difference差分（是前缀和的逆运算）  |      DifferenceMatrix差分矩阵（差分二维应用）       |
    | 799、800、2816：doublePointer 双指针 | _801Number of 1 in binary 二进制中1的个数（位运算） |
    |         _802离散化（待更新）         |             _803IntervalMerging区间合并             |

    

2. chapter2（都是用数组模拟的）

    单链表，双链表，栈，队列，单调栈，单调队列，KMP，Trie树（高效的存储和查找字符串集合的数据结构），并查集，堆，哈希表

    | 数据结构                                   |                                                   |
    | ------------------------------------------ | ------------------------------------------------- |
    | _826SingleLinkedList单链表                 | _827DoubleLinkedList双链表                        |
    | _828Stack栈                                | _829Queue队列                                     |
    | _830MonotoneStack单调栈                    | _154SlidingWindow滑动窗口（单调队列）             |
    | _831KMPCharacterString（KMP）              | _835TrieStringStatistics   trie字符串统计         |
    | _143MaximumXORPair最大异或对（Trie）       | _836MergeSet合并集合（并查集）                    |
    | _3302ExpressionEvaluation表达式求值（ 栈） | _837NumberOfConnectedBlocks连通块的数量（并查集） |
    | _240FoodChain食物链（并查集）              | _838HeapSort堆排序（只有down）                    |
    | _839SimulatedHeap模拟堆（堆的5个操作）     | _840SimulateHash哈希表                            |
    | _841CharacterHash字符串哈希                |                                                   |

    

3. 





***

### leetCode力扣

提示：力扣上面的题目不需要处理输入，直接写思路在函数里面即可。

1. 1051[高度检查器](https://leetcode-cn.com/problems/height-checker/)
2. 



### offer

题源：剑指offer

| [_3FindRepeatNumber](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/) | [_4FindNumber](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/) |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| [_5ReplaceSpace](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/) | [_6ReversePrint](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/) |
| [_7BuildTree](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/) | [_9CQueue](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/) |
| [_10_1Fib](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/) | [_10_2FrogJumpingSteps](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/) |
| [_11MinimumNumberOfRotationArray](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/) | [_12PathInMatrix](https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/)矩阵中的路径 |
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

