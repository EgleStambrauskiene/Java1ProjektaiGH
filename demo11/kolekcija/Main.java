package demo11.kolekcija;

import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {
    public static void main(String [] args){
        testMap(new TreeMap<>());
    }

    public static void testMap(Map<String, Zmogus>map){

        System.out.println("Negalime turėti kelių žmonių su tokiu pačiu asmens kodu.");

        map.put("37711021210", new Zmogus("Jonas","Kavaliauskas"));
        map.put("46304250871", new Zmogus("Birutė","Petrikytė")); //46304250871
        map.put("60108120297", new Zmogus("Marytė","Švelnienė"));
        map.put("48603171344", new Zmogus("Dalė","Gerulaitienė"));
        map.put("50506020640", new Zmogus("Algimantas","Šurna"));

        System.out.println("Žmonės spausdinami asmens kodo didėjimo tvarka.");
        System.out.println("Pastaba: jei asmens kodas kartotųsi, būtų spausdinami paskiausiai ");
        System.out.println("su šiuo asmens kodu įvesto žmogaus vardas ir pavardė.");
        System.out.println();

        for (Entry <String, Zmogus> zm : map.entrySet()) {
            System.out.println(zm);
        }
    }
}
