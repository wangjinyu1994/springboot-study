package com.xy.studyboot.dao;

import com.xy.studyboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
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

}
