package com.everis.webmoto;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CT_010 {

	static WebDriver driver;

	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webmotors.com.br/");
	}

	@Test
	public void menuBarraBusca() {
		assertTrue("Se existe a opção Comprar Carros", driver.getPageSource().contains("Comprar Carros"));
		assertTrue("Se existe a opção Comprar Motos", driver.getPageSource().contains("Comprar Motos"));
		assertTrue("Se existe a opção Quero Vender", driver.getPageSource().contains("Quero Vender"));
		assertTrue("Se existe a opção Quero Financiar", driver.getPageSource().contains("Quero Financiar"));

	}

	@After
	public void takeScreenshot() throws IOException {
		SimpleDateFormat formatoDeData = new SimpleDateFormat("yyyyMMdd-HHmmss-SSSS");
		String fileName = formatoDeData.format(new Date());
		String shotName = String.format("%s.png", fileName);
		File finalShotFile = new File("C:\\cursoSelenium\\exemploSelenium\\screenshots", shotName);
		File shotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(shotFile, finalShotFile);
	}

	@AfterClass
	public static void quitCloseDriver() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
