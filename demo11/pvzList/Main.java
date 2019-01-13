package demo11.pvzList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(new Integer(10));
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(0, 40);

        System.out.print("Sąrašas:");
        for (Integer a : list) {
            System.out.print(" " + a);
        }
        System.out.println();

        System.out.println("Ar yra 20? = " + list.contains(20));
        System.out.println("20 indeksas yra: " + list.indexOf(20));
        System.out.println("(1) = " + list.get(1));


        System.out.println("Išmetam is sąrašo (0) ir 20");
        list.remove(0);
        list.remove(Integer.valueOf(20));

        System.out.print("Sąrašas:");
        for (Integer i : list) {
            System.out.print(" " + i);
        }
        System.out.println();


        List<Integer> b = new ArrayList<>();
        b.add(25);
        b.add(26);

        list.addAll(b);

        System.out.print("Sąrašas:");
        for (Integer i : list) {
            System.out.print(" " + i);
        }
        System.out.println();

        b.clear();
        b.add(10);
        b.add(20);
        System.out.println("Ar yra 10,20? = " + list.containsAll(b));

        b.add(21);
        System.out.println("Ar yra 10,20,21? = " + list.containsAll(b));
    }
}
