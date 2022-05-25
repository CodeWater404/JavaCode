# Git

分布式版本控制工具。

- [x] 代码回溯
- [x] 版本切换
- [x] 多人协作
- [x] 远程备份





## 代码托管服务





### 常用git代码托管服务

![image-20220517171546640](pictures/image-20220517171546640.png)





### 使用码云代码托管服务

1. 注册码云账号
2. 登录
3. 创建远程仓库
4. 邀请其他用户成为仓库成员

> 这部分本人有基础，详情不再写了，不会的可以百度搜一下，很多好的教学





## 常用命令



### git全局设置

![image-20220517173745453](pictures/image-20220517173745453.png)





### 获取git仓库

![image-20220517174005671](pictures/image-20220517174005671.png)

第一种：![image-20220517174106782](pictures/image-20220517174106782.png)

第二种：![image-20220517174755052](pictures/image-20220517174755052.png)





### 工作区、暂存区、版本库

![image-20220517174839148](pictures/image-20220517174839148.png)

* add是到暂存区，commit是到版本库（版本库就是`.gitignore`文件里面） ， push是到远程仓库



### git工作区中文件的状态

![image-20220517175316413](pictures/image-20220517175316413.png)





### 本地仓库操作

![image-20220517175446811](pictures/image-20220517175446811.png)

![image-20220517175604813](pictures/image-20220517175604813.png)

> 切换到指定的版本：`git reset --hard 版本号`





### 远程仓库操作



![image-20220517180026530](pictures/image-20220517180026530.png)

![image-20220517180101056](pictures/image-20220517180101056.png)

> `git remote -v`显示更加详细的信息

![image-20220517180307488](pictures/image-20220517180307488.png)

> `git remote add Gitee远程仓库别称（关联多个仓库是可以改一下，一个仓库就origin） url`
>
> 跟远程关联上之后，再用`git push -u 远程仓库别名 "master"`即可推送。master好像可以不加双引号，不知道。。。有兴趣的可以试下。
>
> ![image-20220517215013484](pictures/image-20220517215013484.png)

![image-20220517183524874](pictures/image-20220517183524874.png)

![image-20220517183700868](pictures/image-20220517183700868.png)

> `--allow-unrelated-histories`:允许本地和远程之间无关的历史，直接强制从远程拉下来代码





### 分支操作

![image-20220517210639814](pictures/image-20220517210639814.png)

![image-20220517211017694](pictures/image-20220517211017694.png)

![image-20220517211201829](pictures/image-20220517211201829.png)

* 这里要注意一下，推送到对应的分支，不然会报错！！

* ![image-20220517215335480](pictures/image-20220517215335480.png)

  > 只有一个master分支是，可以不写分支名name，直接`git push 远程仓库名`

![image-20220517211229617](pictures/image-20220517211229617.png)

![image-20220517211912395](pictures/image-20220517211912395.png)

> 需要`先切换到被合并的分支上`，例如：想把b3分支和并到master上，那么要切换会master，在执行命令，就会把b3合并到master上。



* 冲突：不同分支对同一个文件修改合并后产生的问题，合并会失败，这时候需要打开相应的文件，自己手动解决冲突。

  解决前：

![image-20220517212735590](pictures/image-20220517212735590.png)

​		解决后：（根据自己的需要保留内容，不一定都需要）

​	![image-20220517212916393](pictures/image-20220517212916393.png)

更改后保留的内容，再`git add `添加文件即可。如果commit出现`fatal:cannot do a partial commit during a merge.`这个错误，需要再加上`-i`这个参数。

![image-20220517213151357](pictures/image-20220517213151357.png)

处理完之后，再`push`到对应的远程分支上。





### 标签操作

![image-20220517223945486](pictures/image-20220517223945486.png)

> 感觉相当于虚拟机中的快照，保存某一时刻的状态！

![image-20220517224928277](pictures/image-20220517224928277.png)

> 检出标签：变回指定标签的状态，`会创建一个分支`

![image-20220517225225084](pictures/image-20220517225225084.png)

![image-20220517225528737](pictures/image-20220517225528737.png)



==标签和分支==：

> * 标签：是一个静态的概念，打上标签之后，这些文件始终是这个状态
>   * 使用场景： 当一个项目开发到一个差不多的时候，打上一个标签，表示一个版本
>
> * 分支：动态的，在这个分支可以继续开发代码，不断增加新的内容







## 在IDEA中使用Git

基本右键项目，找到`git`选项，看选项就知道了，跟上面命令一样的

![image-20220517234211969](pictures/image-20220517234211969.png)



### 在IDEA中配置git

![image-20220517230542180](pictures/image-20220517230542180.png)

> 就是设置git安装的目录，idea：settings—-》git





### 获取git仓库

![image-20220517231036290](pictures/image-20220517231036290.png)





### 本地仓库操作

![image-20220517231945283](pictures/image-20220517231945283.png)





### 远程仓库操作

![image-20220517233252203](pictures/image-20220517233252203.png)

> 右键项目，找到`git`选项，看选项就明白了了





### 分支操作

![image-20220517233644064](pictures/image-20220517233644064.png)
