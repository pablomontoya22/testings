package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestApp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/home/pablo/Descargas/chromedriver_linux64/chromedriver");

		ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--headless");

		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.get("http://www.lapatilla.com/");

		System.out.println("\tLa patilla:");

		drawSeparator();
		System.out.println("\n\tTitulares");
		drawSeparator();

		for (WebElement e : driver.findElements(By.cssSelector("div.slider-title a.post-title"))) {
			System.out.println("\n\tNoticia: " + e.getAttribute("innerHTML").trim());
			System.out.println("\tEnlace: " + e.getAttribute("href") + "\n");
		}

		drawSeparator();
		System.out.println("\n\tNoticias");
		drawSeparator();

		for (WebElement e : driver.findElements(By.tagName("h4"))) {
			System.out.println("\n\tNoticia: " + e.getText());
			System.out.println("\tEnlace: " + e.findElement(By.xpath("..")).getAttribute("href") + "\n");
		}

	}

	static private void drawSeparator() {
		System.out.print("\n\t");
		for (int i=0; i<15; i++) System.out.print("-----");
		System.out.println();
	}
}
