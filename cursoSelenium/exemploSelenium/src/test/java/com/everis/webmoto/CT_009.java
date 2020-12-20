package com.everis.webmoto;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class CT_009 {

	static WebDriver driver;

	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webmotors.com.br/");
	}

	@Test
	public void testMenu() {

		String[] menu = { "Comprar", "Vender", "Serviços", "Ajuda", "Entrar" };
		for (String elementos : menu) {
			assertTrue(driver.getPageSource().contains(elementos));

		}
		

	}

	@AfterClass
	public static void quitCloseDriver() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
