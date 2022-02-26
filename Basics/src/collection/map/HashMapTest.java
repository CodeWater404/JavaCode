package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ： CodeWater
 * @create ：2022-02-23-13:26
 * @Function Description ：
 * 测试keySet返回的set集合是set接口还是具体的实现类.--------？？？？？？？？？？？
 * 
 * 疑问：Map<Student , String> map = new HashMap<Student , String>();
 *      Set<Student> keySet = map.keySet();
 *      set是个接口，不可以被实例化，为什么map.keySet()可以赋给set
 *      而不是实现类HashSet<Student> keySet = map.keySet();
 *      接口可以接受数据？
 * 
 */
public class HashMapTest {
    public static void main(String[] args){
        
        Map<Student , String> map = new HashMap<Student , String>();
        
        map.put(new Student("lisi" , 28) , "上海");
        map.put(new Student("wangwu" , 22) , "北京");
        map.put(new Student("zhaoliu" , 25) , "广东");
        
        Set<Student> keySet = map.keySet();
//        获取元素，用keySet获取所有键集合，？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
        for(Student key : keySet){
//            获取值
            String value = map.get( key );
            System.out.println(key.toString() + "---" + value);
        }
        
    }
}

