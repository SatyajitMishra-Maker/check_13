package vtiger.pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.genericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")
	private WebElement firstNameTF;
	@FindBy(name="lastname")
	private WebElement lastNameTF;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	@FindBy(xpath="//td[@class='dvtCellInfo']/input[@value='T']")
	private WebElement groupRadioButton;
	@FindBy(name="assigned_group_id")
	private WebElement groupDropDown;
	
	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}
	public WebElement getGroupDropDown() {
		return groupDropDown;
	}
	public WebElement getFirstNameTF() {
		return firstNameTF;
	}
	public WebElement getLastNameTF() {
		return lastNameTF;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createContact(String name)
	{
		lastNameTF.sendKeys(name);
	}
	public void editContact(String firstName)
	{
		firstNameTF.sendKeys(firstName);
		saveButton.click();
	}
	public void selectDropDown(String groupName)
	{
		groupRadioButton.click();
		selectOption(groupDropDown, groupName);
		saveButton.click();
	}
	
	

}
