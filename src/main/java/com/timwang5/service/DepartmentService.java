package com.timwang5.service;


import com.timwang5.mapper.DepartmentMapper;
import com.timwang5.pojo.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentService {


    @Resource
    private DepartmentMapper departmentMapper;



    //1. 查询所有部门
    public List<Department> getAll(){
        return departmentMapper.getDepartments();
    }

    //2. 根据员工id获取部门
    public Department get(Integer id){
        return departmentMapper.getDepartmentById(id);

    }


}
