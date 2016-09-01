package com.shadowmydx.machine.gate;

import com.shadowmydx.machine.basic.CircuitPart;

public class XORGate implements CircuitPart {
	private ORGate orGate = new ORGate();
	private NOTGate notGate = new NOTGate();
	private ANDGate andGate1 = new ANDGate();
	private ANDGate andGate2 = new ANDGate();
	@Override
	public void getInput(Object input) {
		int[] a = (int[]) input;
		orGate.getInput(a);
		andGate1.getInput(a);
		notGate.getInput(andGate1.sendOutput());
		int[] newOutput = new int[2];
		newOutput[0] = (int)orGate.sendOutput();
		newOutput[1] = (int)notGate.sendOutput();
		andGate2.getInput(newOutput);
	}

	@Override
	public Object sendOutput() {
		return andGate2.sendOutput();
	}

}
