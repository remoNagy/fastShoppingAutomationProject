
package com.fastshopping.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

	private AndroidDriver driver;
	private WebDriverWait wait;

	public Home(AndroidDriver Adriver, WebDriverWait Await) {
		this.driver = Adriver;
		this.wait = Await;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(accessibility = "No list selected")
	private WebElement noListSelected;


	public void goToShoppingLists() {
		wait.until(ExpectedConditions.elementToBeClickable(noListSelected)).click();
	}

}
