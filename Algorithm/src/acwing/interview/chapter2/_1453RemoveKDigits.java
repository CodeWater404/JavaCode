package acwing.interview.chapter2;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author ： CodeWater
 * @create ：2022-06-24-1:35
 * @Function Description ：1453.移掉k位数字
 */
public class _1453RemoveKDigits {

    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in) ;
        String num = sc.next();
        int k = sc.nextInt();
        // 答案初始赋值0，减少判断特殊的情况
        String res = "0";
        // 从前往后扫描每一位
        for( int i = 0 ; i < num.length() ; i++ ){
            // 只要k还大于0并且遍历的当前数字的第i位小于答案res的最后一位，就一直删除res的最后一位
            while( k > 0 && num.charAt(i) < res.charAt(res.length() - 1 ) ){
                // res去掉最后一个字符
                res = res.substring( 0 , res.length() - 1) ;
                k --;
            }
            // 退出while后，在res的后面加上num当前位
            res = res.concat( String.valueOf(num.charAt(i)) );

        }

        // k还没有归0，res就一直删除最后几位
        while(k-- > 0 ) res = res.substring(0, res.length() - 1);
        int i = 0;
        // 标记前导0的位置
        while(i < res.length() && res.charAt(i) == '0' ) i++;

        // res为0，也就是res全是0，用i和res的长度来判断
        if( i == res.length() ) System.out.println("0");
        else {
            // 取出前导0
            res = res.substring(i , res.length() ) ;
            System.out.println(res);
        }
    }
    
}
