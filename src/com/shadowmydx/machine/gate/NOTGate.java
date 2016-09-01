package com.shadowmydx.machine.gate;

import com.shadowmydx.machine.basic.CircuitPart;

public class NOTGate implements CircuitPart {
	
	private NORGate gate = new NORGate();
	
	@Override
	public void getInput(Object input) {
		int[] a = new int[2];
		a[0] = (int)input;
		a[1] = (int)input;
		gate.getInput(a);
	}

	@Override
	public Object sendOutput() {
		return gate.sendOutput();
	}

}
