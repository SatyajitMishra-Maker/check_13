package vtiger.pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	
	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signoutLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}
	public ContactsPage clickContactLink()
	{
		contactlink.click();
		return new ContactsPage(driver);
	}
	public void signout() throws InterruptedException
	{
		mouseOver(driver, signoutImg);
		signoutLink.click();
	}

}
