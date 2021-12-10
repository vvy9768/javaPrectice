package com.maveric.base;

import com.maveric.genericMethod.GenericMethod;

public class BasePage {
	protected GenericMethod gm;
	public void Intilization() {
	gm=  GenericMethod.getObj();
	}
}
