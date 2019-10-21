package com.xy.studyboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * WJY
 */
public class Lambda2 {


    public static long fibonacci(long number) {
        if ((number == 0) || (number == 1)) {
            return number;
        }else
            return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static void main(String[] args) {

        for (int counter = 0; counter <= 10; counter++){
            System.out.printf("Fibonacci of %d is: %d\n", counter, fibonacci(counter));
        }

        /*List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        eval(list , n->true);
        int[] numbers= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        List<Integer> lists=new ArrayList<>();
        for(int i:numbers) {
            lists.add(i);
        }

        Predicate<Integer> p1=i->i>15;
        Predicate<Integer> p2=i->i<20;
        Predicate<Integer> p3=i->i%2==0;
        List test=lists.stream().filter(p1.negate()).collect(Collectors.toList());
        System.out.println(test.toString());*/
    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {

            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

}
