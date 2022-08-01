package leetCode.multiThread;

import java.util.function.IntConsumer;

/**
 * @author ： CodeWater
 * @create ：2022-08-01-16:28
 * @Function Description ：1195. 交替打印字符串
 */
public class _1195AlternatePrintString {
    class FizzBuzz {
        private int n;
        private volatile int state = 0;

        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            // 注意for间隔，省力
            for( int i = 3 ; i <= n ; i += 3 ){
                //15的倍数不处理，交给fizzbuzz()方法处理
                if( i % 15 == 0 ) continue;
                while( state != 3 )
                    Thread.yield();//让当前线程暂停

                printFizz.run();
                state = 0 ;

            }

        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            for( int i = 5 ; i <= n ; i += 5 ){
                if( i % 15 == 0 ) continue;
                while( state != 5 )
                    Thread.yield();

                printBuzz.run();
                state = 0;
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            for( int i = 15 ; i <= n ; i += 15 ){
                while( state != 15 )
                    Thread.yield();

                state = 0;
                printFizzBuzz.run();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            for( int i = 1 ; i <= n ; i++ ){
                while( state != 0 )
                    Thread.yield();
                if( i % 3 != 0 && i % 5 != 0 )
                    printNumber.accept(i);
                else{
                    // 能够被谁模成0就让哪个线程来处理
                    if( i % 15 == 0 )
                        state = 15;
                    else if( i % 5 == 0 )
                        state = 5;
                    else if( i % 3 == 0 )
                        state = 3;
                }
            }
        }
    }
}
