package com.shadowmydx.machine.clock;

import com.shadowmydx.machine.basic.CircuitPart;
import com.shadowmydx.machine.gate.NOTGate;

public class SingleClock implements CircuitPart {
	
	private NOTGate notGate = new NOTGate();
	 
	public SingleClock() {
		notGate.getInput(1);
	}

	@Override
	public void getInput(Object input) {
		// doesn't accept any input
	}

	@Override
	public Object sendOutput() {
		int result = (int)notGate.sendOutput();
		notGate.getInput(result);
		return result;
	}
	
	public static void main(String[] args) {
		SingleClock clock = new SingleClock();
		for (int i = 0; i < 10; i ++) {
			System.out.println(clock.sendOutput());
		}
	}
}
