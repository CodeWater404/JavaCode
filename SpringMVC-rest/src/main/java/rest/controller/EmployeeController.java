package rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rest.bean.Employee;
import rest.dao.EmployeeDao;

import java.util.Collection;

/**
 * @author ： CodeWater
 * @create ：2022-04-11-20:37
 * @Function Description ：
 */
@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeDao employeeDao;
    
    @RequestMapping(value="/employee" , method= RequestMethod.GET)
    public String getEmployee(Model model){
        Collection<Employee> employeeList = employeeDao.getAll();
        model.addAttribute("employeeList" , employeeList );
        return "employee_list";
    }
    
    @RequestMapping(value="/employee/{id}" , method=RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
//        删除后重定向到列表
        return "redirect:/employee";
    }
    
    @RequestMapping(value="/employee" , method=RequestMethod.POST)
    public String addEmployee( Employee employee ){
        employeeDao.save( employee );
        return "redirect:/employee";
    }
    
//   获取对应的用户信息显示在employee——update，然后再用employee——update里面表单的提交来更新用户
    @RequestMapping(value="/employee/{id}" , method=RequestMethod.GET)
    public String getEmployeeNyId(@PathVariable("id") Integer id , Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee" , employee );
        return "employee_update";
    }
    
    @RequestMapping(value="/employee" , method=RequestMethod.PUT)
    public String updateEmployee( Employee employee ){
        employeeDao.save( employee );
        return "redirect:employee";
    }
    
}
