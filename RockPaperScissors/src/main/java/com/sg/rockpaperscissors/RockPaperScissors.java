/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author acole
 */
public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner round = new Scanner(System.in);
        int tie = 0;
        int userScore = 0;
        int computerScore = 0;

        boolean keepPlaying = true;
        do {
            System.out.println("Lets play Rock, Paper, Scissors! Choose how many rounds betweem 1 and 10");
            int numRounds = round.nextInt();

            if (numRounds > 0 && numRounds <= 10) {

            } else {
                System.out.println("Error rounds is out of bounds");
                System.exit(0);
            }

            for (int j = 0; j < numRounds; j++) {
//         User Choice
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your your move r = rock, p = paper, s = scissors");
                String userMove = sc.nextLine();
                if (userMove.equalsIgnoreCase("r")) {
                    userMove = "ROCK";
                } else if (userMove.equalsIgnoreCase("p")) {
                    userMove = "PAPER";
                } else if (userMove.equalsIgnoreCase("s")) {
                    userMove = "SCISSORS";
                }
                System.out.println("You Chose: " + userMove);
//        ComputerChoice
                Random randomNum = new Random();
                String computerMove;
                int computerChoice = randomNum.nextInt(3) + 1;
                if (computerChoice == 1) {
                    computerMove = "ROCK";
                } else if (computerChoice == 2) {
                    computerMove = "PAPER";
                } else {
                    computerMove = "SCISSORS";
                }
                System.out.println("Computer Chose: " + computerMove);
//        Getting Results
                if (userMove == computerMove) {
                    tie++;
                } else if (userMove.equals("ROCK") && computerMove.equals("SCISSORS")) {
                    userScore++;
                } else if (userMove.equals("PAPER") && computerMove.equals("ROCK")) {
                    userScore++;
                } else if (userMove.equals("SCISSORS") && computerMove.equals("PAPER")) {
                    userScore++;
                } else {
                    computerScore++;
                }
                System.out.println("User Score: " + userScore + "\nComputerScore: " + computerScore);

            }
            if (userScore > computerScore) {
                System.out.println("YOU WIN");
            } else if (userScore < computerScore) {
                System.out.println("YOU LOOSE");
            } else {
                System.out.println("YOU TIE");
            }
//            System.out.println("User Score: " +userScore + "\nComputerScore: " +computerScore);

            System.out.println("Would you like to play another round (y/n)");
            userScore = 0;
            computerScore = 0;
            tie = 0;
            String anotherRound = round.nextLine();
            anotherRound = round.nextLine();
            if (anotherRound.equals("y")) {
                keepPlaying = true;
            } else {
                keepPlaying = false;
            }

        } while (keepPlaying == true);
        {

        }

    }
}
