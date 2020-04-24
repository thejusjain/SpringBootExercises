package com.learning.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class MethodReference {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Thejus", "Jain", 25),
                new Person("Thomas", "Peter", 26),
                new Person("Akash", "Bhaskaran", 25),
                new Person("Akhil", "Ambady", 26),
                new Person("Sachin", "Sreekumar", 24),
                new Person("Arjun", "Santhosh", 25)
        );
        // Create a method to print all elements of the list
        System.out.println("Prints all the person in the list");
        printConditionally(people, p -> true, System.out::println);

    }
    // We can use the interface Predicate from the java.util.function library because it uses a similar signature
    // as the Condition Interface that we created. There are many generic interfaces in the function library.
    private static void printConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
