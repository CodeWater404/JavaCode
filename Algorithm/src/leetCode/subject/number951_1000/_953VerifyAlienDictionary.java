package leetCode.subject.number951_1000;

/**
 * @author ： CodeWater
 * @create ：2022-05-17-12:14
 * @Function Description ：953
 */
public class _953VerifyAlienDictionary {
    class Solution {
        // 要比较上个单词和下一个单词的每个字符排列顺序是不是按照字母表的顺序来徘
        public boolean isAlienSorted(String[] words, String order) {
            int[] index = new int[26];
            for( int i = 0 ; i < order.length() ; i++ ){
                //下标对应的字母 ，存储的值是order中新定义的顺序
                index[ order.charAt(i) - 'a' ] = i;
            }
            //遍历所有单词
            for( int i = 1 ; i < words.length ; i++ ){
                //标记当前比对的单词顺序是否有效
                boolean vailed = false ;
                //遍历单词中每个字符
                for( int j = 0 ; j < words[i - 1].length() && j < words[i].length() ; j++ ){
                    //前一个单词和后一个单词逐字符比较
                    int prev = index[ words[i - 1].charAt(j) - 'a' ];
                    int curr = index[ words[i].charAt(j) - 'a' ];
                    if( prev < curr ){
                        // 正常字典序
                        vailed = true;
                        break;
                    }else if( prev > curr ){
                        return false;
                    }
                }
                // 出现两个单词比对的长度不一样的情况
                if( !vailed ){
                    //---------------有点不理解为什么不比较前一个单词比后一个单词短的情况--------------

                    if( words[i - 1].length() > words[i].length() ){
                        return false;
                    }
                }
            }

            return true;
        }
    }
}
