package leetCode.multiThread;

/**
 * @author ： CodeWater
 * @create ：2022-07-31-21:37
 * @Function Description ：1117.H2O 生成
 */
public class _1117H2OGeneration {
    class H2O {
        private volatile int state = 0 ;
        private Object lock = new Object();

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            synchronized(lock){
                // state等于2，说明对于H来说，已经有了2个；阻塞当前H线程
                while( state == 2 ){
                    lock.wait();
                }
                // H线程不满2个的时候可以执行，state对应相加
                state++;
                releaseHydrogen.run();
                lock.notifyAll();
            }


        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            synchronized(lock){
                // 在O线程里面，state不等于2，说明H还不满，所以需要阻塞O线程
                while( state != 2 ){
                    lock.wait();
                }
                // state等于2满足H，这个时候可以执行O线程，同时重置state。组合一个H2O
                state = 0;
                releaseOxygen.run();
                lock.notifyAll();
            }


        }
    }
}
