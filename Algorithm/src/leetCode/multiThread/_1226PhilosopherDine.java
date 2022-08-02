package leetCode.multiThread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ： CodeWater
 * @create ：2022-08-02-15:25
 * @Function Description ：1226.哲学家进餐
 */
public class _1226PhilosopherDine {
    class DiningPhilosophers {

        // 1个叉子对应一个ReentrantLock
        private final ReentrantLock[] lockList = {new ReentrantLock() , new ReentrantLock(), new ReentrantLock() , new ReentrantLock() , new ReentrantLock() };

        // 最多只有4个哲学家持有叉子
        private Semaphore eatLimit = new Semaphore(4);

        public DiningPhilosophers() {

        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {
//    leftFork左边叉子的编号 ； rightFork右边的
            int leftFork = ( philosopher + 1 ) % 5 ;
            int rightFork = philosopher ;

// 限制人数减1
            eatLimit.acquire();

// 拿起左边和右边的叉子
            lockList[ leftFork ].lock();
            lockList[ rightFork ].lock();

//拿起叉子之后的具体执行
            pickLeftFork.run();
            pickRightFork.run();

// 吃意大利面的执行
            eat.run();

// 放下左边和右边叉子的具体执行
            putLeftFork.run();
            putRightFork.run();

// 放下左边和右边的叉子
            lockList[ leftFork ].unlock();
            lockList[ rightFork ].unlock();

// 限制的人数+1
            eatLimit.release();
        }
    }
}
