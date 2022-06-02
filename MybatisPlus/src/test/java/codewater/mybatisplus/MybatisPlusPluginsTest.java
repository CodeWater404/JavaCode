package codewater.mybatisplus;

import codewater.mybatisplus.mapper.ProductMapper;
import codewater.mybatisplus.mapper.UserMapper;
import codewater.mybatisplus.pojo.Product;
import codewater.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ： CodeWater
 * @create ：2022-06-01-20:44
 * @Function Description ：
 * 分页： 有两种写法
 *       // 查询第1-10条数据 
 *          SELECT*FROM Student LIMIT 0,10;
 *         //查询第11-20条数据
 *         SELECT*FROM Student LIMIT 10OFFSET 10;
 * 
 * 第1页：第1~10条，SQL写法：LIMIT 0,10
 * 第2页：第11~20条，SQL写法：LIMIT 10,10
 * 第3页：第21~30条，SQL写法：LIMIT 20,10
 */
@SpringBootTest
public class MybatisPlusPluginsTest {
    
    @Autowired
    private UserMapper userMapper ;

    @Autowired
    private ProductMapper productMapper;
    
    
    /**
     * 分页
     */
    @Test
    public void testPage(){
        //第一页  三条数据
        //SELECT id,name,age,email,is_deteled FROM t_user WHERE is_deteled=0 LIMIT ?,?
        Page<User> page = new Page<>( 2 , 3);
        userMapper.selectPage( page , null );
        System.out.println( page );  //直接打印的内存地址
        System.out.println( page.getRecords() );   //获取当前页的数据
        System.out.println( page.getPages() );  //获取总页数
        System.out.println( page.hasNext() );   //是否有下一页
        System.out.println( page.hasPrevious() );  //是否有上一页
        
    }

    /**
     * 测试自定义sql的分页
     */
    @Test
    public void testPageVo(){
        //还是设置当前页的页码， 和页数
        Page<User> page = new Page( 1 , 3 );
        userMapper.selectPageVo( page , 20 );
        System.out.println( page );  //直接打印的内存地址
        System.out.println( page.getRecords() );   //获取当前页的数据
        System.out.println( page.getPages() );  //获取总页数
        System.out.println( page.hasNext() );   //是否有下一页
        System.out.println( page.hasPrevious() );  //是否有上一页
    }

    /**
     * 使用乐观锁，原本100+50 -30 =120 ，但是最终会出现70
     * 需要在配置类中添加乐观锁插件
     */
    @Test
    public void testProduct01(){
        //小李查询商品价格
        Product productLi = productMapper.selectById( 1 );
        System.out.println( "Li: " + productLi.getPrice() );
        
        //小王查询商品价格
        Product productWang = productMapper.selectById( 1 );
        System.out.println( "Wang: " + productWang.getPrice() );

        //小李将商品价格+50
        productLi.setPrice( productLi.getPrice() + 50 );
        productMapper.updateById( productLi );

        //小王将商品价格-30
        productWang.setPrice( productWang.getPrice() - 30 );
        int result = productMapper.updateById( productWang );  // -------从这里开始修改，优化
        
        if( result == 0 ){ 
            //操作失败，重试
            Product productNew = productMapper.selectById( 1 );
            productNew.setPrice( productNew.getPrice() - 30 );
            productMapper.updateById( productNew );
        }
        
        //老板查询商品价格
        Product productBoss = productMapper.selectById( 1 );
        System.out.println( "Boss：" + productBoss.getPrice() );
    }
}
