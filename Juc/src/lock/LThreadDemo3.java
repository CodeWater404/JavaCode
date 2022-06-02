package lock;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ： CodeWater
 * @create ：2022-06-02-21:28
 * @Function Description ：list和set集合线程不安全演示：ConcurrentModificationException并发修改异常
 * 解决方案有三种，第一、二种不常用
 */
public class LThreadDemo3 {
    
    public static void main(String[] args ) {
        //创建ArrayList集合--------------线程不安全
//        List<String> list = new ArrayList<>();
        
        //-----------第一种：vector是线程安全的
//        List<String> list = new Vector<>();  
        
        //----------第二种：Collections.synchronizedList返回安全的同步列表
//        List<String> list = Collections.synchronizedList( new ArrayList<>() );
        
        //---------第三种：CopyOnWriteArrayList(写时复制技术)
//        List<String> list = new CopyOnWriteArrayList<>();
//        for( int i = 0 ; i < 30 ; i++ ){
//            new Thread( () -> {
//                //向集合添加内容-----add方法没有synchronized
//                list.add( UUID.randomUUID().toString().substring(0 , 8) );
//                //从集合获取内容----------并发修改异常发生在这里，因为可能还没放进去就要读取。。。
//                System.out.println( list );
//            } , String.valueOf( i ) ).start();
//        }

        //-------------------------------set演示及解决----------------------------
        //-------------set.add不安全
//        Set<String> set = new HashSet<>();
        
        //------------第一种解决：CopyOnWriteArraySet
//        Set<String> set = new CopyOnWriteArraySet<>();
//        for( int i = 0 ; i < 30 ; i++ ){
//            new Thread( () -> {
//                //向集合添加内容-----add方法没有synchronized
//                set.add( UUID.randomUUID().toString().substring(0 , 8) );
//                //从集合获取内容----------并发修改异常发生在这里，因为可能还没放进去就要读取。。。
//                System.out.println( set );
//            } , String.valueOf( i ) ).start();
//        }

        //-------------------------------map演示及解决----------------------------
        //hashMap不安全
//        Map<String , String> map = new HashMap<>();
        
        //-------------第一种解决：ConcurrentHashMap
        Map<String , String> map = new ConcurrentHashMap<>();
        for( int i = 0 ; i < 30 ; i++ ){
            String key = String.valueOf( i );
            new Thread( () -> {
                //向集合添加内容-----add方法没有synchronized
                map.put( key , UUID.randomUUID().toString().substring(0 , 8) );
                //从集合获取内容----------并发修改异常发生在这里，因为可能还没放进去就要读取。。。
                System.out.println( map );
            } , String.valueOf( i ) ).start();
        }
    }
    
}
