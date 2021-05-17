package vtiger.pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

public class ContactInformationPage extends WebDriverUtility{
	WebDriver driver;
	public ContactInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="Edit")
	private WebElement editButton;
	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement deleteButton;
	public WebElement getEditButton() {
		return editButton;
	}
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	public void clickOnEditButton()
	{
		editButton.click();
	}
	public void clickOnDeleteButton()
	{
		deleteButton.click();
		acceptAlert(driver);
	}

}
