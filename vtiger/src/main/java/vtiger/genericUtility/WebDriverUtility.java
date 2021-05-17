package vtiger.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Satyajit
 *
 */

public class WebDriverUtility {

	/**
	 * 
	 * @param driver
	 */

	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void WaitAndClick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<35)
		{
			try {
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(5000);
				count++;
			}
		}
	}
	/**
	 * 
	 * @param element
	 * @param option
	 */
	public void selectOption(WebElement element,String option)
	{
		Select select=new Select(element);
		select.selectByVisibleText(option);
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * 
	 * @param value
	 * @param element
	 */
	public void selectOption(String value,WebElement element)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * 
	 * @param element
	 * @param option
	 */
	public void deSelectOption(WebElement element,String option)
	{
		Select select=new Select(element);
		select.selectByVisibleText(option);
	}
	/**
	 * 
	 * @param element
	 * @param index
	 */
	public void deSelectOption(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * 
	 * @param value
	 * @param element
	 */
	public void deSelectOption(String value,WebElement element)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/*
	 * 
	 * 
	 * 
	 */
	public void mouseOver(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	public void switchToWindow(WebDriver driver,String windowTitle)
	{
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext())
		{
			String windowid=it.next();
			String title=driver.switchTo().window(windowid).getTitle();
			if(title.contains(windowTitle))
			{
				break;
			}
		}
	}
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/*
	 * 
	 * 
	 * 
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * 
	 * @param driver
	 * @param attribute
	 */
	public void switchToFrame(WebDriver driver,String attribute)
	{
		driver.switchTo().frame(attribute);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void scroolToElement(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scroollBy(0,"+y+")", element);
	}
	/**
	 * 
	 * @param key
	 * @throws AWTException
	 */
	public void pressEnterKey(KeyEvent key) throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * @author Satyajit
	 * @param driver
	 * @param screenShotname
	 * @throws Throwable
	 */
	public void takeScreenShot(WebDriver driver,String screenShotname) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("./screenshot/"+screenShotname+".png");
		Files.copy(source,destination);
	}
}
