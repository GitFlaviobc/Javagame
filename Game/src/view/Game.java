/* **************************************************************************************** */
/*                                                                                          */
/*                                                        :::::::::: :::::::::   :::::::    */
/* Game.java                                             :+:        :+:    :+: :+:    :+    */
/*                                                      +:+        +:+    +:+ +:+           */
/* By: Flavio BC <github.com/GitFlaviobc>             :#::+::#   +#++:++#+  +#+             */
/*                                                   +#+        +#+    +#+ +#+              */
/* Created: 2022/09/04 10:05:51 by Flavio BC        #+#        #+#    #+# #+#    #+#        */
/* Updated: 2022/09/04 18:49:57 by Flavio BC       ###        #########   ########          */
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

	public static void	playGame(int level) {
		System.out.println(CLEAR);
		if (level > 3 || level < 1)
			return ;
		theGame.setCalculation(level);
		System.out.println(
			theGame.getNumberA() + "\n" +
			theGame.getNumberB() + "\n" +
			theGame.getResult() + "\n" +
			theGame.getOp_name()
			);
	}

	public static void	menuGame() {
		int	choice = 1;

		while (choice != EXIT) 
		{
			System.out.println("#------- Welcome to the math game -------#");
			System.out.println("- Current points: " + player_points);
			System.out.println("Pick your challenge!");
			System.out.println("1 - Easy\n2 - Medium\n3 - Hard\n0 - Exit Game");
			try {
				choice = Game.player_input.nextInt();
				playGame(choice);
			} catch (java.util.InputMismatchException err) {
				System.out.println(CLEAR);
				Game.player_input.next();
			}
		}
	}

	public static void	startGame() {
		System.out.println(CLEAR);
		rulesGame();
		menuGame();
	}
	public static void main(String[] args) {
		startGame();
	}
}
