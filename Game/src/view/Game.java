package view;

import model.test;

public class Game {
	public static void main(String[] args) throws Exception {
		test oi = new test();
		oi.numb = 3;
		System.out.println("Hello, World! " + oi.getNumb());
	}
}
