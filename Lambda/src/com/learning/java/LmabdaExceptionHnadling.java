package com.learning.java;

import java.util.function.BiConsumer;

public class LmabdaExceptionHnadling {

    public static void main(String [] args) {

        int [] someNumbers = {10, 12, 3, 4};
        int key = 0;

        process(someNumbers, key, exceptionHandler((v, k) -> System.out.println(v / k)));
    }

    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
        for (int i : someNumbers) {
            consumer.accept(i, key);
        }
    }

    private static BiConsumer<Integer, Integer> exceptionHandler(BiConsumer<Integer, Integer> consumer) {
        return (v, k) -> {
            try {
                consumer.accept(v, k);
            } catch (ArithmeticException e) {
                System.out.println("Exception caught in the wrapper method");
            }
        };
    }

}
