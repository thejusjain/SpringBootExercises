package com.learning.java;

import java.util.Arrays;
import java.util.List;

public class CollectionIterator {
    public static void main(String [] args) {

        List<Person> people = Arrays.asList(
                new Person("Thejus", "Jain", 25),
                new Person("Thomas", "Peter", 26),
                new Person("Akash", "Bhaskaran", 25),
                new Person("Akhil", "Ambady", 26),
                new Person("Sachin", "Sreekumar", 24),
                new Person("Arjun", "Santhosh", 25)
        );

        // Iteration using standard for loop
        System.out.println("Iteration using standard for loop");
        for (int i = 0; i <people.size(); i++) {
            System.out.println(people.get(i));
        }

        // Iteration using for in loop
        System.out.println("Iteration using for in loop");
        for (Person p : people) {
            System.out.println(p);
        }

        System.out.println("Iteration using for each method and method reference");
        people.forEach(System.out::println);
    }
}
