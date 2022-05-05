[TOC]



# JVM

参考来自尚硅谷，侵权请联系



# 整体结构



![image-20220505171516152](pictures/image-20220505171516152.png)





## 执行流程



![image-20220505171717177](pictures/image-20220505171717177.png)



## 生命周期



### 启动

![image-20220505181014122](pictures/image-20220505181014122.png)



### 执行

![image-20220505181045554](pictures/image-20220505181045554.png)



### 退出

![image-20220505181812782](pictures/image-20220505181812782.png)



## JIT

即时编译器：会找到程序中的热点代码（执行次数比较多的），加到缓存中，下次直接从缓存中取。





## 命令解释

```
jps：打印当前程序中执行的进程

javap -v 类名.class：反编译某个类

iconst_2: 定义常量2
istore_1: 保存在操作数栈栈中，1是一个索引位置
iload_1: 加载保存的数，索引1的位置
iadd： 求和操作



```





# chapter01

1. 反编译命令：`javap -v 类名.class` 

   ![image-20220505175236879](pictures/image-20220505175236879.png)



2. 栈和寄存器的指令集架构

   ![image-20220505180455205](pictures/image-20220505180455205.png)



3. 





## StackStruTest



![image-20220505180253705](pictures/image-20220505180253705.png)