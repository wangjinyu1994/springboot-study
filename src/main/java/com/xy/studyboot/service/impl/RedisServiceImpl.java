package com.xy.studyboot.service.impl;


import com.xy.studyboot.dao.RedisDao;
import com.xy.studyboot.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * WJY
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisDao dao;

}
