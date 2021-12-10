package com.maveric.ValiadteLogIn;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.maveric.base.TestBasePage;
import com.meveric.loginPage.LogInPage;

public class Validate_LogIn extends TestBasePage {
    @Test
	public void Valiadete_TodaysDeals(Method Name) {
	
	new LogInPage().varifyClickOnTodays_DealsOnAmazon(Name);
	}
}
