package com.jc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _01_Collection {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,0,1,3,4,6,7,4,9,24,33);
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });
//        System.out.println(list);

        Collections.sort(list,(Integer o1, Integer o2)->{return o2 - o1;});
        System.out.println(list);

//        Lock lock = new ReentrantLock();
//        lock.lock();
//        lock.unlock();
    }
}
