/* **************************************************************************************** */
/*                                                                                          */
/*                                                        :::::::::: :::::::::   :::::::    */
/* Calculation.java                                      :+:        :+:    :+: :+:    :+    */
/*                                                      +:+        +:+    +:+ +:+           */
/* By: Flavio BC <github.com/GitFlaviobc>             :#::+::#   +#++:++#+  +#+             */
/*                                                   +#+        +#+    +#+ +#+              */
/* Created: 2022/08/30 09:29:55 by Flavio BC        #+#        #+#    #+# #+#    #+#        */
/* Updated: 2022/09/04 19:10:25 by Flavio BC       ###        #########   ########          */
/* License: MIT                                                                             */
/*                                                                                          */
/* **************************************************************************************** */

package model;

import java.util.Random;

public class Calculation {
	private int		number_a;
	private int		number_b;
	private int		result;
	private int		op_index;
	private String	op_name;

	public	Calculation() {};

	private interface	IOperations {
		int pickOperation(int a, int b);
	}
	private int	add(int a, int b) {
		this.op_name = "+";
		return (a + b);
	}
	private int	minus(int a, int b) {
		this.op_name = "-";
		return (a - b);
	}
	private int	multiply(int a, int b) {
		this.op_name = "*";
		return (a * b);
	}
	private int	divide(int a, int b) {
		this.op_name = "/";
		return (a / b);
	}

	private IOperations[] allOperations = new IOperations[4];
	private int	pickOperation(int index, int a, int b) {
		allOperations[0] = this::add;
		allOperations[1] = this::minus;
		allOperations[2] = this::multiply;
		allOperations[3] = this::divide;
		return allOperations[index].pickOperation(a,b);
	}

	public void	setCalculation(int level) {
		Random	numb_rand = new Random();
		int	multiplier = 10;

		this.number_a = numb_rand.nextInt((int)Math.pow(multiplier, level));
		this.number_b = numb_rand.nextInt((int)Math.pow(multiplier, level));
		this.op_index = numb_rand.nextInt(4);
		this.result = pickOperation(op_index, this.number_a, this.number_b);
	}
	public int	getResult() {
		return result;
	}
	public int	getNumberA() {
		return number_a;
	}
	public int	getNumberB() {
		return number_b;
	}
	public String getOp_name() {
		return op_name;
	}
}