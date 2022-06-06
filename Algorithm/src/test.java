import org.junit.Test;

import java.text.NumberFormat;

/**
 * @author ： CodeWater
 * @create ：2022-04-08-14:49
 * @Function Description ：测试一些疑问
 */
public class test {

    @Test//测试整数数组元素加1个char数组元素，的结果是啥
    public void test() {
        int[] a = {1, 2, 3};
        char[] b = {'a', 'b'};
        System.out.println((int) b[0]);
        a[0] += b[0];
//        char会自动转成对应的ascii码值，然后跟int变量相加
        System.out.println(a[0]);
    }

    @Test//测试二维数组的length是什么东西 ---->  行数（也对，二维其实相当于一维数组元素是个数组）
    public void test2() {
        int[][] a = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(a.length);//3二维的行数
        System.out.println(a[1].length);//2二维的列数
    }

    //测试取模:1000000007
    //1e9就是10的9次方整数，只不过是浮点数表示的
    @Test
    public void test3(){
//        double a = (1e9 );
        
        String a = scientificNotation2String( 1e9 , 10 );
        System.out.println( a );
    }

    public static String scientificNotation2String(Double d, int newValue) {
        String value = null;
        NumberFormat nf = NumberFormat.getInstance();
        // 设置此格式中不使用分组
        nf.setGroupingUsed(false);
        // 设置数的小数部分所允许的最大位数。
        nf.setMaximumFractionDigits(newValue);
        value = nf.format(d);
        return value;
    }

}
