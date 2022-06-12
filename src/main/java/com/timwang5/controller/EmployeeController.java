package com.timwang5.controller;

import com.timwang5.dao.DepartmentDao;
import com.timwang5.dao.EmployeeDao;
import com.timwang5.pojo.Department;
import com.timwang5.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAllEmployees();
        //注意添加
        model.addAttribute("emps",employees);
        //返回到list页面
        return "emp/list";
    }


    @GetMapping("/addPage")
    public String toAddPage(Model model) {
        //查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        //返回到添加员工页面
        return "emp/add";
    }


    @PostMapping("/addPage")
    public String addEmp(Employee employee) {
        //添加一个员工
        employeeDao.addEmployee(employee);
        //重定向到/emps,刷新列表,返回到list页面
        return "redirect:/emps";
    }


    //restful风格接收参数
    @RequestMapping("/emp/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        //查询指定id的员工,添加到empByID中,用于前端接收
        Employee employeeByID = employeeDao.getEmployeeByID(id);
        model.addAttribute("empByID", employeeByID);


        //查出所有的部门信息,添加到departments中,用于前端接收
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        //返回到编辑员工页面
        return "/emp/edit";
    }


    @PostMapping("/edit")
    public String EditEmp(Employee employee) {
        //添加一个员工
        employeeDao.addEmployee(employee);
        //添加完成重定向到/emps,刷新列表
        return "redirect:/emps";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        employeeDao.deleteEmployeeByID(id);
        return "redirect:/emps";
    }







}
