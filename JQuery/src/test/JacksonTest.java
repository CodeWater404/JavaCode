package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.FileWriter;
import java.util.*;

/**
 * @author ： CodeWater
 * @create ：2022-03-22-16:56
 * @Function Description ：
 * java转成json
 */
public class JacksonTest {
    @Test
    public void test1() throws Exception {
        //1.创建person对象
        Person p = new Person();
        p.setName("张三");
        p.setAge( 23 );
        p.setGender( "男" );

        //2.创建Jackson的核心对象  ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //转换
 /* 转换方法：
                writeValue(参数1，obj):
                    参数1：
                        File：将obj对象转换为JSON字符串，并保存到指定的文件中
                        Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                        OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
                writeValueAsString(obj):将对象转为json字符串
 */
        String json = mapper.writeValueAsString( p );
        //{"name":"张三","age":23,"gender":"男"}
//        System.out.println( json );

        //writeValue，将数据写到d://a.txt文件中
//        mapper.writeValue( new File( "E://JavaCode//JQuery//src//test//a.txt" ) , p );

        //writeValue.将数据关联到Writer中
        mapper.writeValue( new FileWriter( "E://JavaCode//JQuery//src//test//b.txt" ) , p );
        
    }
    
// 注解：   属性设置成固定格式
    @Test
    public void test2() throws Exception {
        Person p = new Person();
        p.setName( "zhansgan" );
        p.setAge( 23 );
        p.setGender( "nan" );
        p.setBirthday( new Date() );
        
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString( p );
        
//        默认格式：{"name":"张三","age":23,"gender":"男","birthday":1530958029263}
//        System.out.println( json );
        //加了注解@JsonFormat:{"name":"zhansgan","age":23,"gender":"nan","birthday":"2022-03-22"}
        System.out.println( json );
    }
    
//    复杂对象转换，list、map
    @Test
    public void test3() throws Exception {
        Person p = new Person();
        p.setName( "张三" );
        p.setAge( 23 );
        p.setGender( "男" );
        p.setBirthday( new Date() );

        Person p1 = new Person();
        p1.setName( "张三" );
        p1.setAge( 23 );
        p1.setGender( "男" );
        p1.setBirthday( new Date() );

        List<Person> ps = new ArrayList<Person>();
        ps.add( p );
        ps.add( p1 );
        
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString( ps );
//[{"name":"张三","age":23,"gender":"男","birthday":"2022-03-22"},{"name":"张三","age":23,"gender":"男","birthday":"2022-03-22"}]
        System.out.println( json );
    }
    
    @Test
    public void test4() throws Exception {
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("name" , "zhangsan" );
        map.put("age" , 23 );
        map.put("gender" , "nan" );
        
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString( map );
//        {"gender":"nan","name":"zhangsan","age":23}
        System.out.println( json );
        
    }

    //演示 JSON字符串转为Java对象
    @Test
    public void test5() throws Exception {
        //1.初始化JSON字符串
        String json = "{\"gender\":\"男\",\"name\":\"张三\",\"age\":23}";
        
        ObjectMapper mapper = new ObjectMapper();
        Person p = mapper.readValue( json , Person.class );
        
        System.out.println( p );
    }
}
