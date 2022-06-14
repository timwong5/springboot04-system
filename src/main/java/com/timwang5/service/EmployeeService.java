package com.timwang5.service;


import com.timwang5.mapper.EmployeeMapper;
import com.timwang5.pojo.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    //1. 获取员工所有信息
    public List<Employee> getAll(){
        return employeeMapper.getEmployees();
    }


    //2. 新增一个员工
    public Integer add(Employee employee){
        return employeeMapper.add(employee);
    }

    //3. 删除一个员工
    public Integer delete(Integer id){
        return employeeMapper.delete(id);
    }


    //4. 通过id查询员工的信息
    public Employee get(Integer id){
        return employeeMapper.getEmployeeById(id);

    }


    // 5. 编辑员工信息
    public Integer edit(Employee employee){
        return employeeMapper.edit(employee);
    }
}
