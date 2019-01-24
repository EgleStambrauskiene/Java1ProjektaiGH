package demo00;

import java.util.Objects;
import java.util.Scanner;

public class BattleShips {
    int shipSize;
    int startPointI;
    int startPointJ;
    String shipDirection;
    boolean isTaken3 = false; //Uno laivas g.b. žymimas 3 arba 2. Žymėsiu 2 tuo atv., kai 3 jau "panaudotas".
    boolean isTaken5 = false; //Duo laivas g.b. žymimas 6, arba 5, arba 4.
    boolean isTaken6 = false; //Žymėsiu 5 tuo atv., kai 6 jau "panaudotas" ir žymėsiu 4 tuo atv., kai 5 jau "panaudotas".
    boolean isTaken8 = false; //Triplex laivas g.b. žymimas 7 arba 8. Žymėsiu 7 tuo atv., kai 8 jau "panaudotas".

    int [][] battleArea = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 0
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 1
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 2
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 3
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 4
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 5
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 6
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 7
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 8
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0} // 9
//           0  1  2  3  4  5  6  7  8  9
    };

    int shootI;
    int shootJ;
    int quattuorLives = 4;// matricoje žymimas 9;
    int triplex1Lives = 3; // matricoje žymimas 8;
    int triplex2Lives = 3; // matricoje žymimas 7;
    int duo1Lives = 2; // matricoje žymimas 6;
    int duo2Lives = 2; // matricoje žymimas 5;
    int duo3Lives = 2; // matricoje žymimas 4;
    // du vienviečiai matricoje žymimi 2 ir 3, jiems nereikalingi gyvybių counteriai,
    // nes pataikymas ir reiškia sunaikinimą.

    int totalLives; //1*4 + 2*3 + 3*2 + 2*1 = 18    tai - viso laivyno gyvybės.
    int shootCount;

    BattleShips(int quattuorLives, int triplex1Lives, int triplex2Lives, int duo1Lives, int duo2Lives, int duo3Lives, int totalLives, int shootCount){
        this.quattuorLives = quattuorLives;
        this.triplex1Lives = triplex1Lives;
        this.triplex2Lives = triplex2Lives;
        this.duo1Lives = duo1Lives;
        this.duo2Lives = duo2Lives;
        this.duo3Lives = duo3Lives;
        this.totalLives = totalLives;
        this.shootCount = shootCount;
    }

    public int [][] buildShip(int startPointI, int startPointJ, String shipDirection, int shipSize) {
        int i;
        int j;
        if(Objects.equals(shipDirection, "H")) {
            if (startPointJ + shipSize <= battleArea[startPointI].length){
                for (j = startPointJ; j < startPointJ + shipSize; j++) {
                    if (battleArea[startPointI][j] == 0) {
                        switch (shipSize) {
                            case 4:
                                battleArea[startPointI][j] = 9;
                                break;
                            case 3:
                                if (isTaken8 == false) {
                                    for (j = startPointJ; j < startPointJ + shipSize; j++) {
                                        battleArea[startPointI][j] = 8;
                                    }
                                    isTaken8 = true;
                                } else if (isTaken8 == true) {
                                    for (j = startPointJ; j < startPointJ + shipSize; j++) {
                                        battleArea[startPointI][j] = 7;
                                    }
                                }
                                break;
                            case 2:
                                if (isTaken6 == false) {
                                    isTaken6 = true;
                                    for (j = startPointJ; j < startPointJ + shipSize; j++) {
                                        battleArea[startPointI][j] = 6;
                                    }
                                } else if (isTaken6 == true) {
                                    if (isTaken5 == false) {
                                        isTaken5 = true;
                                        for (j = startPointJ; j < startPointJ + shipSize; j++) {
                                            battleArea[startPointI][j] = 5;
                                        }
                                    } else if (isTaken6 == true && isTaken5 == true) {
                                        for (j = startPointJ; j < startPointJ + shipSize; j++) {
                                            battleArea[startPointI][j] = 4;
                                        }
                                    }
                                }
                                break;
                            case 1:
                                if (isTaken3 == false) {
                                    battleArea[startPointI][startPointJ] = 3;
                                    isTaken3 = true;
                                } else if (isTaken3 == true) {
                                    battleArea[startPointI][startPointJ] = 2;
                                }
                                break;
                        }
                    }
                }
            } else {
                System.out.println("Negalima sukurti laivo su pradžios koordinatėmis: I" +  startPointI + ", J" + startPointJ + ", kryptis: " + shipDirection + ", dydis: " + shipSize + ".");
            }
        } else if(Objects.equals(shipDirection, "V")) {
            if (startPointI + shipSize <= battleArea.length){
                for (i = startPointI; i < startPointI + shipSize; i++) {
                    if (battleArea[i][startPointJ] == 0) {
                        switch (shipSize) {
                            case 4:
                                battleArea[i][startPointJ] = 9;
                                break;
                            case 3:
                                if (isTaken8 == false) {
                                    for (i = startPointI; i < startPointI + shipSize; i++) {
                                        battleArea[i][startPointJ] = 8;
                                    }
                                    isTaken8 = true;
                                } else if (isTaken8 == true) {
                                    for (i = startPointI; i < startPointI + shipSize; i++) {
                                        battleArea[i][startPointJ] = 7;
                                    }
                                }
                                break;
                            case 2:
                                if (isTaken6 == false) {
                                    isTaken6 = true;
                                    for (i = startPointI; i < startPointI + shipSize; i++) {
                                        battleArea[i][startPointJ] = 6;
                                    }
                                } else if (isTaken6 == true) {
                                    if (isTaken5 == false) {
                                        isTaken5 = true;
                                        for (i = startPointI; i < startPointI + shipSize; i++) {
                                            battleArea[i][startPointJ] = 5;
                                        }
                                    } else if (isTaken6 == true && isTaken5 == true) {
                                        for (i = startPointI; i < startPointI + shipSize; i++) {
                                            battleArea[i][startPointJ] = 4;
                                        }
                                    }
                                }
                                break;
                            case 1:
                                if (isTaken3 == false) {
                                    battleArea[startPointI][startPointJ] = 3;
                                    isTaken3 = true;
                                } else if (isTaken3 == true) {
                                    battleArea[startPointI][startPointJ] = 2;
                                }
                                break;
                        }
                    }
                }
            } else {
                System.out.println("Negalima sukurti laivo su pradžios koordinatėmis: I" +  startPointI + ", J" + startPointJ + ", kryptis: " + shipDirection + ", dydis: " + shipSize + ".");
            }
        }

        for(i = 0; i < battleArea.length; i++){
            for (j = 0; j < battleArea[i].length; j++){
                System.out.print(battleArea[i][j]);
            }
            System.out.println();
        }
        System.out.println("----------------");
        return battleArea;
    }

    public int [][] shootAtTest(int shootI, int shootJ) {

        if (battleArea[shootI][shootJ] == 0 || battleArea[shootI][shootJ] == 1 ) {
            System.out.println("Nepataikei...");
            shootCount = shootCount + 1;
            battleArea[shootI][shootJ] = -1;
        } else if (battleArea[shootI][shootJ] == 2 || battleArea[shootI][shootJ] == 3) {
            System.out.println("NUKOVEI vienvietį!");
            shootCount = shootCount + 1;
            totalLives = totalLives - 1;
            battleArea[shootI][shootJ] = -2;
        } else if (battleArea[shootI][shootJ] == 4) {
            shootCount = shootCount + 1;
            totalLives = totalLives - 1;
            duo3Lives = duo3Lives - 1;
            if (duo3Lives > 0) {
                System.out.println("PATAIKEI į laivą!");
            } else if (duo3Lives == 0){
                System.out.println("NUKOVEI dvivietį!!");
            }
            battleArea[shootI][shootJ] = -4;
        } else if (battleArea[shootI][shootJ] == 5) {
            shootCount = shootCount + 1;
            totalLives = totalLives - 1;
            duo2Lives = duo2Lives - 1;
            if (duo2Lives > 0) {
                System.out.println("PATAIKEI į laivą!");
            } else if(duo2Lives == 0) {
                System.out.println("NUKOVEI dvivietį!!");
            }
            battleArea[shootI][shootJ] = -5;
        } else if (battleArea[shootI][shootJ] == 6) {
            shootCount = shootCount + 1;
            totalLives = totalLives - 1;
            duo1Lives = duo1Lives - 1;
            if (duo1Lives > 0) {
                System.out.println("PATAIKEI į laivą!");
            } else if (duo1Lives == 0) {
                System.out.println("NUKOVEI dvivietį!!");
            }
            battleArea[shootI][shootJ] = -6;
        } else if (battleArea[shootI][shootJ] == 7) {
            shootCount = shootCount + 1;
            totalLives = totalLives - 1;
            triplex1Lives = triplex1Lives - 1;
            if (triplex1Lives > 0){
                System.out.println("PATAIKEI į laivą!");
            } else if (triplex1Lives == 0) {
                System.out.println("NUKOVEI trivietį!!");
            }
            battleArea[shootI][shootJ] = -7;
        } else if (battleArea[shootI][shootJ] == 8){
            shootCount = shootCount + 1;
            totalLives = totalLives - 1;
            triplex2Lives = triplex2Lives - 1;
            if (triplex2Lives > 0){
                System.out.println("PATAIKEI į laivą!");
            } else if (triplex2Lives == 0){
                System.out.println("NUKOVEI trivietį!!");
            }
            battleArea[shootI][shootJ] = -8;
        } else if (battleArea[shootI][shootJ] == 9){
            shootCount = shootCount + 1;
            totalLives = totalLives - 1;
            quattuorLives = quattuorLives - 1;
            if (quattuorLives > 0){
                System.out.println("PATAIKEI į laivą!");
            } else if (quattuorLives == 0){
                System.out.println("NUKOVEI keturvietį!!");
            }
            battleArea[shootI][shootJ] = -9;
        } else if (battleArea[shootI][shootJ] < 0){
            System.out.println("Čia jau buvo šauta...");
        }

        BattleShips bs = new BattleShips(quattuorLives, triplex1Lives, triplex2Lives, duo1Lives, duo2Lives, duo3Lives, totalLives, shootCount);

        System.out.println("shootCount: " + shootCount);
        System.out.println("totalLives: " + totalLives);
        System.out.println("sheepsLives sequentially " + quattuorLives + triplex1Lives + triplex2Lives + duo1Lives + duo2Lives + duo3Lives);
        System.out.println("matricos elm.: " + battleArea[shootI][shootJ]);
        return battleArea;
    }


    public static void main(String[] args){
        //Laivų išdėstymo taisyklės
        System.out.println("Flotilę sudaro: vienas keturvietis, du triviečiai, trys dviviečiai, keturi vienviečiai.");
        System.out.println("Laivo forma - tik pailga, laivai gali būti vertikalūs arba horizontalūs.");
        System.out.println("Laivai negali liestis nei kraštais, nei kampais.");
        System.out.print("LAIVO SU TAM TIKRAIS DUOMENŲ RINKINIAIS SUKURTI NEGALIMA:");
        System.out.println(" ARBA PERŽENGIA MŪŠIO LAUKO RIBAS, ARBA PATENKA Į KITO LAIVO APSAUGINĘ ZONĄ.");
        System.out.println("RAPORTAI SPAUSDINAMI PO ŠIA ANTRAŠTE.");

        BattleShips bs = new BattleShips(4,3,3,2,2,2,4,0);

        bs.buildShip( 0, 1, "V", 2); //01V2 (tai mano sugalvoti duomenys testavimui)
        bs.buildShip( 1, 7, "H", 3); //17H3
        bs.buildShip( 3, 2, "H", 4); //32H4
        bs.buildShip( 5, 6, "H", 2); //56H2
        bs.buildShip( 6, 4, "V", 3); //64V3
        bs.buildShip( 8, 1, "H", 2); //81H2
        bs.buildShip( 8, 8, "V", 1); //88H1
        bs.buildShip( 9, 6, "V", 1); //96H1

        //Dabar naikinsime sukurtus laivus

        //BattleShips bs = new BattleShips(4, 3,3,2,2,2, 2,0);

        while (bs.totalLives > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Įveskite šūvio koordinatę i: ");
            int shootI = scanner.nextInt();
            System.out.println("Įveskite šūvio koordinatę j: ");
            int shootJ = scanner.nextInt();

            bs.shootAtTest(shootI, shootJ);
        }

        System.out.println("GAME OVER, mano drauge...");
        System.out.println("Iš viso paleidai " + bs.shootCount + " šūvių(-ius).");
    }
}

