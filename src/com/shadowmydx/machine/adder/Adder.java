package com.shadowmydx.machine.adder;

import javax.print.DocFlavor.INPUT_STREAM;

import com.shadowmydx.machine.basic.CircuitPart;

public class Adder implements CircuitPart {
	
	private int bits = 32;
	private CarryAdder[] carryAdders;
	
	public Adder() {
		setupAdder(bits);
	}

	public Adder(int bits) {
		this.bits = bits;
		setupAdder(bits);
	}
	
	private void setupAdder(int bits) {
		carryAdders = new CarryAdder[bits];
		for (int i = 0; i < carryAdders.length; i ++) {
			carryAdders[i] = new CarryAdder();
		}
	}
	
	@Override
	public void getInput(Object input) {
		int[] numberOne = ((int[][])input)[0];
		int[] numberTwo = ((int[][])input)[1];
		int carryBits = 0;
		for (int i = 0; i < numberOne.length; i ++) {
			int[] nextRounds = new int[3];
			nextRounds[2] = carryBits;
			nextRounds[0] = numberOne[i];
			nextRounds[1] = numberTwo[i];
			carryAdders[i].getInput(nextRounds);
			carryBits = ((int[])carryAdders[i].sendOutput())[1];
		}
	}

	@Override
	public Object sendOutput() {
		int[] results = new int[bits + 1];
		for (int i = 0; i < results.length - 1; i ++) {
			results[i] = ((int[])carryAdders[i].sendOutput())[0];
		}
		results[results.length - 1] = ((int[])carryAdders[carryAdders.length - 1].sendOutput())[1];
		return results;
	}
	
	public static void main(String[] args) {
		int[] numberOne = {0,0,0,1,1,0,1,0,1,0,1,1,1};
		int[] numberTwo = {0,0,1,0,1,0,1,0,1,0,1,0,1};
		Adder adder = new Adder(13);
		int[][] inputArray = new int[2][];
		inputArray[0] = numberOne;
		inputArray[1] = numberTwo;
		adder.getInput(inputArray);
		int[] results = (int[]) adder.sendOutput();
		for (Integer num : results) {
			System.out.print(num + " ");
		}
	}
	
}
