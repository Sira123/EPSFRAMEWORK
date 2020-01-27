package com.inetBank.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.inetBank.pageObjects.ActiveProjectsAndCustomerPage;
import com.inetBank.pageObjects.AddNewProjectPage;
import com.inetBank.pageObjects.OpenTaskPage;

public class CreateProject extends BaseClass{

	
	
	@Test
	public void testCreateProject()
	{
		
       OpenTaskPage otp=new OpenTaskPage();
		
		ActiveProjectsAndCustomerPage apcp=new ActiveProjectsAndCustomerPage();
		
		AddNewProjectPage anpp=new AddNewProjectPage();
		
		otp.clickOnProjectsAndCustomersLink();
		apcp.clickOnAddNewProjectButton();
		anpp.selectCustomerFromDropdown("Sira345");
		anpp.enterProjectName("fffff");
		anpp.clickOnCreateProjectButton();
		
	
	}
}
