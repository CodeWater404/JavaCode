package boot.controller;

import boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author ： CodeWater
 * @create ：2022-04-28-17:52
 * @Function Description ：
 */
@Controller
public class ResponseTestController {

    @ResponseBody
    @GetMapping("/test/person")
    public Person getPerson() {
        Person person = new Person();
        person.setAge(238);
        person.setBirth(new Date());
        person.setUserName("zhangsan");

        return person;
    }
}
