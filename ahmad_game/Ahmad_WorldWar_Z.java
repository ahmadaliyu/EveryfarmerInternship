package com.ahmadee.everyfarmerIntern;

import java.util.Random;
import java.util.Scanner;

public class Ahmad_WorldWar_Z {
    public static void main(String[] args) {

        String strike;

        PlayerOne p1 = new PlayerOne();       // playerOne class object
        int p1StoredlifeSpan = p1.lifespan;

        PlayerTwo p2 = new PlayerTwo();         // computer class object
        int p2StoredlifeSpan = p2.lifespan;

        Scanner scanner = new Scanner(System.in);

        System.out.println("welcome to World War Z!!!!!....choose a weapon to strike, one strike at a time");
        System.out.println("[player1 weapons: SubMachine gun(SMG) and Rifle  player2 weapons: Machine gun(MG) and AK47]");
        System.out.println("Note: strike input must be SMG,MG,Rifle or AK47");

        while(true){
            System.out.print("Player1 or player2 should strike: ");
            strike = scanner.next();
            if (!strike.equals("MG") && !strike.equals("Rifle") && !strike.equals("AK47") && !strike.equals("SMG")){
                System.out.println("Not allowed, use appropriate weapon");
                continue;
            }


            if(strike.equals("MG")){
                p1StoredlifeSpan = p1StoredlifeSpan - 3;      // AK removes 4 points from player1
                System.out.println("player1 has -3 points deducted");
            }else if(strike.equals("AK47")){
                p1StoredlifeSpan = p1StoredlifeSpan - 4;    // SMG removes 2 points from player1
                System.out.println("player1 -4 points deducted");
            }else if(strike.equals("Rifle")){
                p2StoredlifeSpan = p2StoredlifeSpan - 3;
                System.out.println("player2 has -3 points deducted");
            }else if(strike.equals("SMG")){
                p2StoredlifeSpan = p2StoredlifeSpan - 2;
                System.out.println("player2 has -2 points deducted");
            }

            System.out.println("player1 lifespan remain: " + p1StoredlifeSpan);
            System.out.println("player2 lifespan remain: " + p2StoredlifeSpan);
            if (p1StoredlifeSpan <= 0){
                System.out.println("Player 2 wins");
                break;
            }else if(p2StoredlifeSpan <= 0){
                System.out.println("Player 1 wins");
                break;
            }

        }
    }
}

class Game{
    int lifespan = 10;
    void showPlayers(){
        System.out.println("PlayerOne Vs PlayerTwo");
    }
}

class PlayerOne extends Game{
    String rifle = "Rifle", mg = "MG";
    void showWeapon(){
        System.out.println("Striking with a shot gun");
    }
}

class PlayerTwo extends Game{
    String aK47 = "AK47", smg = "SMG";
    void showWeapon(){
        System.out.println("Striking with an Ak47");
    }
    void randomGen(){
        String rand = new Random().nextBoolean() ? aK47 : smg;
        System.out.println(rand);
    }
}
