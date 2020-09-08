package com.jc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _01_线程池 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+"---->"+i);
                }
            }
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"---->"+i);
        }
        executorService.shutdown();

    }
}
