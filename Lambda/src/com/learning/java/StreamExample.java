package com.learning.java;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String [] args) {
        List<Person> people = Arrays.asList(
                new Person("Thejus", "Jain", 25),
                new Person("Thomas", "Peter", 26),
                new Person("Akash", "Bhaskaran", 25),
                new Person("Akhil", "Ambady", 26),
                new Person("Sachin", "Sreekumar", 24),
                new Person("Arjun", "Santhosh", 25)
        );
        // All these functions use the Functional interfaces, ie can use lambda
        people.stream()
                .filter(p -> p.getLastName().startsWith("A")) // operations that are performed on the stream
                .forEach(p -> System.out.println(p.getFirstName())); // This is the terminal operation which makes it end

        long count = people.stream()
                .filter(p -> p.getFirstName().startsWith("T"))
                .count();

        System.out.println(count);
    }


}
