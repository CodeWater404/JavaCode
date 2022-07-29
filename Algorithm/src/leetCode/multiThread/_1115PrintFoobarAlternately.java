package leetCode.multiThread;

/**
 * @author ： CodeWater
 * @create ：2022-07-29-16:57
 * @Function Description ：1115.交替打印 FooBar
 */
public class _1115PrintFoobarAlternately {
    class FooBar {
        private int n;
        private boolean finished = false;
        private Object lock = new Object();


        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                synchronized(lock){
                    while( finished ){
                        lock.wait();
                    }
                    printFoo.run();
                    finished = true;
                    lock.notifyAll();
                    // System.out.println( "111" );
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                synchronized(lock){
                    while( !finished ){
                        lock.wait();
                    }
                    printBar.run();
                    finished = false;
                    // 需要唤醒1???
                    lock.notifyAll();
                    // System.out.println( "2222" );
                }


            }
        }
    }
}
