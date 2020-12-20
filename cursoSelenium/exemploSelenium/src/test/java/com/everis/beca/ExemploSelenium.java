package com.everis.beca;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ExemploSelenium {
	static WebDriver driver;

	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void testHello() {
		driver.manage().window().maximize();
		driver.get("https://duque.dev");
		assertEquals(driver.getTitle(), "{duque.dev}");
	}
	
	@Test
	public void testMenuOptions() {				
		assertTrue("Se existe a opção Home", driver.getPageSource().contains("Home"));
		assertTrue("Se existe a opção Sobre mim", driver.getPageSource().contains("Sobre Mim"));
		assertTrue("Se existe a opção Valores", driver.getPageSource().contains("Valores"));
		assertTrue("Se existe a opção Portfolio", driver.getPageSource().contains("Portfolio"));
		assertTrue("Se existe a opção Experiência", driver.getPageSource().contains("Experiência"));
		assertTrue("Se existe a opção Blog", driver.getPageSource().contains("Blog"));
		assertTrue("Se existe a opção Contato", driver.getPageSource().contains("Contato")); 
		
		
	}
	
	@Test
	public void testSobreMim() {
//		WebElement saibaMaisButton = driver.findElement(By.xpath());
		By locator = By.xpath("//div/ul/li[2]");
		WebElement sobreMimButton = driver.findElement(locator);
	}
	
	@After
	public void takeScreenshot() throws IOException{
		SimpleDateFormat formatoDeData = new SimpleDateFormat("yyyyMMdd-HHmmss-SSSS");
		String fileName = formatoDeData.format(new Date());
		String shotName = String.format("%s.png", fileName);
		File finalShotFile = new File("C:\\cursoSelenium\\exemploSelenium\\screenshots", shotName);
		File shotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shotFile, finalShotFile);
	}
	
		
	@AfterClass
	public static void quitDriver() {
		driver.quit();
	}
}