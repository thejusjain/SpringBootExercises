package com.learning.java;

public class ThisBehaviour {

    public void doProcess(int a, Process p) {
        p.process(a);
    }

    public void execute() {
        doProcess(10, i -> {
            System.out.println(i);
            System.out.println(this);
        });
    }

    public static void main(String [] args) {
        ThisBehaviour thisBehaviour = new ThisBehaviour();

        //anonymous inner class rewrites the this to object instance
//        thisBehaviour.doProcess(10, new Process() {
//            @Override
//            public void process(int a) {
//                System.out.println(a);
//                System.out.println(this);
//            }
//
//            public String toString(){
//                return "This is the instance of Process created by the class object thisBehaviour";
//            }
//        });

        // lambda acts as a static context and will not change the 'this'
//        thisBehaviour.doProcess(10, i -> {
//            System.out.println(i);
//            System.out.println(this); // Shoes error - wont work
//        });

        thisBehaviour.execute();


    }

    public String toString() {
        return "Object instance";
    }
}
