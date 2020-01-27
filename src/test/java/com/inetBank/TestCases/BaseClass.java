package com.inetBank.TestCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class BaseClass {
	public static WebDriver driver;
	
	public static Logger log;
	@BeforeTest
	public void OpenBrowser()
	{
		 log = Logger.getLogger(BaseClass.class);
	   PropertyConfigurator.configure("log4j.properties");
	
		System.setProperty("webdriver.chrome.driver", "G://drivers/chromedriver.exe");
	driver = new ChromeDriver();
	log.info("-----Browser opened-----");
    driver.manage().window().maximize();
    log.info("-----browser maximized-----");
    driver.get("http://desktop-hhtfbov:81/login.do");
    log.info("-----URL entered-----");
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);    	
		
	}

	@AfterTest
	public void closeBrowser()
	{
		
		driver.close();
		log.info("----browser closed----");
	}
	
	@BeforeClass
	public void login()
	{
	driver.findElement(By.name("username")).sendKeys("admin");
	log.info("-----UserName entered-----");
	driver.findElement(By.name("pwd")).sendKeys("manager");
	log.info("-------pwd entered-----");
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	log.info("-------login clicked-------");
	}
	
	@AfterClass
	public void logout()
	{
	driver.findElement(By.className("logoutImg")).click();	
	log.info("----logout clicked-------");
	}
}
