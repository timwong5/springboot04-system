package com.timwang5.mapper;

import com.timwang5.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface UserMapper {

    User findLoginUserByName(String name);

}
