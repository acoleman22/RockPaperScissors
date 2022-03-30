/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissors;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author acole
 */
public class ImprovedRockPaperScissors {

    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();
    static int amountOfRounds;
    static int tie = 0;
    static int userScore = 0;
    static int computerScore = 0;
    static boolean playAgain;
    

    public static void main(String[] args) {
        
        System.out.println("Would you like to play Rock Paper Scissors(y/n)");
        String playGame = sc.nextLine();
        do {

            if (playGame.equalsIgnoreCase("y")) {
                runGame(askHowManyRounds());
            } else {
                System.out.println("Thats ok maybe next time");
                System.exit(0);
            }
            playAgain();
        } while (playAgain == true);

    }

    public static int askHowManyRounds() {

        System.out.println("How many rounds would you like to play must be "
                + "between 1 and 10");
        try {

            amountOfRounds = sc.nextInt();

        } catch (InputMismatchException ex) {

        }

        return amountOfRounds;
    }

    public static void runGame(int amountOfRounds) {
        String userMove = "";
        String computerMove = "";
        if (amountOfRounds > 0 && amountOfRounds <= 10) {

        } else {
            System.out.println("Error invalid round input");
            System.exit(0);
        }
        for (int i = 1; i <= amountOfRounds; i++) {
            userMove = pickRockPaperScissors();
           
            computerMove = rpsBot();
            System.out.println("userMove is: " + userMove);
            System.out.println("ComputerMove is: " + computerMove);
            rulesRockPaperScissors(userMove, computerMove, i);

        }
        getResults();
    }

    public static String rpsBot() {
        int computerChoice = ran.nextInt(3) + 1;
        String computerMove;
        if (computerChoice == 1) {
            computerMove = "ROCK";
        } else if (computerChoice == 2) {
            computerMove = "PAPER";
        } else {
            computerMove = "SCISSORS";
        }
        return computerMove;
    }

    public static String pickRockPaperScissors() {
        String userMove = "";
        int userInput =0;
        

        
            do {
                try {

                System.out.println("Choose rock paper scissors 1 = ROCK, 2 = PAPER,"
                        + "3 = SCISSORS");
                userInput = sc.nextInt();
                if (userInput == 1) {
                    userMove = "ROCK";
                    
                } else if (userInput == 2) {
                    userMove = "PAPER";
                    
                } else if (userInput == 3) {
                    userMove = "SCISSORS";
                    

                } else {
                    System.out.println("Invalid Number");
                    
                }
                } catch (InputMismatchException ex) {
            System.out.println("you did not enter a number");
            sc.next();
            
                }
            } while (userInput < 1 || userInput > 3);

        return userMove;
    }

    public static void rulesRockPaperScissors(String userMove, String computerMove, int i) {

        if (userMove == computerMove) {
            System.out.println("YOU TIE ROUND: " + i);
            tie++;
        } else if (userMove.equals("ROCK") && computerMove.equals("SCISSORS")) {
            System.out.println("YOU WIN ROUND: " + i);
            userScore++;
        } else if (userMove.equals("PAPER") && computerMove.equals("ROCK")) {
            System.out.println("YOU WIN ROUND: " + i);
            userScore++;
        } else if (userMove.equals("SCISSORS") && computerMove.equals("PAPER")) {
            System.out.println("YOU WIN ROUND: " + i);
            userScore++;
        } else {
            System.out.println("YOU LOOSE ROUND: " + i);
            computerScore++;
        }

    }

    public static void getResults() {

        System.out.println("userScore: " + userScore);
        System.out.println("computerScore: " + computerScore);

        if (userScore > computerScore) {
            System.out.println("YOU WIN");
        } else if (userScore < computerScore) {
            System.out.println("YOU LOOSE");
        } else {
            System.out.println("YOU TIE");
        }

    }

    public static boolean playAgain() {
        playAgain = false;

        System.out.println("Would you like to play again(y/n)");
        String userChoice = sc.nextLine();
        userChoice = sc.nextLine();
        if (userChoice.equalsIgnoreCase("y")) {
            playAgain = true;
        } else {
            System.out.println("Thats ok thanks for playing");
            System.exit(0);
        }

        return playAgain;
    }
}
