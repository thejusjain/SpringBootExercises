package com.learning.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class MethodReferenceExamples {

    public static void main(String [] args) {

        List<Integer> list = Arrays.asList(12,5,45,18,33,24,40);
        System.out.println("Results using Anonymous Inner class");
        List newList1 = findNumbers(list, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer integer, Integer integer2) {
                return isMoreThanFifty(integer, integer2);
            }
        });
        System.out.println(newList1);

        System.out.println("Results using Lambda");
        List newList2 = findNumbers(list, (a, b) -> isMoreThanFifty(a, b));
        System.out.println(newList2);

        System.out.println("Results using Method Reference");
        List newList3 = findNumbers(list, MethodReferenceExamples::isMoreThanFifty);
        System.out.println(newList3);


    }

    public static boolean isMoreThanFifty(int n1, int n2) {
        return (n1 + n2) > 50;
    }

    public static List<Integer> findNumbers(List<Integer> l, BiPredicate<Integer, Integer> p) {
        List<Integer> newList = new ArrayList<>();
        for(Integer i : l) {
            if(p.test(i, i + 10)) {
                newList.add(i);
            }
        }
        return newList;
    }
}
