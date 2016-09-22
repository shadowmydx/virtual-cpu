package com.shadowmydx.machine.adder;

import com.shadowmydx.machine.basic.CircuitPart;
import com.shadowmydx.machine.gate.ANDGate;
import com.shadowmydx.machine.gate.XORGate;

public class SingleAdder implements CircuitPart {
	
	private XORGate xorGate = new XORGate();
	private ANDGate andGate = new ANDGate();
	
	public SingleAdder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getInput(Object input) {
		int[] a = (int[]) input;
		xorGate.getInput(a);
		andGate.getInput(a);
	}

	@Override
	public Object sendOutput() {
		// Two output, 0 is result, 1 is carry bit
		int[] b = new int[2];
		b[0] = (int)xorGate.sendOutput();
		b[1] = (int)andGate.sendOutput();
		return b;
	}

}
