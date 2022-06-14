package com.timwang5.mapper;

import com.timwang5.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;



@Mapper
@Repository
public interface EmployeeMapper {


    //1. 获取员工所有信息
    List<Employee> getEmployees();

    //2. 新增一个员工
    Integer add(Employee employee);

    //3. 删除一个员工
    Integer delete(Integer id);

    //4. 通过id查询员工的信息
    Employee getEmployeeById(Integer id);

    //5. 修改一个员工
    Integer edit(Employee employee);
}
