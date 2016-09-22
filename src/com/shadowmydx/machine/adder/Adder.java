package com.shadowmydx.machine.adder;

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
		
	}

	@Override
	public Object sendOutput() {
		// TODO Auto-generated method stub
		return null;
	}

}
