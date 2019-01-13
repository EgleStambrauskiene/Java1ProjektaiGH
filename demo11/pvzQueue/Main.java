package demo11.pvzQueue;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        testQueue(new PriorityQueue<>());

    }

    private static void testQueue(Queue<Integer> queue) {

        queue.add(30);
        queue.add(20);
        queue.add(50);
        queue.add(20);
        queue.add(10);

        System.out.print("Eilė:");
        for (Integer i : queue) {
            System.out.print(" " + i);
        }
        System.out.println();

        System.out.println("Ar yra 20? = " + queue.contains(20));

        System.out.println("Išmetam is sąrašo paskutinį/pirmą, t.y. 10");
        queue.poll();

        System.out.print("Eilė:");
        for (Integer i : queue) {
            System.out.print(" " + i);
        }
        System.out.println();
    }
}
