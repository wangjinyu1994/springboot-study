package com.xy.studyboot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.*;


/**
 * WJY
 */
public class LambdaTest {

    final static String name = "helloword";

    public static void main(String[] args) {
        List<String> list = getList();
        Collections.sort(list ,(s1 , s2) -> s1.compareTo(s2));
        list.stream().forEach(System.out::println);


        MathOperation add = (int a , int b) -> a + b;

        System.out.println(operation(1 , 2  ,add));


        GreetingService greetingService = message -> System.out.println(name + message);

        GreetingService greetingService2 = (message) -> System.out.println(name + message);
        greetingService.sayMessage("111");
        greetingService2.sayMessage("2222");

    }

    private static int operation(int a , int b , MathOperation operation){
        return operation.operation(a,b);
    }


    public static List<String> getList(){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("cccc");
        list.add("dddd");
        list.add("1111");
        return list;
    }

}
