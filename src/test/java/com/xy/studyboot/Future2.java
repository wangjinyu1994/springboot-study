package com.xy.studyboot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * WJY
 */
public class Future2 {


        private static Random rand = new Random();
        private static long t = System.currentTimeMillis();
        static int getMoreData() {
            System.out.println("begin to start compute");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("end to start compute. passed " + (System.currentTimeMillis() - t)/1000 + " seconds");
            return rand.nextInt(1000);
        }
        public static void main(String[] args) throws Exception {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Future2::getMoreData);
            Future<Integer> f = future.whenComplete((v, e) -> {
                System.out.println(v);
                System.out.println(e);
            });
            System.out.println(f.get());
            System.in.read();
            List<UserTest> list1 = new ArrayList<>();
            // 将user获取到user对象的id并转为list
            List<Integer> collect = list1.stream().map(UserTest::getUserId).collect(Collectors.toList());

            List<String> list = new ArrayList<>();
            list.removeIf(data-> null == data || data.equals(""));
        }



}
