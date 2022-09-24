package util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

	public static WebDriver broswerType(String broswerName) {
		switch (broswerName) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();
		case "edge":
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver();
		default:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
		}

	}

	public static String getProperty(String Key) {
		try {
			Properties prop = new Properties();
			File f = new File("Config.properties");
			FileInputStream fio = new FileInputStream(f);
			prop.load(fio);
			return prop.getProperty(Key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
