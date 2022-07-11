package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ： CodeWater
 * @create ：2022-07-10-12:10
 * @Function Description ：55.1 二叉树的深度
 */
public class _55_1TheDepthOfTheBinaryTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    //==========================bfs============================
    class Solution {
        public int maxDepth(TreeNode root) {
            if( root == null ) return 0;
//            queue本层结点， temp下一层结点
            List<TreeNode> queue = new LinkedList<>(){{ add(root); }} , temp;
            int res = 0;
            while( queue.size() != 0 ){
                temp = new LinkedList<>();
                for( TreeNode node : queue ){
//                    扫描本层结点的孩子结点，添加到temp中
                    if( node.left != null ) temp.add(node.left);
                    if( node.right != null ) temp.add(node.right);
                }
//                队列换成下一层的结点
                queue = temp;
                res++;
            }
            return res;
        }
    }
    
    
    //==========================递归后序遍历============================
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if( root == null ) return 0;
            return Math.max( maxDepth(root.left) , maxDepth(root.right) ) + 1;
        }
    }
    
    /*
    * public class HashMapInitializeDemo {

    /1**
     * HashMap初始化 使用匿名内部类的方式
     *1/
    public static void initialize() {
        HashMap<String, Integer> map = new HashMap<String, Integer>() {{
            put("a", 1);
            put("b", 2);
            put("c", 3);
        }};
    }

    static class Num {

        public Num() {

            System.out.println("initialize num");
        }

        void put() {
            System.out.println("put something");

        }
    }

    public static void main(String[] args) {
        //这是匿名内部类的写法，第一个大括号是代表类，第二个大括号代表匿名内部类的初始化代码块。 
        这种语法表示该匿名内部类继承了Num类，还有我们经常使用匿名内部类来作为接口的实现类，作为方法入参。
     

        // 1.匿名内部类不能是抽象类，因为系统在创建匿名内部类时，会立即创建匿名内部类的对象，因此不允许
        将匿名内部类定义为抽象类。
     

        // 2.匿名内部类不能定义构造器（Constructor），由于匿名内部类没有类名，所以无法定义构造器，但匿名
        构造类可以定义初始化块，可以通过实例初始化块来完成构造函数需要完成的部分。
     
        Num num = new Num() {{
            put();
        }};

        Num num1 = new Num() {{
            System.out.println("create num");
        }};

        List<String> list = new LinkedList<String>() {{
            add("a");
            add("b");
        }};
        System.out.println(list.get(0));

        List<String> list1 = new LinkedListAnonymity<>();
        System.out.println(list1.get(0));
    }

    /1**
     * LinkedListAnonymity
     * new LinkedListAnonymity<>(); 等同于HashMapInitializeDemo中的匿名类  List<String> list = new LinkedList<String>(){{add("a");add("b");}};
     * @param <T>
     *1/
    static class LinkedListAnonymity<T> extends LinkedList<T> {
    public LinkedListAnonymity() {
    add((T) "a");
    add((T) "b");
    }
    }

    }

     */
}
