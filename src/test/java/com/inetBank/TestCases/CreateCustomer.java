package com.inetBank.TestCases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.inetBank.pageObjects.ActiveProjectsAndCustomerPage;
import com.inetBank.pageObjects.AddNewCustomerPage;
import com.inetBank.pageObjects.OpenTaskPage;

public class CreateCustomer extends BaseClass {
   @Test
	public void testCreateCustomer()
	{
		OpenTaskPage otp=new OpenTaskPage();
		
		ActiveProjectsAndCustomerPage apcp=new ActiveProjectsAndCustomerPage();
		
		AddNewCustomerPage ancp=new AddNewCustomerPage();
	
		
		otp.clickOnProjectsAndCustomersLink();
	log.info("---Projects and customers clicked-----");
		apcp.clickOnAddNewCustomerButton();
		log.info("---Addnew Customer is clicked clicked-----");
		
		ancp.enterCustmerName("Sira345");
		log.info("---Customername entered-----");
		
		ancp.clickOnCreateCustomerButton();
		log.info("---Customer created successfully-----");
		
	}
   
	
	
}
