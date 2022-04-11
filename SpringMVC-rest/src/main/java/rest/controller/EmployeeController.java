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
        return "redirect:/employee";
    }
    
    
}
