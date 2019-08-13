package com.xy.studyboot.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.xy.studyboot.pojo.User;
import com.xy.studyboot.service.TestService;
import com.xy.studyboot.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * WJY
 */
@RestController
@RequestMapping(value = "/test")
@Api(tags = "1.0v" , description = "测试controller" , value = "测试controller")
public class TestController {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private TestService service;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    public TestController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @GetMapping
    @ApiOperation("根据主键查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id" , value = "主键" , dataType = ApiDataType.INT , paramType = ApiParamType.QUERY)
    })
    public List<User> queryUsers(){
        System.out.println("---------------");
       /* String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql , new Object[]{} ,new BeanPropertyRowMapper<>(User.class));*/
       boolean b = redisUtil.hasKey("1");
       if (b){
           User user1 = (User) redisUtil.get("1");
           List<User> list = new ArrayList<>();
           list.add(user1);
           System.out.println("我是从redis中那出来的");
           return list;
       } else {
           User user1 = new User();
           user1.setId(1);
           user1.setUserName("jjj");
           System.out.println("我是第一次进来");
          redisUtil.set("1" ,user1);
          return null;
       }
    }



}
