package base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	private static Set<String> initialHandles;
	private static String initialHandle;
	private static HashMap<String,String> dynamicData;
	
	public static final String getXpath(String pageName,String elementLocator) throws IOException {
		Properties property=new Properties();
		String pagePropertyFile=pageName+".properties";
		InputStream inStream=Util.class.getClassLoader().getResourceAsStream(pagePropertyFile);
		if(inStream!=null) {
			property.load(inStream);
		}else {
			throw new FileNotFoundException(pagePropertyFile+"not found in the classpath");
		}
		String xpath=property.getProperty(elementLocator);
		return xpath;
	}
	
	public static void setInitialWinHandle(final WebDriver driver) {
		Util.initialHandle=driver.getWindowHandle();
	}
	
	public static void setInitialWinHandles(final WebDriver driver) {
		Util.initialHandles=driver.getWindowHandles();
	}
	
	public static String switchToNewWindow(final WebDriver driver) {
		try {
			new WebDriverWait(driver,6000) {}.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(final WebDriver driver) {
					boolean isLaunched;
					if(driver.getWindowHandles().size() >= Util.initialHandles.size()) {
						isLaunched=true;						
					}else {
						isLaunched=false;
					}
					return isLaunched;
				}
			});
			Set<String> currentHandles=driver.getWindowHandles();
			Iterator<String> i=currentHandles.iterator();
			Iterator<String> iInitialHAndles=Util.initialHandles.iterator();
			String handle=iInitialHAndles.next().toString();
			while(i.hasNext()) {
				String popupHandle=i.next().toString();
				if(!popupHandle.contains(handle)) {
					driver.switchTo().window(popupHandle);
				}
			}			
		}catch(Exception e) {
			return "FAIL";
		}
		return "PASS";
	}
	
	public static void closeCurrentBrowserWindow(final WebDriver driver) {
		driver.close();
	}
	
	public static String switchToInitialWindow(final WebDriver driver) {
		try {
			
		}catch(Exception e) {
			return "FAIL";
		}
		return "TRUE";
	}
	
	public static void switchToWindow(final WebDriver driver,final String windowNumber) throws InterruptedException {
		int cell;
		cell=Integer.parseInt(windowNumber);
		for(int i=0;i<10;i++) {
			Set<String> h=driver.getWindowHandles();
			Object windows[]=h.toArray();
			if(windows.length>cell) {
				driver.switchTo().window(windows[cell].toString());
			}else {
				Thread.sleep(3000);
			}
		}
	}
	
	public static boolean checkIfTextContains(final WebDriver driver,final WebElement element,final String text) {
		JavascriptExecutor js=null;
		js=(JavascriptExecutor)driver;
		try {
			if(element.getText().trim().toLowerCase().contains(text.toLowerCase())) {
				js.executeScript("arguments[0].setAttribute('style',arguments[1]);",element,"color:black;border:4px solid green;");
				return true;
			}else {
				js.executeScript("arguments[0].setAttribute('style',arguments[1]);",element,"color:black;border:4px solid red;");
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			//assertThat(element.getText().trim()+"is displayed instead of"+text,false);
			return false;
		}
	}
	
	public static String getDynamicData(final String name) {
		return Util.dynamicData.get(name);
	}
	
	public static void setDynamicData(final String name,final String value) {
		if(Util.dynamicData==null) {
			Util.dynamicData=new HashMap<String,String>();
		}
		Util.dynamicData.put(name, value);
	}
	
	public static void maximizeWindow(final WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public static void highlightGreenBox(final WebDriver driver,final WebElement element) {
		try {
			JavascriptExecutor js=null;
			js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"color:black;border:4px solid green;");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void highlightRedBox(final WebDriver driver,final WebElement element) {
		try {
			JavascriptExecutor js=null;
			js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,"color:black;border:4px solid red;");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
  

}
