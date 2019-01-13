package demo09.mokejimas;

public class Vykdymas {
    Object [] masyvas;

    public static void main(String [] args){

        Mokejimas [] masyvas = {
                new Employee("", "Kajus","Kleiza", "LT1111", 1000),
                new Employee("", "Gintarė","Latvėnaitė", "LT2222", 900),
                new Employee("", "Daiva","Mažuolė", "LT3333", 800),
                new Employee("", "Regimantas","Senvaitis", "LT4444", 700),
                new Employee("", "Kęstutis","Bružas", "LT5555", 600),
               //new Client("","UAB","Gija", "LT6666", 2000),
                // new Client("","AB","Audimas", "LT7777", 1500),
                //new Client("","AB","Vilkma", "LT8888", 1000),
                //new Client("","VšĮ","Vaikų laisvalaikis", "LT9999", 500),
                //new Client("","MB","Trys paršiukai", "LT1234", 300)
        };

        for (int i = 0; i < masyvas.length; i++){
            masyvas[i].accountOwner();
            masyvas[i].bankAccount();
            masyvas[i].amount();
        }

    }

}
