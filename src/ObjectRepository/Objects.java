package ObjectRepository;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Objects {
	
	public static class LoginPage{
		
		public static WebElement userName(WebDriver wd){
			WebElement element = wd.findElement(By.id("userName-inputEl"));
			 return element;
		}
		
		public static WebElement password(WebDriver wd){
			WebElement element = wd.findElement(By.id("password-inputEl"));
			 return element;
		}
		
		public static WebElement loginButton(WebDriver wd){
			WebElement element = wd.findElement(By.id("loginBtn-btnInnerEl"));
			 return element;
		}
	}
	
	public static class ApplicationHeader{
		
		public static WebElement searchBox(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//*[@id='top_level_object_search-inputEl']"));
			 return element;
		}
		
		public static WebElement Home(WebDriver wd){
			WebElement element = wd.findElement(By.linkText("Home"));
			 return element;
		}
		
		public static WebElement Dashboards(WebDriver wd){
			WebElement element = wd.findElement(By.linkText("Dashboards"));
			 return element;
		}
		
		public static WebElement Alerts(WebDriver wd){
			WebElement element = wd.findElement(By.linkText("Alerts"));
			 return element;
		}
		
		public static WebElement Environment(WebDriver wd){
			WebElement element = wd.findElement(By.linkText("Environment"));
			 return element;
		}
		
		public static WebElement Administration(WebDriver wd){
			WebElement element = wd.findElement(By.linkText("Administration"));
			 return element;
		}
	
	}
	
	public static class SolutionsPage{
		
		public static WebElement ConfigurationButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//span[contains(@style,'background-image:url(themes/clarity-light/images/app/configure.png)')]"));
			return element;
			}
		
		public static WebElement AddCredentialButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//tr//td//img[contains(@id,'btnAddCredential')]"));
			return element;
			}
		
		public static WebElement OKButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a[normalize-space()='OK']"));
			return element;
			}
		
		public static WebElement OKButtonAdapterTest(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a[normalize-space()='OK']"));
			return element;
			}
		
		public static WebElement OKButtonAdapterSaved(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a[normalize-space()='OK']"));
			return element;
			}
		
		public static WebElement AddInstance(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a[contains(@id,'addBtn')]"));
			return element;
			}
		
		public static WebElement AdvancedSettingsExpandButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//tr//td//tr[ancestor::td[contains(.,'Advanced Settings')]]//div[@expanded='0']"));
			return element;
			}
		
		public static WebElement DescriptionTextBox(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//tr[descendant::td[contains(.,'Description')]]//textarea[@role='textbox']"));
			return element;
			}
		
		public static WebElement TestConnectionButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a[normalize-space()='Test Connection']"));
			return element;
			}
		
		public static WebElement MessageBox(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//*[@id='messagebox-1002-msg']/div"));
			return element;
			}
		
		public static WebElement SaveSettingsButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//span[normalize-space()='Save Settings']"));
			return element;
			}
		
		public static WebElement AddSolutionButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a//span//span//span[contains(@style,'background-image:url(themes/clarity-light/images/app/toolbar/add.png);')]"));
			return element;
			}
		
		public static WebElement BrowseSolutionTextBox(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//input[@data-ref='fileInputEl' and @accept='.pak']"));
			return element;
			}
		
		public static WebElement InstallPAKCheckBox(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//div//div//label[contains(.,'Install the PAK file even if it is already installed.')]"));
			return element;
			}
		
		public static WebElement ResetDefaultContentCheckBox(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//div//div//label[contains(.,'Reset Default Content,')]"));
			return element;
			}
		
		public static WebElement IunderstandCheckBox(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//div//div//label[contains(.,'I understand')]"));
			return element;
			}
		
		public static WebElement UploadButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a[normalize-space()='Upload']"));			
			return element;
			}
		
		public static WebElement NextButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a[normalize-space()='Next']"));			
			return element;
			}
		
		public static WebElement YesButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a[normalize-space()='Yes']"));	
			return element;
			}
		
		public static WebElement AcceptAgreementCheckBox(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//div//label[contains(.,'I accept the terms of this agreement')]"));
			return element;
			}
		
		public static WebElement NextButton1(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//div//div//div//span//span//span[contains(.,'Next')]"));			
			return element;
			}
		
		public static WebElement FinishButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//div//div//div//span//span//span[contains(.,'Finish')]"));			
			return element;
			}
		
		public static WebElement ManagementLink(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//div//div//label[contains(.,'Management')]"));			
			return element;
			}
		
		public static WebElement LicensingLink(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//div//section//span[contains(.,'Licensing')]"));			
			return element;
			}
		
		public static WebElement AddLicenseButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a//span//span//span[contains(@style,'background-image:url(themes/clarity-light/images/app/toolbar/add.png);')]"));			
			return element;
			}
		
		public static WebElement LicenseSolution(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//input[@name='product-combo-inputEl'and @role='combobox']"));			
			return element;
			}
		
		public static WebElement LicenseKeyTextBox(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//input[@name='licenseKeyValue'and @role='textbox']"));			
			return element;
			}
		
		public static WebElement ValidateButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a//span//span//span[contains(.,'Validate')]"));		
			return element;
			}
		
		public static WebElement LicenseSaveButton(WebDriver wd){
			WebElement element = wd.findElement(By.xpath("//a//span//span//span[contains(.,'Save')]"));		
			return element;
			}
		
		
	}
	

}
