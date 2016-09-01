package com.shadowmydx.machine.triode;

public class NmosTriode extends Triode {

	@Override
	public Object sendOutput() {
		if (checkInput() == 1) {
			return 1;
		}
		return 0;
	}

}
