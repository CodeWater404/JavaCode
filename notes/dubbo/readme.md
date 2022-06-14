[TOC]



> 模拟分布式，远程调用rpc



# 第一个商城实践

结构图：

![image-20220612175944815](pictures/image-20220612175944815.png)

![image-20220612211224422](pictures/image-20220612211224422.png)



1. dubbo后台管理地址：localhost：7001

2. 把消费者和生产者注册到注册中心需要先开启zookeeper

3. dubbo-admin管理页面：localhost：8080

   （需要看配置里面的zookeeper地址是否正确）

4. 



## gmall-interface

放公共的接口和service（业务）





## order-service-consumer

订单业务的消费具体实现。（**消费者类型**）

相当于一个远程，

1. pom中需要引入gmall的依赖（根据创建的具体maven工程引入）

   ```java
   <dependency>
               <groupId>com.codewater</groupId>
               <artifactId>gmall-interface</artifactId>
               <version>1.0-SNAPSHOT</version>
           </dependency>
   ```

   





## user-service-provider

用户下订单的具体实现（**提供者类型**）

相当于一个远程

1. pom中需要引入gmall的依赖（根据创建的具体maven工程引入）

   ```java
   <dependency>
               <groupId>com.codewater</groupId>
               <artifactId>gmall-interface</artifactId>
               <version>1.0-SNAPSHOT</version>
           </dependency>
   ```





# 使用springBoot实现



## boot-user-service-provider

生产方，复制上面maven工程中的对应实体类

1. 加入对应的实体类依赖

```java
<dependency>
            <groupId>com.codewater</groupId>
            <artifactId>gmall-interface</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
```

2. 原来的xml配置到properties中去配置

3. `@Service`暴露服务（dubbo的）

4. 测试哪个配置生效是，vm的配置在这里

   ![image-20220612224828361](pictures/image-20220612224828361.png)

   可以看到是vm的配置优先生效

   ![image-20220612225030033](pictures/image-20220612225030033.png)

5. 



## boot-order-service-consumer

消费方，复制上面maven工程中的对应实体类。这个是一个web工程

1. 加入对应的实体类依赖

2. 改properties的配置

3. 写controller的方法

   `@Reference`：消费服务，远程引用

4. 启动，浏览器：localhost:8081/initOrder?uid=1会出现对应的用户地址信息

   

# 配置

1. 本地存根，符合条件，消费方就继续调用，不符合，就不远程调用。需要配置文件和实现类。

   一般放在远程接口项目里面，本例就是gmall项目中

2. 对于boot项目，如果想要更加精确的配置，还是需要原生的xml配置，properties配置就不用

3. 引入服务容错`Hystrix`依赖的时候，处理这个

   ```java
   <dependency>
               <groupId>org.springframework.cloud</groupId>
               <artifactId>spring-cloud-starter-netflix-hystrix</artifactId>
               <version>1.4.4.RELEASE</version>
           </dependency>
   
   ```

   还需要在`project`标签下引入这个插件

   ```java
   <dependencyManagement>
   		<dependencies>
   			<dependency>
   				<groupId>org.springframework.cloud</groupId>
   				<artifactId>spring-cloud-dependencies</artifactId>
   				<version>Finchley.SR1</version>
   				<type>pom</type>
   				<scope>import</scope>
   			</dependency>
   		</dependencies>
   	</dependencyManagement>
   ```

   > 没启动成功。可能是因为cloud没有配什么东西把。也没有学过。。。搜到的相关的cloud的依赖问题，但是尚硅谷的也只是一个boot项目。。。。

4. 