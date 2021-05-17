package vtiger.pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(name="user_name") 
		private WebElement usernameTF;
		@FindBy(name="user_password")
		private WebElement passwordTF;
		@FindBy(id="submitButton")
		private WebElement submitButton;
		
		public WebElement getUsernameTF() {
			return usernameTF;
		}
		public WebElement getPasswordTF() {
			return passwordTF;
		}
		public WebElement getSubmitButton() {
			return submitButton;
		}
		/**
		 * This method use to login to application
		 * @param username
		 * @param password
		 * @return 
		 */
	public HomePage login(String username,String password) {
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		submitButton.click();
		return new HomePage(driver);
	}

}
