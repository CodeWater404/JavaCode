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





# 类加载子系统

`Class Loader Subsystem`

简略：

![image-20220506162346841](pictures/image-20220506162346841.png)

详细：

![image-20220506162514499](pictures/image-20220506162514499.png)



## 内容

1. 类加载子系统作用

   ![image-20220506163312713](pictures/image-20220506163312713.png)

2. 类加载器角色

   ![image-20220506163517766](pictures/image-20220506163517766.png)

3. 类的加载过程

   ![image-20220506163545969](pictures/image-20220506163545969.png)

   1. 加载

      ![image-20220506163901174](pictures/image-20220506163901174.png)

   2. 链接

      ![image-20220506164149516](pictures/image-20220506164149516.png)

4. 类加载器分类









# 工具

1. `Binary viewer`：查看二进制文件的

2. `Bytecode viewer`：查看字节码文件的（是个jar包，双击直接打开）

   > 是一款基于图形界面的 Java 反编译器，Java 字节码编辑器，APK 编辑器，APK 反编译器，Dex 编辑器，DEX 反编译器，其集成了 6 个 Java 反编译库（包含 Procyon、CFR 和 Fernflower），Andorid 反编译类库和字节码类库。不仅如此，它还是一款 Hex 查看器，代码搜索器和代码调试器。除此之外，它还具备 Smali 和 Baksmali 等汇编器的相关功能。
   > 它完全用 Java 编写，并且是开源的。 它目前由 Konloch 维护和开发。
   > 还有一个插件系统可以让您与加载的类文件进行交互，例如您可以编写一个字符串反混淆器、恶意代码搜索器或其他您能想到的东西。
   > 您可以使用预先编写的插件之一，也可以编写自己的插件。 它支持 Groovy、Python 和 Ruby 脚本。
   > 一旦插件被激活，它会将文件系统中加载的每个类的 ClassNode ArrayList 发送到执行函数，这允许用户使用 ASM 完全处理它。

3. `Jclasslib bytecode viewer`:字节码分析工具（idea也有类似的插件；在菜单栏中的`view`）

   ![image-20220506180608114](pictures/image-20220506180608114.png)

4. 

