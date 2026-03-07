package com.bytelabs.order_service;

import java.util.*;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 100_000; i++) {
            list.add(i);
        }

        long start = System.nanoTime();
        for (Integer i : list) {
            if (i % 2 == 0) {
                int j = i * 2;
                System.out.println(j);

                long end = System.nanoTime();
                System.out.println((end - start));
                break;
            }
        }

        System.out.println("====");

        long start2 = System.nanoTime();
        list.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .findFirst()
                .ifPresent(System.out::println);
        long end2 = System.nanoTime();
        System.out.println(end2 - start2);

        Thread t = new Thread(new Ts());
        t.start();
        System.out.println(Thread.currentThread().getName());


    }
}

class Ts implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
