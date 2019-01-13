package demo09.mokejimas;

public class Client implements Mokejimas {
    public static String statusas = "klientas";
    private String tipas;
    private String pavadinimas;
    private String saskaitosNr;
    private double suma;
    double [] ismoketosSumos;

    public Client(String Statusas, String tipas, String pavadinimas, String saskaitosNr, double suma, double [] ismoketosSumos){
        this.tipas = tipas;
        this.pavadinimas = pavadinimas;
        this.saskaitosNr = saskaitosNr;
        this.suma = suma;
        this.ismoketosSumos = ismoketosSumos;
    }

    public String getTipas() {
        return tipas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public String getSaskaitosNr() {
        return saskaitosNr;
    }

    public double getSuma() {
        return suma;
    }

    @Override
    public String bankAccount(){
        getSaskaitosNr();
        System.out.print("sąskaitos nr. " + saskaitosNr + ", ");
        return saskaitosNr;
    }

    @Override
    public String accountOwner(){
        getTipas();
        getPavadinimas();
        System.out.print(statusas + " " + tipas + " " + pavadinimas + ", ");
        return tipas + pavadinimas;
    }

    @Override
    public double amount(){
        getSuma();
        System.out.println("pervedama suma: " + suma + " eurų."); //0128
        return suma;
    }
    /*
    public void double [] ismokuSpausdinimas(){
        for (double is : ismoketosSumos){
            System.out.println();
        }
    }
*/
    public String toString() {
        return getTipas() + " " + getPavadinimas();
    }

    public static void main(String [] args){

        Client [] klientai = {
                new Client("","UAB","Gija", "LT6666", 2000, new double [] {100}),
                new Client("","AB","Audimas", "LT7777", 1500, new double [] {200, 300, 400}),
                new Client("","AB","Vilkma", "LT8888", 1000, new double [] {200, 300, 400, 500, 600}),
                new Client("","VšĮ","Vaikų laisvalaikis", "LT9999", 500, new double [] {200, 300, 400, 500}),
                new Client("","MB","Trys paršiukai", "LT1234", 300, new double [] {200, 300})
        };

        for (int i = 0; i < klientai.length; i++){
            klientai[i].accountOwner();
            klientai[i].bankAccount();
            klientai[i].amount();
        }

        for (int i = 0; i < klientai.length - 1; i++){
            for (int j = i + 1; j < klientai.length; j++){
                if (klientai[i].ismoketosSumos.length < klientai[j].ismoketosSumos.length){
                    Client mx = klientai[i];
                    klientai[i] = klientai[j];
                    klientai[j]= mx;
                }
            }
        }

        for (Client m : klientai) {
            m.accountOwner();
            m.bankAccount();
            m.amount();

        }
    }

}
