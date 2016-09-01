package com.shadowmydx.machine.gate;

import com.shadowmydx.machine.basic.CircuitPart;

public class ORGate implements CircuitPart {
	private NOTGate notGate = new NOTGate();
	private NORGate norGate = new NORGate();
	@Override
	public void getInput(Object input) {
		int[] a = (int[]) input;
		norGate.getInput(a);
		notGate.getInput(norGate.sendOutput());
	}

	@Override
	public Object sendOutput() {
		// TODO Auto-generated method stub
		return notGate.sendOutput();
	}

}
