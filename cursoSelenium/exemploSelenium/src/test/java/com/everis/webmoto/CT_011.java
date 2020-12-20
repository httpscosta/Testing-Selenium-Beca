package com.everis.webmoto;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CT_011 {

	static WebDriver driver;

	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webmotors.com.br/");
	}

	@Test
	public void menuClickCampos() {
		By campoCompra = By.xpath("//*[@id=\"root\"]/header/nav/div/ul/li[1]");
		WebElement pesquisa = driver.findElement(campoCompra);
		pesquisa.click();
		
		By campovender = By.xpath("//*[@id=\"root\"]/header/nav/div/ul/li[2]");
		WebElement pesquisaVenda = driver.findElement(campovender);
		pesquisaVenda.click();

	}

	@AfterClass
	public static void quitDriver() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
}
