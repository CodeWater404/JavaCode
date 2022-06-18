package acwing.basic.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-13:38
 * @Function Description ：905.区间选点
 */


public class _905SectionPointSelection 
    public static int N = 100010;
    public static Range[] range = new Range[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);

        //读入区间
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            int l = Integer.parseInt(str[0]), r = Integer.parseInt(str[1]);
            range[i] = new Range(l, r);
        }

// Arrays.sort(range);//这种不行会报空指针异常，range一开始声明的时候就是N个，但实际只有n个对象
        Arrays.sort(range, 0, n);//指定范围

        /*如果实现的结构体对象没有实现接口，需要在sort的时候自定义规则,记得导入Comparator接口
          Arrays.sort(range , 0 , n , new Comparator<Range>(){
            @Override
            public int compare(Range s1,Range s2)
            {
                return s1.r-s2.r;
            }
        });
        使用lambda表达式，更简洁： 
        Arrays.sort( range , 0 , n , (o1 , o2) -> o1.r - o2.r );

        */


        // res最优解  ， ed上一个选择点的下标
        int res = 0, ed = (int) -2e9;
        // 从前往后枚举所有的区间
        for (int i = 0; i < n; i++) {
            // 如果当前区间的左端点严格大于上一个区间的右端点，选择该区间右端点更新
            if (range[i].l > ed) {
                res++;
                ed = range[i].r;
            }

        }

        System.out.println(res);
    }
    

}

//定义一个区间的结构体(第一种自定义排序实现接口)
class Range implements Comparable<Range> {
    int l, r;

    public Range(int l, int r) {
        this.l = l;
        this.r = r;
    }

    public int compareTo(Range o) {
        // return Integer.compare(r , o.r );//两种写法差不多
        return r - o.r;
    }
}