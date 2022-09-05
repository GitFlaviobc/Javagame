/* **************************************************************************************** */
/*                                                                                          */
/*                                                        :::::::::: :::::::::   :::::::    */
/* Game.java                                             :+:        :+:    :+: :+:    :+    */
/*                                                      +:+        +:+    +:+ +:+           */
/* By: Flavio BC <github.com/GitFlaviobc>             :#::+::#   +#++:++#+  +#+             */
/*                                                   +#+        +#+    +#+ +#+              */
/* Created: 2022/09/04 10:05:51 by Flavio BC        #+#        #+#    #+# #+#    #+#        */
/* Updated: 2022/09/04 21:12:09 by Flavio BC       ###        #########   ########          */
/* License: MIT                                                                             */
/*                                                                                          */
/* **************************************************************************************** */

package view;

import java.util.Scanner;
import model.Calculation;

public class Game {
	private static final String CLEAR = "\033[H\033[2J";
	private static final int READY = 1;
	private static final int EXIT = 0;
	private static Calculation theGame = new Calculation();
	private static Scanner player_input = new Scanner(System.in);
	private static int player_points = 0;

	public static void	rulesGame() {
		int	answer = 0;

		while (answer != READY) {
			System.out.println("#------- Welcome to the math game -------#");
			System.out.println("#------- Rules -------#");
			System.out.println("- Pick a level: Easy, Medium or Hard");
			System.out.println("- 2 random number will be given");
			System.out.println("- 1 basic math operation will be showed: Add, Substract, Multiply, Divide");
			System.out.println("- Type the correct Answer\n");
			System.out.println("- You have 15 tries to make 20 points and win the game!\n");
			System.out.println("Easy:\tCorrect = +1 point, Wrong = -3 points");
			System.out.println("Medium:\tCorrect = +2 point, Wrong = -2 points");
			System.out.println("Hard:\tCorrect = +4 point, Wrong = -1 points");
			System.out.println("Ready?\n1 - Yes");
			try {
				answer = Game.player_input.nextInt();
			} catch (java.util.InputMismatchException err) {
				Game.player_input.next();
			}
			System.out.println(CLEAR);
		}
	}

	public static void resultGame(int answer) {
		System.out.println(CLEAR);
		System.out.println("The Result is...");
		if (theGame.getResult() == answer) {
			System.out.println("Correct!!!! =)");
			player_points += theGame.getOp_increment();
		}
		else {
			System.out.println("Wrong!!!! =(");
			if (player_points >= theGame.getOp_reduce())
				player_points -= theGame.getOp_reduce();
			else
				player_points = 0;
		}
		System.out.println("Total points: " + player_points);
		System.out.println("Press enter to keep playing...");
		Game.player_input.nextLine();
		Game.player_input.nextLine();
	}

	public static void	playGame(int level) {
		int	answer;

		System.out.println(CLEAR);
		if (level > 3 || level < 1)
			return ;
		theGame.setCalculation(level);
		System.out.println("Your challenge was picked...");
		System.out.println("Type the result of...");
		System.out.println(theGame.getOp_formula());
		try {
			answer = Game.player_input.nextInt();
			resultGame(answer);
		} catch (java.util.InputMismatchException err) {
			Game.player_input.next();
		}
	}

	public static void	menuGame() {
		int	choice = 1;
		int	tries = 15;

		while (choice != EXIT && player_points < 20) {
			System.out.println(CLEAR);
			System.out.println("#------- Welcome to the math game -------#");
			System.out.println("- Current points: " + player_points + " of 20");
			System.out.println("- Tries " + tries);
			System.out.println("Pick your challenge!");
			System.out.println("1 - Easy(+1 -3)\n2 - Medium(+2 -2)\n3 - Hard(+4 -1)\n0 - Exit Game");
			try {
				choice = Game.player_input.nextInt();
				playGame(choice);
			} catch (java.util.InputMismatchException err) {
				System.out.println(CLEAR);
				Game.player_input.next();
			}
			tries--;
			if (tries == 0)
				break ;
		}
	}

	public static void	finishGame () {
		int choice = 0;

		System.out.println(CLEAR);
		System.out.println("Thank you for playing!");
		if (player_points < 20)
			System.out.println("Better Luck next time!");
		else
			System.out.println("Congratulations you won!\n Total Points: " + player_points);
		System.out.println("Would you like to play again?\n1 - Yes\n2 - No");
		try {
			choice = Game.player_input.nextInt();
		} catch (java.util.InputMismatchException err) {
			System.out.println(CLEAR);
		}
		if (choice == READY)
			startGame();
	}
	public static void	startGame() {
		System.out.println(CLEAR);
		rulesGame();
		menuGame();
		finishGame();
	}
	public static void main(String[] args) {
		startGame();
	}
}
