package com.timwang5.mapper;

import com.timwang5.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DepartmentMapper {


    //获取所有部门
    List<Department> getDepartments();
    //通过ID获取部门
    Department getDepartmentById(Integer id);



}
