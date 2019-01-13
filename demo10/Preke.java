package demo10;

//Tarkime, yra parduota kažkiek prekių (x) už kažkokią kainą (y) ir tai sudaro kažkokią sumą (z). Visos šitos sumos yra su PVM 21%.
//Parašykite metodą/funkciją, kurią iškvietus su parametrais: kiekis, suma su PVM - ta funkcija atspausdintų pardavimo įrašą tokiu formatu:
        //1. prekės kaina be PVM (tikslumas 2 ženklai po kablelio);
        //2. kiekis;
        //3. suma be PVM (tikslumas 2 ženklai po kablelio);
        //4. PVM suma (tikslumas 2 ženklai po kablelio);
        //5. viso suma su PVM (tikslumas 2 ženklai po kablelio).

public class Preke {

    private String pavadinimas;
    private Double prekesKainaSuPVM;
    private Double prekesKainaBePVM; //PVM 21%

    Preke (String pavadinimas, double prekesKainaSuPVM){
        this.pavadinimas = pavadinimas;
        this.prekesKainaSuPVM = prekesKainaSuPVM;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public double getPrekesKainaSuPVM() {
        return prekesKainaSuPVM;
    }

    public double getPrekesKainaBePVM(){
        prekesKainaBePVM = Math.floor((prekesKainaSuPVM/1.21) * 100 + 0.5) / 100;
        return prekesKainaBePVM;
    }
    //Teisingai suapvalintas iki šimtųjų dalių: Math.floor(d*100 + 0.5)/100
}
