package demo11.kolekcija;

//Sukurkite žodyno tipo kolekciją saugoti žmonių klasės objektus (su tokiais laukais: vardas, pavardė, asmens kodas).
// Kaip raktą naudokite asmens kodą.

//Įdėkite keletą žmonių į kolekciją ir atspausdinkite žmones asmens kodo didėjimo tvarka.

//Pabandykite įdėti į kolekciją du skirtingus žmones bet su tuo pačiu asmens kodu. Patikrinkite kas atsitiks?

//Pagalvokite kaip saugoti žmones, jei norime turėti kelis su tuo pačiu asmens kodu.

public class Zmogus {
    private String vardas;
    private String pavarde;
    private String asmensKodas;

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public String getAsmensKodas() {
        return asmensKodas;
    }

    Zmogus(String vardas, String pavarde){
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public String toString(){
        return " " + vardas + " " + pavarde;
    }
}
