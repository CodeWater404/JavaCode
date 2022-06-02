package sync;

/**
 * @author ： CodeWater
 * @create ：2022-06-02-17:52
 * @Function Description ：线程间的通信: +1 和-1动作交替进行
 * 步骤：
 * 1.第一步 创建资源类，定义属性和操作方法
 * 2.第二步 判断 干活 通知
 * 3.第三步 创建多个线程，调用资源类的操作方法
 * 4.第四步 防止虚假唤醒，需要使用while
 */

//第一步 创建资源类，定义属性和操作方法
class Share{
    //初始值
    private int number = 0 ;

    //+1的方法
    public synchronized void incr() throws  InterruptedException {
        //第二步 判断 干活 通知     
        while( number != 0 ){//判断number值是否是0，如果不是0，等待
            /* wait会释放锁：当前线程等待之后，就会把锁释放
            * 如果使用if会形成虚假唤醒：在这里等待之后，如果再次唤醒，那么就会继续执行下去 。但其实是要当条件满足的时候才能继续执行下去，
            * 而不是一唤醒之后就继续执行下去。
            * 所以使用while
            * */
            this.wait() ;//在哪里睡，就在哪里醒   
        }

        //如果number值是0，就+1操作
        number ++;
        System.out.println( Thread.currentThread().getName() + "::" + number );
        //通知其他线程  不用all是随机通知一个
        this.notifyAll();  
    }

     //-1的方法
    public synchronized void decr() throws InterruptedException {
        //判断
        while( number != 1 ){
            this.wait();
        }
        //干活
        number--;
        System.out.println( Thread.currentThread().getName() + "::" + number );
        
        //通知其他线程
        this.notifyAll();
        
    }
}
 
public class ThreadDemo {
    //第三步 创建多个线程，调用资源类的操作方法
    public static void main(String[] args ) {
        Share share = new Share();
        
        //创建线程
        new Thread( () -> {
            for( int i = 0 ; i <= 10 ; i++ ){
                try{
                    share.incr(); //+1
                }catch( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "AA" ).start();
        
        new Thread( () ->{
            for( int i = 0 ; i <= 10 ; i++ ){
                try{
                    share.decr();  //-1
                    
                }catch( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "BB" ).start();

        new Thread( () ->{
            for( int i = 0 ; i <= 10 ; i++ ){
                try{
                    share.incr();  //-1

                }catch( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "CC" ).start();

        new Thread( () ->{
            for( int i = 0 ; i <= 10 ; i++ ){
                try{
                    share.decr();  //-1

                }catch( InterruptedException e ){
                    e.printStackTrace();
                }
            }
        } , "DD" ).start();
    }   
    
 
}
