package com.timwang5.controller;

import com.timwang5.dao.EmployeeDao;
import com.timwang5.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAllEmployees();
        model.addAttribute(employees);
        //返回到list页面
        return "emp/list";
    }


}
