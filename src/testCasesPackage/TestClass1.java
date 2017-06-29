package testCasesPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ObjectRepository.Objects;
import Functions.functions;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class TestClass1 {


           protected static WebDriver wd;

           protected static String searchkey;
           @BeforeClass(alwaysRun = true)
           
           public static void startBrowser() throws InterruptedException, IOException  {
        	   System.out.println("Starting Test");
        	   //Getting the management pack name
	  			  try {
	  				searchkey=functions.GetValueFromXML("/Users/dinesh/Documents/workspace/NewProjectOne/bin/testng.xml","searchkey");
	  			} catch (ParserConfigurationException e4) {
	  				// TODO Auto-generated catch block
	  				e4.printStackTrace();
	  			} catch (SAXException e4) {
	  				// TODO Auto-generated catch block
	  				e4.printStackTrace();
	  			}            		
           }
           @Test
           void CreateInstances() throws IOException, InterruptedException {
        	   System.out.println("Instance");
               //To Login into the application
        	   wd=functions.ApplicationLogin();
			  if(Objects.ApplicationHeader.searchBox(wd).isDisplayed()){
				  System.out.println("Home Page is Displayed");
			  }
			  else{
					 System.out.println("HomePage is not Displayed");
			  } 
			  Objects.ApplicationHeader.Administration(wd).click();
		
			  try {
				Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			  
 		  WebElement navigationInstance = wd.findElement(By.xpath("//div[normalize-space()='"+searchkey+"']"));
 		  navigationInstance.click();
         try {
         	Thread.sleep(1000);
         } catch (InterruptedException e2) {
         	// TODO Auto-generated catch block
         	e2.printStackTrace();
         }
         	//To click on the Configuration button
         	Objects.SolutionsPage.ConfigurationButton(wd).click();
         		  
 		  try {
 				Thread.sleep(5000);
 			} catch (InterruptedException e3) {
 				// TODO Auto-generated catch block
 				e3.printStackTrace();
 			}	  
         //To Add Credentials to the management pack	
 		  functions.AddCredentials(wd,searchkey, "/Users/dinesh/Documents/workspace/NewProjectOne/src/TestData/InstanceCreation.xls", "namesSheet");
   		  
   		  try {
   				Thread.sleep(1000);
   			} catch (InterruptedException e1) {
   				// TODO Auto-generated catch block
   				e1.printStackTrace();
   			}	  
   		  
   		//To Create Instances
 		  functions.CreateInstances(wd,searchkey, "/Users/dinesh/Documents/workspace/NewProjectOne/src/TestData/InstanceCreation.xls", "namesSheet"); 
 		  wd.quit();
}

           //set CLASSPATH=/Users/dinesh/Documents/workspace/NewProjectOne/bin/Functions:/Users/dinesh/Documents/workspace/NewProjectOne/bin/ObjectRepository:/Users/dinesh/Documents/workspace/NewProjectOne/bin/testCasesPackage
           //java -cp "../lib/*:" org.testng.TestNG testng.xml

//          @AfterClass
          // <class name="testCasesPackage.InstallManagementPack" />
		
}

