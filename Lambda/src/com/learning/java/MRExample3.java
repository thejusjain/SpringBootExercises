package com.learning.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MRExample3 {
    Double doSum(Integer a, Integer b){
        return (double) (a + b);
    }

    public static void main(String [] args) {
//        List<Integer> result = Arrays.asList(1, 2, 50, 5);
//        System.out.println("Using anonymous inner class");
//        List<Double> output = performOperation(result, new TriFunction<MRExample3, Integer, Integer, Double>() {
//            @Override
//            public Double process(MRExample3 mrExample3, Integer integer, Integer integer2) {
//                return mrExample3.doSum(integer, integer2);
//            }
//        });
//        System.out.println(output);

//        System.out.println("Using lambda");
//        List<Double> output1 = performOperation(result, (obj, a, b) -> obj.doSum(a, b));
//        System.out.println(output1);


//
//        System.out.println("Using method reference");
//        List<Double> output2 = performOperation(result, MRExample3::doSum);
//        System.out.println(output2);

        // or without creating the list
        System.out.println("Using anonymous inner class without list");
        TriFunction<MRExample3, Integer, Integer, Double> triFunction = new TriFunction<MRExample3, Integer, Integer, Double>() {
            @Override
            public Double process(MRExample3 mrExample3, Integer integer, Integer integer2) {
                return mrExample3.doSum(integer, integer2);
            }
        };
        System.out.println(triFunction.process(new MRExample3(), 10, 10));

        System.out.println("Using lambda");
        TriFunction<MRExample3, Integer, Integer, Double> lambda = (mrObj, a, b) -> mrObj.doSum(a,b);
        System.out.println(lambda.process(new MRExample3(), 30, 10));

        System.out.println("Using method reference");
        TriFunction<MRExample3, Integer, Integer, Double> methodReference = MRExample3::doSum;
        System.out.println(methodReference.process(new MRExample3(), 30, 10));
    }

    private static List<Double> performOperation(List<Integer> list, TriFunction<MRExample3, Integer, Integer, Double> function) {
        List<Double> result = new ArrayList<Double>();
        for (Integer i: list) {
            result.add(function.process(new MRExample3(), i, i));
        }

        return result;
    }

}

interface TriFunction<A, B, C, D> {
    D process(A a, B b, C c);
}