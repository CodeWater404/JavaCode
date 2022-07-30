package leetCode.multiThread;

import java.util.function.IntConsumer;

/**
 * @author ： CodeWater
 * @create ：2022-07-30-16:42
 * @Function Description ：1116. 打印零与奇偶数
 */
public class _1116PrintZeroAndStrangeNumber {
    class ZeroEvenOdd {
        private int n;
        private Object lock = new Object();
        private int state = 0 ;


        public ZeroEvenOdd(int n) {
            this.n = n;

        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for( int i = 0 ; i < n ; i++ ){
                synchronized( lock ){
                    while( state  != 0 ){
                        lock.wait();
                    }
                    printNumber.accept(0);
//                    0打印完，就是奇偶交替打印，先是奇
                    if( i % 2 == 0 ){
                        state = 1;
                    }else{
                        state = 2;
                    }
                    lock.notifyAll();
                }
            }

        }

        // 偶数出现在0之后
        public void even(IntConsumer printNumber) throws InterruptedException {
            for( int i = 2 ; i <= n ; i += 2 ){
                synchronized(lock){
                    while( state  != 2  ){
                        lock.wait();
                    }
                    printNumber.accept(i);
//                    偶数打印完是0
                    state = 0;
                    lock.notifyAll();
                }
            }
        }

        // 奇数出现在0之后
        public void odd(IntConsumer printNumber) throws InterruptedException {
            for( int i = 1 ; i <= n ; i += 2 ){
                synchronized(lock){
                    while( state  != 1  ){
                        lock.wait();
                    }
                    printNumber.accept( i );
//                    奇数打印完，是0
                    state = 0 ;
                    lock.notifyAll();
                }
            }
        }
    }
}
