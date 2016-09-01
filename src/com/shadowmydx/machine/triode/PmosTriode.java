package com.shadowmydx.machine.triode;

public class PmosTriode extends Triode {

	@Override
	public Object sendOutput() {
		if (checkInput() == 1) {
			return 0;
		}
		return 1;
	}

}
