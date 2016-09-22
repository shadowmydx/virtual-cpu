package com.shadowmydx.machine.gate;

import com.shadowmydx.machine.basic.CircuitPart;

public class ANDGate implements CircuitPart {
	private NORGate norGate = new NORGate();
	private NOTGate notGate1 = new NOTGate();
	private NOTGate notGate2 = new NOTGate();
	@Override
	public void getInput(Object input) {
		int[] a = (int[]) input;
		notGate1.getInput(a[0]);
		notGate2.getInput(a[1]);
		int[] b = new int[2];
		b[0] = (int)notGate1.sendOutput();
		b[1] = (int)notGate2.sendOutput();
		norGate.getInput(b);
	}
	@Override
	public Object sendOutput() {
		return norGate.sendOutput();
	}
	
	public static void main(String[] args) {
		int[] test = {1,1};
		ANDGate andGate = new ANDGate();
		andGate.getInput(test);
		int result = (int) andGate.sendOutput();
		System.out.println(result);
	}
}
