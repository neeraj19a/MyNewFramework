package com.gurpreet.project;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverOperations extends BaseTest {

	WebDriverWait wait = new WebDriverWait(driver, 18);
	private WebElement webElem;

	public WebDriverOperations onElement(WebElement element) {
		this.webElem = element;
		return this;
	}

	public WebDriverOperations click() {
		webElem.click();
		return this;
	}

	public void click(WebElement element) {
		element.click();
	}

	/**
	 * This function will wait till whole page gets loaded with the mentioned
	 * URL
	 * 
	 * @param pageURL
	 * @return
	 */
	public boolean waitForPageToLoad(final String pageURL) {

		WebDriverWait wait = new WebDriverWait(driver, 45);
		return wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {

				boolean flag = (((JavascriptExecutor) driver)
						.executeScript("return document.readyState")
						.equals("complete"));
				boolean flag1 = driver.getCurrentUrl().contains(pageURL);
				return flag && flag1;

			}
		});
	}

	public void dynamicwait(WebElement elem) {
		wait.until(ExpectedConditions.elementToBeClickable(elem));
	}

	public void printcookie() {
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie);
		}
	}

	public void createorEditCookieValue(String cookiename, String cookievalue) {
		Cookie cookie = driver.manage().getCookieNamed(cookiename);
		driver.manage().deleteCookie(cookie);
		Cookie name = new Cookie(cookiename, cookievalue);
		driver.manage().addCookie(name);
	}

	/**
	 * This function is used to scroll vertical
	 * 
	 * @param startValue
	 * @param endValue
	 */

	public static void scrollVerticallWithCords(int startValue, int endValue) {
		try {
			((JavascriptExecutor) driver).executeScript("scroll(" + startValue
					+ "," + endValue + " );");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function is used to get Tool Tip Text by hovering mouse
	 * 
	 * @param Hover
	 * @return
	 */

	public static String getToolTipTextEditAd(WebElement Hover) {

		Actions ActionChains = new Actions(driver);
		ActionChains.moveToElement(Hover).build().perform();
		String Tooltip = Hover.getAttribute("title");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Tooltip;
	}

	/**
	 * This function is used to generate the String of random length
	 * 
	 * @param length
	 * @return
	 */

	public static String getRandomString(int length) {
		final String charset = "abcdefghijklmnopqrstuvwxyz";
		Random rand = new Random(System.currentTimeMillis());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int pos = rand.nextInt(charset.length());
			sb.append(charset.charAt(pos));
		}
		return sb.toString();
	}

	/**
	 * This function is used to navigate directly to a particular URL
	 * 
	 * @param driver
	 * @param URL
	 */
	public void navigatethirdparty(WebDriver driver, String URL) {
		driver.navigate().to(URL);
	}

	/**
	 * Generic method to Switch to Pop Up, enter element as parameter by which
	 * clicking on it pop up opens
	 * 
	 * @param popup
	 * @return
	 */
	public String switchtoPopup(WebElement popup) {
		String mainWindowHandle = driver.getWindowHandle();
		popup.click();
		Set s = driver.getWindowHandles();
		Iterator ite = s.iterator();
		while (ite.hasNext()) {
			String popupHandle = ite.next().toString();
			if (!popupHandle.contains(mainWindowHandle)) {
				driver.switchTo().window(popupHandle);
			}
		}

		return mainWindowHandle;
	}

	/**
	 * wait for element to be visible and enabled in order to be clickable
	 * 
	 * @param fileName
	 * @param element
	 * @return
	 */

	// Revisit
	public boolean waitForElementToBeClickable(By element) {
		try {
			wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	/**
	 * scroll element to bring in view, scroll down the page
	 * 
	 * @param element
	 */
	public void scrollElementIntoView(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(false);", element);
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wait for Element to be clickable
	 * 
	 * @param element
	 * @return
	 */
	public boolean waitForElementToBeVisible(WebElement element) {
		try {
			wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			return false;
		}

		return true;
	}

}
