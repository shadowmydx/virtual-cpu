package com.shadowmydx.machine.triode;

import com.shadowmydx.machine.basic.CircuitPart;

public abstract class Triode implements CircuitPart {
	
	private int input;
	
	public int checkInput() {
		return this.input;
	}
	
	public void getInput(Object input) {
		this.input = (Integer)input;
	}
}
