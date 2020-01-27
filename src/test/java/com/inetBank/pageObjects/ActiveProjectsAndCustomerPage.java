package com.inetBank.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBank.TestCases.BaseClass;

public class ActiveProjectsAndCustomerPage {

	
	   @FindBy(xpath="//input[@value='Add New Project']")	
	   private WebElement addNewProjectButton;
	   
	   @FindBy(className="successmsg")
	   private WebElement successMessage;
	   
	   @FindBy(xpath="//input[@value='Add New Customer']")
	   private WebElement addNewCustomerButton;
	   
	   
	   
	   
	   public ActiveProjectsAndCustomerPage()
	   {
		   PageFactory.initElements(BaseClass.driver, this);
	   }
	  
	   
	   
	   public void clickOnAddNewCustomerButton()
	   {
		   addNewCustomerButton.click();   
	   }
	   public void clickOnAddNewProjectButton()
	   {
		   
		   addNewProjectButton.click();
	   }
	   public String  getSuccessMessage()
	   {
		  return successMessage.getText();
	   }

}
