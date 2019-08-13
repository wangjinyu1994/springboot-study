package com.xy.studyboot.controller;

import com.xy.studyboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * WJY
 */
@RestController
@RequestMapping(value = "/redid")
public class RedisController {

    @Autowired
    private RedisService redisService;




}
