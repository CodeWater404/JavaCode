package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ： CodeWater
 * @create ：2022-06-02-23:19
 * @Function Description ：比较runnable接口和callable接口
 * FutureTask类实现了Runnable，构造方法中有Callable
 */

//runnable
class MyThread1 implements Runnable{
    @Override
    public void run(){
        
    }
}

//callable
class MyThread2 implements Callable {
    @Override
    public Integer call() throws Exception {
        System.out.println( Thread.currentThread().getName() + "  come in callable " );
        return 200;
    }
}

public class Demo1 {
    
    public static void main(String[] args ) throws ExecutionException, InterruptedException {
        //Runnable接口创建线程
        new Thread( new MyThread1() , "A" ).start();

        //Callable接口,报错
//        new Thread( new MyThread2() , "B" ).start();
        
        //使用FutureTak类  构造参数是MyThread2
        FutureTask<Integer> futureTask1 = new FutureTask<>( new MyThread2() );
        
        //lambda表达式对FutureTask进行简化创建
        FutureTask<Integer> futureTask2 = new FutureTask<>( () -> {
            System.out.println( Thread.currentThread().getName() + "  come in callable" );
            return 1024;
        }) ;
        
        //创建一个线程
        new Thread( futureTask2  , "lucy" ).start();
        
        //判断futureTask2是否完成，没有就一直打印
        while( !futureTask2.isDone() ){
            System.out.println( "wait............" );
        }
        
        //调用FutureTask的get方法
        System.out.println( futureTask2.get() );
        
        //第一次计算好之后，第二次再拿结果就不用再计算了（也就是不糊在打印），直接输出结果 
        System.out.println( futureTask2.get() );
        
        System.out.println( Thread.currentThread().getName() + "  come over" );
        
        //FutureTask（未来任务）原理
        /**
         * 1、老师上课，口渴了，去买票不合适，讲课线程继续。
         *   单开启线程找班上班长帮我买水，把水买回来，需要时候直接get
         *
         * 2、4个同学， 1同学 1+2...5   ，  2同学 10+11+12....50， 3同学 60+61+62，  4同学 100+200
         *      第2个同学计算量比较大，
         *     FutureTask单开启线程给2同学计算，先汇总 1 3 4 ，最后等2同学计算位完成，统一汇总
         *
         * 3、考试，做会做的题目，最后看不会做的题目
         *
         * 汇总一次
         *
         */
    }
}
