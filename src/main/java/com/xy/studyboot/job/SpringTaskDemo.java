package com.xy.studyboot.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * WJY
 * 定时任务
 */
//@Component
public class SpringTaskDemo {

    /**
     * 表示可以并行执行的定时任务 1秒钟执行一次
     * @throws InterruptedException
     */
    @Async
    @Scheduled(cron = "0/1 * * * * *")
    public void scheduled1() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("scheduled1 一秒钟执行一次:" + LocalDateTime.now());
    }

    @Scheduled(fixedRate = 1000)
    public void scheduled2() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("scheduled2 一秒钟执行一次:" + LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 3000)
    public void scheduled3() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("scheduled3 上次执行完毕后隔3秒继续执行:" + LocalDateTime.now());
    }

}
