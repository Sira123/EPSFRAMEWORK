package com.inetBank.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetBank.TestCases.BaseClass;

public class AddNewCustomerPage {
	@FindBy(name="name")
	private WebElement customerNameTextBox;
	
@FindBy(name="createCustomerSubmit")
private WebElement createCustomerButton;
	public AddNewCustomerPage()
    {
   	 
   	PageFactory.initElements(BaseClass.driver, this);
   	 
    }
 
 
 public void enterCustmerName(String Customername)
 {
	 customerNameTextBox.sendKeys(Customername);
	  
 }
public void clickOnCreateCustomerButton()
{
	createCustomerButton.click();
}
}
