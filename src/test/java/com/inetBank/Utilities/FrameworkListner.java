package com.inetBank.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetBank.TestCases.BaseClass;

public class FrameworkListner extends TestListenerAdapter{

	

	ExtentHtmlReporter reporter;
	
	ExtentReports  extent;
	
	ExtentTest test;
	

	  public void onTestSuccess(ITestResult tr)
	  {  
		  test=extent.createTest(tr.getName());
test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));   
		  
	  }


	  public void onTestFailure(ITestResult tr) {
		 
			      test=extent.createTest(tr.getName());
test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));   
 
	   EventFiringWebDriver efw=new EventFiringWebDriver(BaseClass.driver);
	   File f1=efw.getScreenshotAs(OutputType.FILE);
String date=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
String screenshotpath=System.getProperty("user.dir")+"//Screenshots//"+tr.getName()+date+".png" ;
	   	File f2=new File(screenshotpath);
	   try {
	
		
		   test.addScreenCaptureFromPath(screenshotpath,tr.getName());
		   BaseClass.log.info("------Screenshot Captured------");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
          
		  
	  }


	  public void onTestSkipped(ITestResult tr) {
		  test=extent.createTest(tr.getName());
test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));   
			
		  
	  }



	
	  public void onStart(ITestContext testContext)
	  {
		  
String date=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  String repName="Test-Report"+date+".html";
		  
reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);			
        extent=new ExtentReports();
        extent.attachReporter(reporter);
	    reporter.config().setDocumentTitle("ActiTime Testing");
	    reporter.config().setReportName("Actitime Build No:1 Result");
        reporter.config().setTheme(Theme.STANDARD);
        extent.setSystemInfo("QA","Sira");
        extent.setSystemInfo("Enviroment","Staging Enviroment");
        extent.setSystemInfo("Application Name","ActiTime");
	    
	  }

	
	  public void onFinish(ITestContext testContext)
	  { 
		  
		  extent.flush();
	  }

	
	
}
