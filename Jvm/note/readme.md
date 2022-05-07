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



### 类加载子系统作用

![image-20220506163312713](pictures/image-20220506163312713.png)

### 类加载器角色

![image-20220506163517766](pictures/image-20220506163517766.png)

### 类的加载过程

![image-20220506163545969](pictures/image-20220506163545969.png)

1. 加载

   ![image-20220506163901174](pictures/image-20220506163901174.png)

2. 链接

   ![image-20220506164149516](pictures/image-20220506164149516.png)

### 类加载器分类

![image-20220507161508300](pictures/image-20220507161508300.png)



![	](pictures/image-20220507161706284.png)



1. 虚拟机自带的加载器

   ![image-20220507164136206](pictures/image-20220507164136206.png)

   ![image-20220507164039917](pictures/image-20220507164039917.png)

   ![image-20220507164302919](pictures/image-20220507164302919.png)

   

2. 用户自定义类加载器

   ![image-20220507165112064](pictures/image-20220507165112064.png)

   > 自定义类加载器的实现步骤：
   >
   > ![image-20220507165554223](pictures/image-20220507165554223.png)
   >
   > ```java
   > public class CustomClassLoader extends ClassLoader {
   >     
   >     @Override
   >     protected Class<?> findClass(String name) throws ClassNotFoundException {
   > 
   >         try {
   >             byte[] result = getClassFromCustomPath(name);
   >             if(result == null){
   >                 throw new FileNotFoundException();
   >             }else{
   >                 return defineClass(name,result,0,result.length);
   >             }
   >         } catch (FileNotFoundException e) {
   >             e.printStackTrace();
   >         }
   > 
   >         throw new ClassNotFoundException(name);
   >     }
   > 
   >     private byte[] getClassFromCustomPath(String name){
   >         //从自定义路径中加载指定类:细节略
   >         //如果指定路径的字节码文件进行了加密，则需要在此方法中进行解密操作。
   >         return null;
   >     }
   > 
   >     public static void main(String[] args) {
   >         CustomClassLoader customClassLoader = new CustomClassLoader();
   >         try {
   >             Class<?> clazz = Class.forName("One",true,customClassLoader);
   >             Object obj = clazz.newInstance();
   >             System.out.println(obj.getClass().getClassLoader());
   >         } catch (Exception e) {
   >             e.printStackTrace();
   >         }
   >     }
   > }
   > 
   > ```



### 关于`classLoader`

![image-20220507170206810](pictures/image-20220507170206810.png)

![image-20220507170417836](pictures/image-20220507170417836.png)



### 获取classloader的途径

![image-20220507170705923](pictures/image-20220507170705923.png)





## 双亲委派机制

![image-20220507171229161](pictures/image-20220507171229161.png)



### 工作原理

![image-20220507171633144](pictures/image-20220507171633144.png)

> 优先找上层去处理，上层能够处理就处理，不能处理就交由子类去处理。



### 优缺点



#### 优点

![image-20220507172322817](pictures/image-20220507172322817.png)



###  沙箱安全机制

![image-20220507172626289](pictures/image-20220507172626289.png)



## 其他

![image-20220507173049161](pictures/image-20220507173049161.png)



## 对类加载器的引用

![image-20220507173124527](pictures/image-20220507173124527.png)

​                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    

# 运行时数据区





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

