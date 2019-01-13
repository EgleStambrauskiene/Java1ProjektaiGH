package demo11.pvzSet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        System.out.println("HashSet:");
        testSet(new HashSet<>());

        System.out.println("--------------------");

        System.out.println("TreeSet:");
        testSet(new TreeSet<>());
    }


    private static void testSet(Set<Integer> set) {

        set.add(30);
        set.add(20);
        set.add(50);
        set.add(20);
        set.add(10);

        System.out.print("Aibės dydis " + set.size() + ": " );
        for (Integer i : set) {
            System.out.print(" " + i);
        }
        System.out.println();

        System.out.println("Ar yra 20? = " + set.contains(20));

        System.out.println("Išmetam is sąrašo 20");
        set.remove(20);

        System.out.print("Aibės dydis " + set.size() + ": " );
        for (Integer i : set) {
            System.out.print(" " + i);
        }
        System.out.println();

    }
}
