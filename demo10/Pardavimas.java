package demo10;

//Tarkime, yra parduota kažkiek prekių (x) už kažkokią kainą (y) ir tai sudaro kažkokią sumą (z). Visos šitos sumos yra su PVM 21%.
//Parašykite metodą/funkciją, kurią iškvietus su parametrais: kiekis, suma su PVM - ta funkcija atspausdintų pardavimo įrašą tokiu formatu:
//1. prekės kaina be PVM (tikslumas 2 ženklai po kablelio)
//2. kiekis
//3. suma be PVM (tikslumas 2 ženklai po kablelio)
//4. PVM suma (tikslumas 2 ženklai po kablelio)
//5. suma su PVM (tikslumas 2 ženklai po kablelio)

public class Pardavimas extends Preke {

    private int prekiuKiekis;
    private Double sumaSuPVM; //PVM 21%
    private Double sumaBePVM;
    private Double sumaPVM;

    Pardavimas(String pavadinimas, double prekesKainaSuPVM, int prekiuKiekis){
        super(pavadinimas, prekesKainaSuPVM);
        this.prekiuKiekis = prekiuKiekis;
    }

    public int getPrekiuKiekis() {
        return prekiuKiekis;
    }

    public double getSumaSuPVM() {
        sumaSuPVM = getPrekiuKiekis() * getPrekesKainaSuPVM();
        return sumaSuPVM;
    }

    public double getSumaBePVM() {
        sumaBePVM = getPrekiuKiekis() * getPrekesKainaBePVM();
        return sumaBePVM;
    }

    public double getSumaPVM() {
        sumaPVM = Math.floor((getSumaSuPVM() - getSumaBePVM()) * 100 + 0.5) / 100;
        return sumaPVM;
    }

    void pardavimoIrasas(int getPrekiuKiekis, double getSumaSuPVM){
        System.out.print(getPavadinimas());
        System.out.print(", kaina be PVM: " + getPrekesKainaBePVM());
        System.out.print(", kiekis: " + getPrekiuKiekis);
        System.out.print(", suma be PVM: " + getSumaBePVM());
        System.out.print(", PVM suma: " + getSumaPVM() + " ");
        System.out.println(", suma suPVM: " + getSumaSuPVM() + ";");
    }

    public static void main(String [] args){

        Pardavimas [] irasai = {
                new Pardavimas("Preke1", 1.05, 2),
                new Pardavimas("Preke2", 2.25, 4)
        };

        for (Pardavimas ir : irasai){
            ir.pardavimoIrasas(ir.getPrekiuKiekis(),ir.getSumaSuPVM());
        }

        Integer a = Integer.parseInt("32", 11) + new Integer(7);
        System.out.print(a);
    }
}
