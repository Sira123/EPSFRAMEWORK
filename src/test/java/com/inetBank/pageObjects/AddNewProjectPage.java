package com.inetBank.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.inetBank.TestCases.BaseClass;

public class AddNewProjectPage {
	@FindBy(name="customerId")
	private WebElement customerDropdown;
	
	@FindBy(name="name")
	private WebElement projectNameTextBox;
	
	@FindBy(name="createProjectSubmit")
	private WebElement createProjectButton;
	
	public AddNewProjectPage()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public void selectCustomerFromDropdown(String customername)
	{
	   Select s1=new Select(customerDropdown);
	   s1.selectByVisibleText(customername);
	}
	public void enterProjectName(String name)
	{
		projectNameTextBox.sendKeys(name);
		
	}
	public void clickOnCreateProjectButton()
	{
		createProjectButton.click();
	}
	
	


}
