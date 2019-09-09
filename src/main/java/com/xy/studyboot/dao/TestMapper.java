package com.xy.studyboot.dao;

import com.xy.studyboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * WJY
 */
@Mapper
public interface TestMapper {

    @Select("SELECT * FROM user")
    List<User> getList();

    List<User> getAllUser();

    Integer insertUser(@Param("username") String aa, @Param("password") String bb);
}
