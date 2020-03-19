package io.naztech;


import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreditInfo {
	
	public static String URL = "https://cib.bb.org.bd/";
	public static ChromeDriver driver;
	public static WebDriverWait wait;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		driver = getChromeDriver(true);
		driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		driver.get(URL);
		WebElement elUser = driver.findElement(By.xpath("//input[@name='user_name']"));
		WebElement elPass = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement securityPass = driver.findElement(By.xpath("//label[@class='col-md-4 control-label']"));
		String equation = securityPass.getText().split("\\(")[1].split("\\)")[0].trim();
		log.info(equation);
		System.out.println(doEval(equation));
//		WebElement elLogin = driver.findElement(By.xpath("//button[@id='pt1:logon']"));
//		elUser.sendKeys("ict");
//		elPass.sendKeys("Cbbl%1234");
//		elLogin.click();
		
	}
	public int doEval(String equation) {
		try {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = engine.eval(equation);
		return Integer.parseInt(result.toString());
		}
		catch (Exception e) {
		// keep log here
		return 0;
		}
		}
	
	public static ChromeDriver getChromeDriver(boolean isHeadless) {
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("webdriver/chromedriver.exe")).usingAnyFreePort().build();

		ChromeDriver driver = new ChromeDriver(service, new ChromeOptions().setHeadless(true));
		/*
		 * Developer should increase page load timeout in their scraper class when
		 * needed
		 */
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		return driver;
	}


}
