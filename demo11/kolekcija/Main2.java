package demo11.kolekcija;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main2 {
    public static void main(String [] args){
        testMap(new TreeMap<>());
    }

    public static void testMap(Map<String, List<Zmogus>>map){

        System.out.println("1-as būdas turėti kelis žmones su tokiu pačiu asmens kodu");

        map.computeIfAbsent("37711021210", k -> new ArrayList<>()).add(new Zmogus("Jonas","Kavaliauskas"));
        map.computeIfAbsent("48603171344", k -> new ArrayList<>()).add(new Zmogus("Birutė","Petrikytė")); //46304250871 Birutės Petrikytės pirminis a.k.
        map.computeIfAbsent("60108120297", k -> new ArrayList<>()).add(new Zmogus("Marytė","Švelnienė"));
        map.computeIfAbsent("48603171344", k -> new ArrayList<>()).add(new Zmogus("Dalė","Gerulaitienė"));
        map.computeIfAbsent("50506020640", k -> new ArrayList<>()).add(new Zmogus("Algimantas","Šurna"));

        System.out.println("Žmonės spausdinami asmens kodo didėjimo tvarka.");
        System.out.println();
        System.out.println("Pastaba: jei asmens kodas kartotųsi, būtų spausdinami visų ");
        System.out.println("su šiuo asmens kodu įvestų žmonių vardai ir pavardės.");
        System.out.println();

        for (Map.Entry<String, List <Zmogus>> zm : map.entrySet()) {
            System.out.println(zm);
        }
    }
}

//https://www.baeldung.com/java-map-duplicate-keys
//From Java 8 we could exploit the compute() methods and improve it.

//Map<String, List<String>> map = new HashMap<>();
//map.computeIfAbsent("key1", k -> new ArrayList<>()).add("value1");
//map.computeIfAbsent("key1", k -> new ArrayList<>()).add("value2");

//assertThat(map.get("key1").get(0)).isEqualTo("value1");
//assertThat(map.get("key1").get(1)).isEqualTo("value2");
