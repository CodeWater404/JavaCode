package leetCode.subject.number901_950;

import java.util.Arrays;

/**
 * @author ： CodeWater
 * @create ：2022-05-03-15:37
 * @Function Description ：937
 * 字符在前，存储部分按照字典序，字典序一样在按照标识符部分；数组在字符后，不动
 */
public class _937RearrangeLogFiles {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            int length = logs.length;
            // 初始化pair类型
            Pair[] arr = new Pair[length];
            for (int i = 0; i < length; i++) arr[i] = new Pair(logs[i], i);
            // 按照指定的规则进行pair排序与
            Arrays.sort(arr, (a, b) -> logCompare(a, b));
            // 获取排好序之后的字符log
            String[] reordered = new String[length];
            for (int i = 0; i < length; i++) reordered[i] = arr[i].log;

            return reordered;
        }

        // 比较规则
        public int logCompare(Pair pair1, Pair pair2) {
            // 获取
            String log1 = pair1.log, log2 = pair2.log;
            int index1 = pair1.index, index2 = pair2.index;
            // log按照空格拆分成2份
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            // 判断第二部分是不是数字
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (isDigit1 && isDigit2) {
                // 如果都是数字，按照原样返回
                return index1 - index2;
            }
            // 如果都是字符
            if (!isDigit1 && !isDigit2) {
                // 比较log切割第二部分信息的第一个开头字符，按照字典序（相等0， 大于1，小于-1）
                int sc = split1[1].compareTo(split2[1]);
                if (sc != 0) {
                    // 两字符不相等，
                    // return 1 时，按照从小到大排序 （也可以是2，3.....正数）
                    // return 0 时，原位置不动
                    // return-1 时，按照从大到小排序
                    return sc;
                }
                // log第二部分相等。比较log第一部分的第一个字符
                return split1[0].compareTo(split2[0]);
            }
            // 有一个字符，一个数字，判断pair1是不是数字，是的话升序处理
            return isDigit1 ? 1 : -1;
        }
    }

    // 存储一条日志信息和一个在原字符串中的下标位置
    class Pair {
        String log;
        int index;

        public Pair(String log, int index) {
            this.log = log;
            this.index = index;
        }
    }
}
