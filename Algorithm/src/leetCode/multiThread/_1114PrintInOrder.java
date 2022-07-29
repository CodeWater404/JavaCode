package leetCode.multiThread;

/**
 * @author ： CodeWater
 * @create ：2022-07-29-16:56
 * @Function Description ：1114.按序打印
 * 
 */
public class _1114PrintInOrder {
    class Foo {

        private boolean firstFinished = false;
        private boolean secondFinished = false;
        private Object lock = new Object();

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized(lock){
                printFirst.run();
                firstFinished = true;
                lock.notifyAll();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.

        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized( lock ){
                while( !firstFinished ){
                    lock.wait();
                }
                printSecond.run();
                secondFinished = true;
                lock.notifyAll();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.

        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized(lock){
                while( !secondFinished ){
                    lock.wait();
                }
                printThird.run();
            }
            // printThird.run() outputs "third". Do not change or remove this line.

        }
    }
}
