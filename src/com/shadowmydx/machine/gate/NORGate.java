package com.shadowmydx.machine.gate;


import com.shadowmydx.machine.basic.CircuitPart;
import com.shadowmydx.machine.triode.NmosTriode;
import com.shadowmydx.machine.triode.PmosTriode;

public class NORGate implements CircuitPart {
	
	private PmosTriode triodeOne = new PmosTriode();
	private PmosTriode triodeTwo = new PmosTriode();
	
	@Override
	public void getInput(Object input) {
		int[] a = (int[]) input;
		triodeOne.getInput(a[0]);
		triodeTwo.getInput(a[1]);
	}

	@Override
	public Object sendOutput() {
		if ((int)triodeOne.sendOutput() == 1 && (int)triodeTwo.sendOutput() == 1) {
			return 1;
		}
		return 0;
	}

}
