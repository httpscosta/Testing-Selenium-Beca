package com.everis.webmoto;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CT_05 {

	static WebDriver driver;

	@BeforeClass
	public static void createDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.webmotors.com.br/");
	}

	@Test
	public void verOfertaSubMenu() {
		driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[1]/div[2]/div/div/a")).click();
		driver.getPageSource().contains("Carro Novos e Usados em Todo Brasil");

		String[] menus = { "Localização", "O que é interessante pra você?", "Marca do carro", "Carros", "Ano", "Preço",
				"Quilometragem", "Opcionais", "Câmbio", "Combustível", "Final da Placa", "Cores", "Carroceria",
				"Categoria", "Ofertas", "Características" };

		for (String elementos : menus) {
			driver.getPageSource().contains(elementos);

		}

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
	public static void quitDriver() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
}
