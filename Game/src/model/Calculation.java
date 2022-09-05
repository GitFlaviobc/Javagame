/* **************************************************************************************** */
/*                                                                                          */
/*                                                        :::::::::: :::::::::   :::::::    */
/* Calculation.java                                      :+:        :+:    :+: :+:    :+    */
/*                                                      +:+        +:+    +:+ +:+           */
/* By: Flavio BC <github.com/GitFlaviobc>             :#::+::#   +#++:++#+  +#+             */
/*                                                   +#+        +#+    +#+ +#+              */
/* Created: 2022/08/30 09:29:55 by Flavio BC        #+#        #+#    #+# #+#    #+#        */
/* Updated: 2022/09/04 20:33:08 by Flavio BC       ###        #########   ########          */
/* License: MIT                                                                             */
/*                                                                                          */
/* **************************************************************************************** */

package model;

import java.util.Random;

public class Calculation {
	private Integer	number_a;
	private Integer	number_b;
	private Integer	result;
	private int		op_index;
	private int		op_increment;
	private int		op_reduce;
	private String	op_name;
	private String	op_formula;

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

	private String	setFormula() {
		return (
			this.number_a.toString() + " " +
			this.op_name + " " +
			this.number_b.toString() +  " " +
			"?"
			);
	}
	public void	setCalculation(int level) {
		Random	numb_rand = new Random();
		int	multiplier = 10;

		this.number_a = numb_rand.nextInt((int)Math.pow(multiplier, level)) + 1;
		this.number_b = numb_rand.nextInt((int)Math.pow(multiplier, level)) + 1;
		this.op_index = numb_rand.nextInt(4);
		this.result = pickOperation(op_index, this.number_a, this.number_b);
		this.op_formula = setFormula();
		this.op_increment = (int)Math.pow(2, level - 1);
		this.op_reduce = 4 - level;
	}
	public int	getResult() {
		return result;
	}
	public String getOp_formula() {
		return op_formula;
	}
	public int getOp_increment() {
		return op_increment;
	}
	public int getOp_reduce() {
		return op_reduce;
	}
}