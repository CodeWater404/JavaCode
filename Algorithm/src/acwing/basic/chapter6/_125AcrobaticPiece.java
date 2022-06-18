package acwing.basic.chapter6;

import acwing.basic.chapter3.PII;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-06-18-16:21
 * @Function Description ：125.帅杂技的牛
 */
class PII {
    // ws重量+强壮程度之和，w重量
    int ws, w;

    public PII(int ws, int w) {
        this.ws = ws;
        this.w = w;
    }
}

public class _125AcrobaticPiece {

    public static int N = 50010, n;
    public static PII[] cow = new PII[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        for (int i = 0; i < n; i++) {
            str = br.readLine().split(" ");
            int w = Integer.parseInt(str[0]), s = Integer.parseInt(str[1]);
            cow[i] = new PII(w + s, w);
        }

        Arrays.sort(cow, 0, n, (o1, o2) -> o1.ws - o2.ws);

        // res答案 ， sum当前牛身上压的所有牛的重量之和
        int res = (int) -2e9, sum = 0;
        // 遍历所有的牛
        for (int i = 0; i < n; i++) {
            // w当前牛的重量  s当前牛的强壮程度
            int w = cow[i].w, s = cow[i].ws - w;
            // 当前牛身上压的所有重量减去自身的强壮程度
            res = Math.max(res, sum - s);
            sum += w;
        }

        System.out.println(res);
    }

}
