package org.example;

import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int balance = 100;
        
        int bet;
        int payout;
        String playagain;
        
        String[] row;

        System.out.println("********************");
        System.out.println("Welcome to Java Slot");
        System.out.println("Symbols:🍒🍉🍋🔔⭐");
        System.out.println("********************");
        
        while(balance > 0) {
            System.out.println("\nCurrent Balance: $" + balance);
            System.out.println("Enter your bet: ");
            bet = sc.nextInt();
            sc.nextLine();
            
                if(bet > balance) {
                    System.out.println("You cant bet more than $" + balance);
                    continue;
                }
                else if(bet <= 0) {
                    System.out.println("You cant bet less than $0");
                    continue;
                }
             

            System.out.println("Spinning....");
            row = spinRow();
            printRow(row);
            payout = withdraw(bet, row);
            
            if(payout > 0) {
                balance += payout;
                System.out.println("You won: $" + payout);
            }else{
                balance -= bet;
                System.out.println("Your lost: $" + bet);
            }
            System.out.print("Do you want to play again? (Y/N)");
            playagain = sc.nextLine().toUpperCase();
            
            if(!playagain.equals("Y")) {
                break;
            }
            
            
        }
        sc.close();
    }
    
    static String[] spinRow(){
        
        String[] symbols = {"🍒","🍉","🍋","🔔","⭐"};
        
        String[] row = new String[3];

        Random random = new Random();
        
        for(int i = 0; i < 3; i++){
            row[i] = symbols[random.nextInt(symbols.length)];
       
        }
   
        
        return row; 
    }
    static void printRow(String[] row){
        System.out.println("***************");
        System.out.println(" "+String.join("|", row));
        System.out.println("***************");
    }
    static int withdraw(int bet,String[] row){
        
        if(row[0].equals(row[1])) {
            return switch (row[0]) {
                case "🍒" -> bet * 2;
                case "🍉" -> bet * 3;
                case "🍋" -> bet * 4;
                case "🔔" -> bet * 5;
                case "⭐" -> bet * 10;
                default -> 0;
            };
        }
            else if (row[1].equals(row[2])) {
                return switch (row[1]) {
                    case "🍒" -> bet * 2;
                    case "🍉" -> bet * 3;
                    case "🍋" -> bet * 4;
                    case "🔔" -> bet * 5;
                    case "⭐" -> bet * 10;
                    default -> 0;

                };
            }
       
        
        return 0;
    }
    
    
}
