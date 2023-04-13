package com.yuurm;

import java.util.Comparator;
import java.util.Random;


public class Main {


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(100));
        }

        list.addFirst(777);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("----------");
        list.quickSort(Integer::compareTo);

        Iterator<Integer> iterator1 = list.iterator();

        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }


        System.out.println("----------");




    }
}
