package com.learning.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MRExample2 {

    public double calculateWeight() {
        double weight = 0;
        // Calculate weight
        return weight;
    }

    public static List<Double> calculateOnShipments(
            List<MRExample2> l, Function<MRExample2, Double> f) {
        List<Double> results = new ArrayList<>();
        for(MRExample2 s : l) {
            results.add(f.apply(s));
        }
        return results;
    }

    public static void main(String [] args) {
        List<MRExample2> l = Arrays.asList(
                new MRExample2(),
                new MRExample2()
        );
        System.out.println("using Anonymous Inner class");
        List<Double> result = calculateOnShipments(l, new Function<MRExample2, Double>() {
            @Override
            public Double apply(MRExample2 mrExample2) {
                return mrExample2.calculateWeight();
            }
        });
        System.out.println(result);

        System.out.println("using Lambda");
        List<Double> result1 = calculateOnShipments(l, s -> s.calculateWeight());
        System.out.println(result1);

        System.out.println("using Method Reference");
        List<Double> result2 = calculateOnShipments(l, MRExample2::calculateWeight);
        System.out.println(result2);

    }

}
