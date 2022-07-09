package offer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ： CodeWater
 * @create ：2022-07-09-15:33
 * @Function Description ：41.数据流中的中位数
 */
public class _41TheMedianInTheDataStream {
    class MedianFinder {
        Queue<Integer> a , b;
        /** initialize your data structure here. */
        public MedianFinder() {
            // a小根堆，放一半大的元素； b大根堆， 放一半小的元素
            a = new PriorityQueue<>();
            b = new PriorityQueue<>( (x , y) -> y - x );
        }

        // =================顺序调换为何会错？？？=====================
        public void addNum(int num) {
            if( a.size() != b.size() ){
// 长度不等时，先放入小根堆，然后自动排序调整后，把a堆顶最小的元素放入b。顺序不可变
/*
先放入a找出最小的元素，然后放入b
*/
                a.offer( num );
                b.offer( a.poll() );
            }else{
                // ab长度相等时，再放一个元素就不等，返回中间值
                b.offer( num );
                a.offer( b.poll() );
            }
        }

        public double findMedian() {
            return a.size() != b.size() ? a.peek() : (a.peek() + b.peek() ) / 2.0 ;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
