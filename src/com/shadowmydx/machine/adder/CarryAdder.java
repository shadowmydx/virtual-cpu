package com.shadowmydx.machine.adder;

import org.omg.CORBA.OBJ_ADAPTER;

import com.shadowmydx.machine.basic.CircuitPart;
import com.shadowmydx.machine.gate.ORGate;

public class CarryAdder implements CircuitPart {
	
	private ORGate orGate = new ORGate();
	private SingleAdder adder1 = new SingleAdder();
	private SingleAdder adder2 = new SingleAdder();
	
	public CarryAdder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getInput(Object input) {
		int[] a = (int[]) input;
		int[] one = new int[2];
		int[] two = new int[2];
		int[] three = new int[2];
		one[0] = a[0];
		one[1] = a[1];
		adder1.getInput(one);
		two[0] = ((int[])adder1.sendOutput())[0];
		two[1] = a[2];
		adder2.getInput(two);
		three[0] = ((int[])adder1.sendOutput())[1];
		three[1] = ((int[])adder2.sendOutput())[1];
		orGate.getInput(three);
	}

	@Override
	public Object sendOutput() {
		// Two output, 0 is result, 1 is carry bit
		int[] result = new int[2];
		result[0] = ((int[])adder2.sendOutput())[0];
		result[1] = (int)orGate.sendOutput();
		return result;
	}

}
