package com.learning.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class LambdaExerciseJava8Test2 {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Thejus", "Jain", 25),
                new Person("Thomas", "Peter", 26),
                new Person("Akash", "Bhaskaran", 25),
                new Person("Akhil", "Ambady", 26),
                new Person("Sachin", "Sreekumar", 24),
                new Person("Arjun", "Santhosh", 25)
        );

        // Sort list by last name
        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // Create a method to print all elements of the list
        System.out.println("Prints all the person in the list");
        printConditionally(people, p -> true, p -> System.out.println(p));

        // Create a method that prints all person that have name beginning with A
        System.out.println("This is the persons whose last names starts with S");
        printConditionally(people, p -> p.getLastName().startsWith("S"), p -> System.out.println(p.getLastName()));

        System.out.println("This is the persons whose First names starts with T");
        printConditionally(people, p -> p.getFirstName().startsWith("T"), p -> System.out.println(p.getFirstName()));

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
