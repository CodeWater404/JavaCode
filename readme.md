# JavaCode

命名规则
**注意：** 包名小驼峰，类名大驼峰，方法名小驼峰

记录学习Java的过程、知识点、bug等等。
个人详细学习记录[博客](https://www.cnblogs.com/CodeWater404/)
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


# Git
1. git add添加文件的时候区分大小写的，不然会添加不成功。
2. git push远程分支的时候也是需要区分大小写，不然还是会push不成功。

# 遇到问题及遗忘
1. comparator的排序规则如何定义([详情](https://www.cnblogs.com/CodeWater404/p/15922537.html))
    > 规则：
    > 从小到大排序，当前对象-比较对象；
    > 从大到小排序，比较对象-当前对象。
2. 泛型的上下限
    > 1. 设置泛型对象的**上限**使用extends,表示参数类型只能是该类型或该类型的子类<br>
    >     格式：< ? extends 类>       <br>
    > 2. 设置泛型对象的**下限**使用super,表示参数类型只能是该类型或该类型的父类：<br>
    >    格式：< ? super 类> 


