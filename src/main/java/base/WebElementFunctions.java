package base;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementFunctions {
	public static void tb_EnterText(String xpath,String textToEnter,WebDriver driver){
		driver.findElement(By.xpath(xpath)).clear();
		driver.findElement(By.xpath(xpath)).sendKeys(textToEnter);
		//driver.findElement(By.xpath(xpath)).sendKeys(Keys.ENTER);
	
	}
	
	public static void randomEmailText(String xpath,String textToEnter,WebDriver driver) {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000);  
		driver.findElement(By.xpath(xpath)).sendKeys("textToEnter"+randomInt+"@gmail.com" );
	}

	public static void btn_Click(String xpath,WebDriver driver) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static boolean isWebElementDisplayed(String xpath,WebDriver driver) {
		return driver.findElement(By.xpath(xpath)).isDisplayed();
	}
	
	public static String getText(String xpath,WebDriver driver) {
		return driver.findElement(By.xpath(xpath)).getText();
	}
	
	public static String getAttribute(String xpath,WebDriver driver,String name) {
		return driver.findElement(By.xpath(xpath)).getAttribute(name);
	}
	
	public static void dd_selectByIndex(String xpath,int index,WebDriver driver) {
		Select select=new Select(driver.findElement(By.xpath(xpath)));
		select.selectByIndex(index);		
	}
	
	public static void dd_selectByText(String xpath,String text,WebDriver driver) {
		Select select=new Select(driver.findElement(By.xpath(xpath)));	
		select.selectByVisibleText(text);
	}

	}
