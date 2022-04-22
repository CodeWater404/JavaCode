package boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ： CodeWater
 * @create ：2022-04-21-17:00
 * @Function Description ：
 * 测试boot的扫描机制：只扫描主程序（@SpringBootApplication标记的）及其子包
 */
@Controller
public class WorldController {
    

    @RequestMapping("/w")
    public String world(){
        return "world";
    }
}
