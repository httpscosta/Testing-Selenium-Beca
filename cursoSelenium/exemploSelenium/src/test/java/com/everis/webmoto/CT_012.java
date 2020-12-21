package com.everis.webmoto;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CT_012 {

	static WebDriver driver;

	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webmotors.com.br/");
	}

	@Test
	public void verifiaLinkQueroVender() {
		driver.findElement(By.xpath("//*[@id=\"WhiteBox\"]/div[1]/div[1]/h2[2]/a")).click();
		driver.getPageSource().contains("Anuncie na Webmotors e venda sua moto pelo melhor preço :)");

	}

	@AfterClass
	public static void quitDriver() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}