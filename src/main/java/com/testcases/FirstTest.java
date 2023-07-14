package com.testcases;

import org.openqa.selenium.By;

import com.web.base.BaseTest;
import com.web.util.FileUtil;
import com.web.util.JsonUtil;

public class FirstTest extends BaseTest {
	private static String testid; 
	private static String testScenario; 
	private static String testDescription;
	

	public FirstTest() {
		super(testid, testScenario, testDescription);
		
	}

	@Override
	public void runTest() throws Exception {
		
		String testDataFile=JsonUtil.readJsonTestDataFile("testdata.json");
		getBrowser("firefox","https://www.selenium.dev/selenium/web/web-form.html");
		
		//ChromeOptions option = new ChromeOptions();
		//WebDriver driver= new ChromeDriver(option);
		//driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		Thread.sleep(5000);
		String testIdLocator= FileUtil.readLocators("homePage", "home.id.textId");
		String testIdTestData = JsonUtil.getJsonValue(testDataFile, "$.data[0].textInput");	
		driver.findElement(By.xpath(testIdLocator)).sendKeys(testIdTestData);
		
		String testPwLocator= FileUtil.readLocators("homePage", "home.name.password");
		String testPwTestdata = JsonUtil.getJsonValue(testDataFile, "$.data[0].password");
		driver.findElement(By.xpath(testPwLocator)).sendKeys(testPwTestdata);
		
		String testAreaLocator=FileUtil.readLocators("homePage", "home.name.textarea");
		String testAreaTestdata = JsonUtil.getJsonValue(testDataFile, "$.data[0].text");
		driver.findElement(By.xpath(testAreaLocator)).sendKeys(testAreaTestdata);
		
		String btnSubmit = FileUtil.readLocators("homePage", "home.btn.submit");
		driver.findElement(By.xpath(btnSubmit)).click();
		
		Thread.sleep(3000);
		driver.close();
	}
	
	

}
