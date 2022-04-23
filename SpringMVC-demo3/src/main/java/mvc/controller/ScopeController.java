package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author ： CodeWater
 * @create ：2022-04-09-22:54
 * @Function Description ：
 * 域对象控制器
 */
@Controller
public class ScopeController {
    //    下面几个都是===========================request域==================
//    使用servletAPI向request域对象共享数据
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request) {
        request.setAttribute("testRequestScope", "hello , servletAPI");
        return "success";
    }

    //这个方法返回值必须是modelAndView。=============ModelAndView比较重要！！！==================
//    因为下面的都是modelAndView最后封装的
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即向请求域request共享数据
        mav.addObject("testRequestScope", "hello, ModelAndView");
        //设置视图名称
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello , model ");
//        输出的是内容
//        System.out.println( "Model: " + model );
//        输出的是类型（实现类的全类名）,通过反射来获取的
        System.out.println("Model: " + model.getClass().getName());
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("testScope", "hello , map");
//        输出的是内容
//        System.out.println("Map:" + map );
//        输出的是类型（实现类的全类名）,通过反射来获取的
        System.out.println("map: " + map.getClass().getName());
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello ,ModelMap");
//        输出的是内容
//        System.out.println( "ModelMap:" + modelMap );
//        输出的是类型（实现类的全类名）,通过反射来获取的
        System.out.println("ModelMap:" + modelMap.getClass().getName());
        return "success";
    }

    //  ================session域对象=============================
    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope", "hello , session ");
        return "success";
    }

    //   =====================ServletContext域或者叫Application，整个应用范围================
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testAppplicationScope", "hello, application");
        return "success";
    }


}
