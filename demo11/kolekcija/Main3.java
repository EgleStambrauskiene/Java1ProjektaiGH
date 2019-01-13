package demo11.kolekcija;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main3 {
    public static void main(String [] args){
        testMap(new TreeMap<>());
    }

    public static void testMap(Map<String, List<Zmogus>> map){

        System.out.println("2-as būdas turėti kelis žmones su tokiu pačiu asmens kodu");

        List<Zmogus> list1 = new ArrayList<>();
        List<Zmogus> list2 = new ArrayList<>();
        List<Zmogus> list3 = new ArrayList<>();
        List<Zmogus> list4 = new ArrayList<>();

        map.put("37711021210", list1);
        map.get("37711021210").add(new Zmogus("Jonas","Kavaliauskas"));
        map.put("48603171344", list2);
        map.get("48603171344").add(new Zmogus("Birutė","Petrikytė"));//46304250871 Birutės Petrikytės pirminis a.k.
        map.get("48603171344").add(new Zmogus("Dalė","Gerulaitienė"));
        map.put("60108120297", list3);
        map.get("60108120297").add(new Zmogus("Marytė","Švelnienė"));
        map.put("50506020640", list4);
        map.get("50506020640").add(new Zmogus("Algimantas","Šurna"));

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
//using a Collection for every value of our Map.

//Map<String, List<String>> map = new HashMap<>();
//List<String> list = new ArrayList<>();
//map.put("key1", list);
//map.get("key1").add("value1");
//map.get("key1").add("value2");

//assertThat(map.get("key1").get(0)).isEqualTo("value1");
//assertThat(map.get("key1").get(1)).isEqualTo("value2");
