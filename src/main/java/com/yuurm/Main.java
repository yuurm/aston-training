package com.yuurm;

import java.util.Random;


public class Main {


    public static void main(String[] args) {
        List list = new ArrayList();

        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            list.add(random.nextInt(100));
        }

        list.addFirst(777);

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Iterator iterator1 = list.iterator();

        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

    }
}
