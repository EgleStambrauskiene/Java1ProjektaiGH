package demo09.mokejimas;

public class Employee implements Mokejimas {
    public static String statusas = "darbuotojas";
    private String vardas;
    private String pavarde;
    private String saskaitosNr;
    private double suma;
    Employee [] darbuotojai;

    public Employee(String statusas, String vardas, String pavarde, String saskaitosNr, double suma){
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.saskaitosNr = saskaitosNr;
        this.suma = suma;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public String getSaskaitosNr(){
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
        getVardas();
        getPavarde();
        System.out.print(statusas + " " + vardas + " " + pavarde + ", ");
        return vardas + pavarde;
    }

    @Override
    public double amount(){
        getSuma();
        System.out.println("pervedama suma: " + suma + " eurų."); //0128
        return suma;
    }

    public String toString() {
        return getVardas() + " " + getPavarde();
    }

    public static void main(String [] args){

        Employee [] darbuotojai = {
                new Employee("", "Kajus","Kleiza", "LT1111", 1000),
                new Employee("", "Gintarė","Latvėnaitė", "LT2222", 900),
                new Employee("", "Daiva","Mažuolė", "LT3333", 800),
                new Employee("", "Regimantas","Senvaitis", "LT4444", 700),
                new Employee("", "Kęstutis","Bružas", "LT5555", 600)
        };

        for (int i = 0; i < darbuotojai.length; i++){
            darbuotojai[i].accountOwner();
            darbuotojai[i].bankAccount();
            darbuotojai[i].amount();

        }
    }
}
