package com.netease.a13.testCase;

import com.netease.a13.base.DriverBase;

public class casebase {
	public DriverBase InitDriver(String browser) {
		DriverBase driver = new DriverBase(browser);
		return driver;
	}

}
