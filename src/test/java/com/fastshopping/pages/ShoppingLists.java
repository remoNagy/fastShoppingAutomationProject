package com.fastshopping.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ShoppingLists {

	private WebDriverWait wait;
	private AndroidDriver driver;

	public ShoppingLists(AndroidDriver Adriver, WebDriverWait Await) {
		this.driver = Adriver;
		this.wait = Await;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// Shopping List Page Title
	@AndroidFindBy(accessibility = "Shopping lists")
	private WebElement shoppingListsTitle;

	// New List Button
	@AndroidFindBy(accessibility = "NEW LIST")
	private WebElement newListButton;

	// Show menu Button
	@AndroidFindBy(accessibility = "Show menu")
	private WebElement showMenu;

	// Show Archive Button
	@AndroidFindBy(accessibility = "Archive")
	private WebElement Archive;

	// Show Rename Button
	@AndroidFindBy(accessibility = "Rename")
	private WebElement Rename;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'list1')]")
	private WebElement listElement1;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'list2')]")
	private WebElement listElement2;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'list3')]")
	private WebElement listElement3;

	public boolean isPageDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(shoppingListsTitle));
		return shoppingListsTitle.isDisplayed();
	}

	public void addNewList() {
		wait.until(ExpectedConditions.elementToBeClickable(newListButton)).click();
	}

	public void pressShowMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(showMenu)).click();
	}

	public void pressArchive() {
		wait.until(ExpectedConditions.elementToBeClickable(Archive)).click();
	}

	public void pressRename() {
		wait.until(ExpectedConditions.elementToBeClickable(Rename)).click();
	}

	public void pressList1() {
		wait.until(ExpectedConditions.elementToBeClickable(listElement1)).click();
	}

	public void pressList2() {
		wait.until(ExpectedConditions.elementToBeClickable(listElement2)).click();
	}

	public void pressList3() {
		wait.until(ExpectedConditions.elementToBeClickable(listElement3)).click();
	}

	public void enterListNameUsingKeyboard(String listName) {

		// code to use Android Keyboard
		for (char c : listName.toCharArray()) {
			// Convert char to AndroidKey
			AndroidKey key = AndroidKey.valueOf(String.valueOf(c).toUpperCase());
			driver.pressKey(new KeyEvent(key));
		}
		// Press Keyboard ENTER
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

	}
}
