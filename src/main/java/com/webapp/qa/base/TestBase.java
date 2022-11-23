package com.webapp.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
		
	public TestBase() {
		try {
		prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\webapp\\qa\\properties\\config.properties");
		prop.load(file);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void initialization() {
		String br = prop.getProperty("browser");
		if(br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}
		else {
			System.out.println("Browser not found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
