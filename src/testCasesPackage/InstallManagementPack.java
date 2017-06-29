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

public class InstallManagementPack {


           protected static WebDriver wd;

           protected static String searchkey;
           @BeforeClass
           
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
  void InstallManagementPack() throws IOException, InterruptedException {
	   System.out.println("Management Pack");
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
		
	   functions.InstallManagementPackandAddLicense(wd,searchkey,"/Users/dinesh/Documents/workspace/NewProjectOne/src/TestData/InstanceCreation.xls","namesSheet");  
   
	   wd.quit();

 
  }

  }
