package Java.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Amazon_Inputs extends CreateAccount {
	public static File fle;
	public static Properties property;

	public static void Verification(String Verify) {
		try {

			Verify = Verify.toLowerCase();

			switch (Verify) {
			case "empty":
				Thread.sleep(1500);
				// driver.findElement(By.id("continue")).click();
				// String missingText =
				// driver.findElement(By.xpath("//div[@id='auth-email-missing-alert']")).getText();
				String missingText = Amazon_Inputs.locateElement("xpath",
						Amazon_Locators.Login.missingContent).getText();
				if (missingText
						.contains("Enter your email or mobile phone number")) {
					System.out.println("Text is validated ");
				} else {
					System.out.println("Text is not validated");

					break;
				}
			case "Validate":
				// driver.findElement(By.id("continue")).click();

				driver.findElement(By.name("email")).sendKeys("dinesh");
				driver.findElement(By.id("continue")).click();
				String validateText = driver.findElement(
						By.xpath("//span[@class='a-list-item']")).getText();
				if (validateText
						.contains("We cannot find an account with that email address")) {
					System.out.println("Invalid Email has been validated");
				} else {
					System.out.println("Invalid Email has not been validated");
					break;

				}

			}

		}

		catch (Exception e) {
			// e.printStackTrace();
		}

	}

	public static void takescreenshot() {
		/*
		 * Date dt = new Date(); SimpleDateFormat st = new
		 * SimpleDateFormat("ddmmyyHHmmss"); st.format(dt);
		 * System.out.println(st);
		 */
		try {

			int i = 0;
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(".//snap/", "Screenshot.png");
			i++;
			// ts
			FileHandler.copy(src, des);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static WebElement locateElement(String locator, String locValue) {

		switch (locator) {
		case "id":
			return driver.findElement(By.id(locValue));

		case "name":
			return driver.findElement(By.name(locValue));

		case "class":
			return driver.findElement(By.className(locValue));

		case "link":
			return driver.findElement(By.linkText(locValue));

		case "xpath":
			return driver.findElement(By.xpath(locValue));

		default:
			break;
		}
		return null;
	}

	public static void type(WebElement ele, String data) {

		try {
			if (ele.isDisplayed()) {
				ele.click();
				ele.clear();
				ele.sendKeys(data);
				// reportSteps(ele+" data is typed succesfully", "pass");
				Thread.sleep(2000);
			} else {

				System.out.println("The element is not found");
			}
		} catch (Exception e) {
			// reportSteps(ele+" data is not typed", "fail");
			e.printStackTrace();
		}

	}

	public static void click(WebElement ele) {
		try {
			ele.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void itemSearchanddisplayIT() throws InterruptedException {
		Thread.sleep(8000);
		/*
		 * WebDriverWait wait=new WebDriverWait(driver, 20);
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[@class='a-section a-spacing-medium']")));
		 */
		try {
			int i = 1;
			List<WebElement> WebElement = driver.findElements(By
					.xpath("//div[@class='a-section a-spacing-medium']"));
			int count = WebElement.size();
			for (WebElement element : WebElement) {
				String text = driver
						.findElement(
								By.xpath("(//div[@class='a-section a-spacing-medium']//span[1][@class='a-price']//span[@class='a-price-whole'])["
										+ i + "]")).getText();

				String clean = text.replaceAll("[,]", "");
				int number = Integer.parseInt(clean);

				if (number >= 500) {
					// System.out.println(number +"its from integer");
					String product = driver
							.findElement(
									By.xpath("(//div[@class='a-section a-spacing-medium']//span[@class='a-size-medium a-color-base a-text-normal'])["
											+ i + "]")).getText();

					System.out.println();
					System.out.println("Product name is   " + product
							+ " Amount is  " + number);

				}

				i++;
				if (i == count - 1) {
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void action_Keyborad(WebElement elementlocation, String text) throws InterruptedException {
		elementlocation.sendKeys(text);
		Thread.sleep(2000);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.ENTER);
		
		
	}

}