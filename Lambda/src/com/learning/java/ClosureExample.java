package com.learning.java;

public class ClosureExample {

    public static void main(String [] args) {
        int a = 10;
        int b = 15;
        // Here b is taken by the lambda as final or effectively final. Meaning the value of b is frozen by the lambda
        // and will continue to use the frozen value. ie 15. This is closure
        doProcess(a, i -> System.out.println(i + b));
    }

    public static void doProcess(int a, Process p) {
        p.process(a);
    }

}

interface Process {
    void process(int a);
}