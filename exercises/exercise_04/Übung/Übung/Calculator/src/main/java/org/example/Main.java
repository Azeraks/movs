package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Arrays.stream(args).toList().forEach(a -> System.out.println("a = " + a));

        Calculator c = Calculator.create();
        System.out.println(c.add(5, 6 * 2));

    }
}