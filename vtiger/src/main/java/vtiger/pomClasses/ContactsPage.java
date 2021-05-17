package vtiger.pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility{
	WebDriver driver;
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement creatContactIcon;
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deleteButton;

	public WebElement getDeleteButton() {
		return deleteButton;
	}
	public WebElement getCreatContactIcon() {
		return creatContactIcon;
	}
	public CreateContactPage createContactImg()
	{
		creatContactIcon.click();
		return new CreateContactPage(driver);
	}
	public void clickOnDelete()
	{
		deleteButton.click();
		acceptAlert(driver);
	}

}
