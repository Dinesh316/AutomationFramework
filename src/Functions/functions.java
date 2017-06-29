package Functions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import ObjectRepository.Objects;

public class functions {
	 
	protected static WebDriver wd;
	
	//Login into the Application
	public static WebDriver ApplicationLogin() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "/Users/dinesh/Documents/workspace/NewProjectOne/bin/chromedriver");
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--kiosk");
	    wd = new ChromeDriver(chromeOptions);
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //Opening the URL
        wd.get("https://vr66-dgondhesi");
        Thread.sleep(1000);
        //Entering the user name
  	  	Objects.LoginPage.userName(wd).sendKeys("admin");
  	  	//Entering the password
  	  	Objects.LoginPage.password(wd).sendKeys("P@ssw0rd1");
  	  	//Click on the Login Button
  	  	Objects.LoginPage.loginButton(wd).click();
  	  	Thread.sleep(10000);
		return wd;
  	  	}
		
	//Get Value from XML
	public static String GetValueFromXML(String xmlPath,String tagname) throws IOException, ParserConfigurationException, SAXException{
		String searchkey=null;
		File fXmlFile = new File(xmlPath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		NodeList nList = doc.getElementsByTagName(tagname);
		

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;
				searchkey=(eElement.getAttribute("value"));
			}
		}
		return searchkey;
			
	}
	//Create Credentials
	public static void AddCredentials(WebDriver wd,String searchkey,String FilePath,String sheetName) throws IOException{
		 File file =    new File(FilePath);
		 Workbook names = null;
		 FileInputStream inputStream = new FileInputStream(file);
		 names = new HSSFWorkbook(inputStream);
		 Sheet sheet = names.getSheet(sheetName);
		 int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
		 for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		  
         Row row = sheet.getRow(i);
         	DataFormatter formatter = new DataFormatter();
         	Cell cell = sheet.getRow(i).getCell(0);
         	 String keyValue = formatter.formatCellValue(cell);
         	 
         	 try {
   				Thread.sleep(3000);
   			} catch (InterruptedException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}

         	 if(keyValue.equals("Credentials "+searchkey)){

		      		  WebElement wait22 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.AddCredentialButton(wd)));
		      		  Objects.SolutionsPage.AddCredentialButton(wd).click();
		      		  
					 try {
		 				Thread.sleep(3000);
		 			} catch (InterruptedException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 			}
					 
					int rowvalue=i;
        		 for(int columnvalue=1;columnvalue<row.getLastCellNum();columnvalue++){
        			 Cell columnValue=sheet.getRow(0).getCell(columnvalue);
        			 Cell value = sheet.getRow(rowvalue).getCell(columnvalue);
        			 String heading = formatter.formatCellValue(columnValue);
        			 String actValue=formatter.formatCellValue(value);
        			 
        			if(heading.equals("credentialName")||heading.equals("user")){
        				 if(!"".equals(actValue)){
        				 WebElement wait1 = (new WebDriverWait(wd, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//input[contains(@name,'"+heading+"')]")));
        				  WebElement credentials=wd.findElement(By.xpath("//div//div//input[contains(@name,'"+heading+"')]"));
        				 credentials.clear();
        				credentials.sendKeys(actValue);
        			
        				 }
        			}
        			if(heading.equals("password")){
        				if(!"".equals(actValue)){
           				 	WebElement wait1 = (new WebDriverWait(wd, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div//input[contains(@type,'"+heading+"')]")));
           				 	WebElement credentials=wd.findElement(By.xpath("//div//div//input[contains(@type,'"+heading+"')]"));
           				 	credentials.clear();
           				 	credentials.sendKeys(actValue);
        				
           				 WebElement wait2221 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.OKButtonAdapterTest(wd)));
           				 Objects.SolutionsPage.OKButtonAdapterTest(wd).click();
						 
        				}
        			}

        			

         	 }
				  
         	 }	
		 }
	}
	
	//Create Instances
	public static void CreateInstances(WebDriver wd,String searchkey,String FilePath,String sheetName) throws IOException{
		
       File file1 =    new File(FilePath);
       Workbook names1 = null;
       FileInputStream inputStream1 = new FileInputStream(file1);
       names1 = new HSSFWorkbook(inputStream1);
       Sheet sheet1 = names1.getSheet(sheetName);
       int rowCount1 = sheet1.getLastRowNum()-sheet1.getFirstRowNum();
       for (int i1 = 1; i1 <= sheet1.getLastRowNum(); i1++) {
		  
	   Row row1 = sheet1.getRow(i1);
	   DataFormatter formatter1 = new DataFormatter();
	   Cell cell1 = sheet1.getRow(i1).getCell(0);
	   String keyValue1 = formatter1.formatCellValue(cell1);

	   	 if(keyValue1.equals(searchkey)){
	        	if(i1!=1){
					  WebElement wait21 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.AddInstance(wd)));
					  Objects.SolutionsPage.AddInstance(wd).click();
				}
	
	        	 try {
	 				Thread.sleep(3000);
	 			} catch (InterruptedException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
           		 //To expand advanced settings
           		 WebElement wait212 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.AdvancedSettingsExpandButton(wd)));
           		 Objects.SolutionsPage.AdvancedSettingsExpandButton(wd).click();
  				  
           		 int rowvalue=i1;
           		 for(int columnvalue=1;columnvalue<row1.getLastCellNum();columnvalue++){
           			 Cell columnValue=sheet1.getRow(0).getCell(columnvalue);
           			 Cell value = sheet1.getRow(rowvalue).getCell(columnvalue);
           			 String heading = formatter1.formatCellValue(columnValue);
           			 String actValue=formatter1.formatCellValue(value);
           			
           			 
           			 if(heading.equals("Collectors/Groups")||heading.equals("SSL Config")||heading.equals("Auto Discovery")||heading.equals("Max Events")||heading.equals("Support Autodiscovery")){
           				 if(!"".equals(actValue)){
           				 WebElement wait1 = (new WebDriverWait(wd, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath("//tr//td//tr[descendant::td[contains(.,'"+heading+"')]]//input[@type='text']")));
           				  WebElement collectorNameClick=wd.findElement(By.xpath("//tr//td//tr[descendant::td[contains(.,'"+heading+"')]]//input[@type='text']"));
           				  collectorNameClick.clear();
           				  collectorNameClick.sendKeys(actValue);
           			 }}
           			 else if(heading.equals("Description")){
           				 if(!"".equals(actValue)){
           					 WebElement wait1 = (new WebDriverWait(wd, 15)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.DescriptionTextBox(wd)));
           					 Objects.SolutionsPage.DescriptionTextBox(wd).clear();
           					 Objects.SolutionsPage.DescriptionTextBox(wd).sendKeys(actValue);
           			 }}
           			 else if(!"".equals(actValue)){
           				 WebElement instanceName = wd.findElement(By.xpath("//tr[descendant::td[contains(.,'"+heading+"')]]//input[@type='text']"));		
           				  instanceName.clear();
           				  instanceName.sendKeys(actValue);
           			 }  
           		 }
				  WebElement wait11 = (new WebDriverWait(wd, 10)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.TestConnectionButton(wd)));
				  Objects.SolutionsPage.TestConnectionButton(wd).click();
				  
				  WebElement wait121 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='messagebox-1002-msg']/div")));
				  if(wd.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div")).getText().equals("Test connection successful.")){
				  	  System.out.println("PASSED: Test connection successful");
				  }
				  else{
				  	  System.out.println("FAILED:Test connection NOT successful ");
				  }
				  Objects.SolutionsPage.OKButtonAdapterSaved(wd).click();
				  
				  Objects.SolutionsPage.SaveSettingsButton(wd).click();
				  
				  WebElement wait1211 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='messagebox-1002-msg']/div")));
				  if(wd.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div")).getText().equals("Adapter instance successfully saved.")){
					  System.out.println("Adapter instance successfully saved.");
				  }
				  else{
					  System.out.println("Problem in saving Adapter instance.");
				  }
				  try {
		 				Thread.sleep(10000);
		 			} catch (InterruptedException e) {
		 				// TODO Auto-generated catch block
		 				e.printStackTrace();
		 			}
				  
				  Objects.SolutionsPage.OKButtonAdapterSaved(wd).click();
			      }
       		}

		}
	
	//To install a management pack

	public static void InstallManagementPackandAddLicense(WebDriver wd,String searchkey,String FilePath,String sheetName) throws IOException{

	 File file =    new File("/Users/dinesh/Documents/workspace/NewProjectOne/src/TestData/InstanceCreation.xls"); 
     Workbook names = null;
     FileInputStream inputStream = new FileInputStream(file);
     names = new HSSFWorkbook(inputStream);
     Sheet sheet = names.getSheet("namesSheet");
     int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();

     for (int i = 1; i <= sheet.getLastRowNum(); i++) {
		  
         Row row = sheet.getRow(i);
         	DataFormatter formatter = new DataFormatter();
         	Cell cell = sheet.getRow(i).getCell(0);
         	 String keyValue = formatter.formatCellValue(cell);
         if(keyValue.equals("MP "+searchkey)){ 	
         	
   		  WebElement wait22 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.AddSolutionButton(wd)));
   		  Objects.SolutionsPage.AddSolutionButton(wd).click();
 		  
     	  int rowvalue=i;
     		 for(int columnvalue=1;columnvalue<row.getLastCellNum();columnvalue++){
     			 Cell columnValue=sheet.getRow(0).getCell(columnvalue);
     			 Cell value = sheet.getRow(rowvalue).getCell(columnvalue);
     			 String heading = formatter.formatCellValue(columnValue);
     			 String actValue=formatter.formatCellValue(value);

				   if(heading.equals("MPLocalPath")||heading.equals("licenseKeyValue")){
				 	  if(heading.equals("MPLocalPath")){
				 		 Objects.SolutionsPage.BrowseSolutionTextBox(wd).sendKeys(actValue);		
					  try {			  
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
	  
	  WebElement wait3 = (new WebDriverWait(wd, 10)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.InstallPAKCheckBox(wd)));
	  Objects.SolutionsPage.InstallPAKCheckBox(wd).click();
	  
	  WebElement wait4 = (new WebDriverWait(wd, 10)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.ResetDefaultContentCheckBox(wd)));
	  Objects.SolutionsPage.ResetDefaultContentCheckBox(wd).click();
	  
	  WebElement wait5 = (new WebDriverWait(wd, 10)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.IunderstandCheckBox(wd)));
	  Objects.SolutionsPage.IunderstandCheckBox(wd).click();
	  
	  WebElement wait1211 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.OKButton(wd)));
	  Objects.SolutionsPage.OKButton(wd).click();
	  
	  WebElement wait2 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.UploadButton(wd)));
	  Objects.SolutionsPage.UploadButton(wd).click();

	  WebElement myDynamicElement = (new WebDriverWait(wd, 600)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr//td[contains(.,'The PAK file has been uploaded and is ready to install.')]")));
	  
	  WebElement wait21 = (new WebDriverWait(wd,10)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.NextButton(wd)));
	  Objects.SolutionsPage.NextButton(wd).click();

	  WebElement wait212 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.YesButton(wd)));
	  Objects.SolutionsPage.YesButton(wd).click();
	  
	  try {			  
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	  
	  WebElement wait = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.AcceptAgreementCheckBox(wd)));
	  Objects.SolutionsPage.AcceptAgreementCheckBox(wd).click();
	  
	  try {			  
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	} 
	  
	  WebElement wait2122 = (new WebDriverWait(wd,10)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.NextButton1(wd)));
	  Objects.SolutionsPage.NextButton1(wd).click();
	  
	  
	  WebElement finishButton = (new WebDriverWait(wd, 1200)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.FinishButton(wd)));
	  finishButton.click();
	  
	  	try {			  
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	
	  
	  WebElement wait2222 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.ManagementLink(wd)));
	  Objects.SolutionsPage.ManagementLink(wd).click();
	  
	    WebElement wait222 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.LicensingLink(wd)));
	    Objects.SolutionsPage.LicensingLink(wd).click();
	  	
	  	try {			  
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	  	
	  	
		  WebElement wait221 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.AddLicenseButton(wd)));
		  Objects.SolutionsPage.AddLicenseButton(wd).click();

		  WebElement wait2212 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.LicenseSolution(wd)));
		  Objects.SolutionsPage.LicenseSolution(wd).click();
		  wd.findElement(By.xpath("//div//ul//div[contains(.,'"+searchkey+"')]")).click();
 	  }			  
		  if(heading.equals("licenseKeyValue")){
			  WebElement wait2211 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.LicenseKeyTextBox(wd)));
			  Objects.SolutionsPage.LicenseKeyTextBox(wd).clear();
			  Objects.SolutionsPage.LicenseKeyTextBox(wd).sendKeys(actValue);
			 
		  
		
		  WebElement wait6 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.ValidateButton(wd)));
		  Objects.SolutionsPage.ValidateButton(wd).click();
		  
		  WebElement myDynamicElement1 = (new WebDriverWait(wd, 30)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//div//p[contains(.,'License key validated successfully.')]")));
		
		  if(myDynamicElement1.isDisplayed()){
			  System.out.println("License key validated successfully");
			  
			  WebElement wait7 = (new WebDriverWait(wd, 20)).until(ExpectedConditions.elementToBeClickable(Objects.SolutionsPage.LicenseSaveButton(wd)));
			  Objects.SolutionsPage.LicenseSaveButton(wd).click();	
		  }
		  else{
			  System.out.println("License key not validated successfully");
		  }
		  } }		  }
         		 }}

	 }
	
	
//End of Functions	
}
	


