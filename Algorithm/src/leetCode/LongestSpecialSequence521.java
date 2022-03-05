package leetCode;

/**
 * @author ： CodeWater
 * @create ：2022-03-05-17:03
 * @Function Description ：最长特殊子序列
 * 
 */
public class LongestSpecialSequence521 {

    public int findLUSlength(String a, String b) {
/*
1.若两字符串不相同，那么我们可以选择较长的字符串作为最长特殊序列
2.当两字符串长度相同时（但不是同一字符串，内容不同），选择其中的一个字符串作为最长特殊序列，
3.若两字符串相同（长度和内容都是一样），那么任一字符串的子序列均会出现在两个字符串中，此时应返回 -1。

// 感觉题目的意思是比较两个字符串的长度谁最长（两个长度相同内容相同返回-1），而不需要比较相同的子串序列
// 比如abcd和abc答案是4；如果比较最长相同的子串序列应该是3
string的equals比较内容
 */
        return !a.equals(b) ? Math.max(a.length(), b.length()) : -1;
    }
}
