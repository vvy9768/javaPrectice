package com.maveric.ValiadteLogIn;


import org.testng.annotations.Test;
import com.maveric.base.TestBasePage;
import com.meveric.loginPage.LogInPage;

public class Validate_LogIn extends TestBasePage {
	
	

    @Test()
    public void test1() {
    	LogInPage logIn=new LogInPage();
    	logIn.userName_In("softech.vire@gmail.com");
    	logIn.passWord_In("Linkedin0432@");
    	logIn.clickOn_signIn_Bt();
    }  

}
