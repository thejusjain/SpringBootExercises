package com.learning.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class LambdaExeciseJava7 {

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
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        // Create a method to print all elements of the list
//        printAll(people);

        // Create a method that prints all person that have name beginning with A
        System.out.println("This is the persons whose last names starts with S");
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("S");
            }
        });

        System.out.println("This is the persons whose First names starts with T");
        printConditionally(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getFirstName().startsWith("T");
            }
        });

    }

    private static void printConditionally(List<Person> people, Condition condition) {
        for (Person p : people) {
            if (condition.test(p)) {
                System.out.println(p);
            }
        }
    }

    private static void printAll(List<Person> people) {
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
interface Condition {
    boolean test(Person p);
}
