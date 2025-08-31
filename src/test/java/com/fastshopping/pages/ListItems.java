package com.fastshopping.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ListItems {

	private AndroidDriver driver;
	private WebDriverWait wait;

	public ListItems(AndroidDriver Adriver, WebDriverWait Await) {
		this.driver = Adriver;
		this.wait = Await;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Add some items to your list!']/android.widget.Button")
	private WebElement addItems;

	@AndroidFindBy(xpath = "//android.widget.CheckBox")
	private WebElement checkbox;

	// Show Archive Button
	@AndroidFindBy(accessibility = "Archive")
	private WebElement Archive;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='skincare']")
	private WebElement skinCare;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='beauty']")
	private WebElement beauty;

	@AndroidFindBy(accessibility = "EDIT")
	private WebElement editButton;

	@AndroidFindBy(accessibility = "REMOVE")
	private WebElement removeButton;

	@AndroidFindBy(accessibility = "SAVE")
	private WebElement saveButton;

	public void addItemsClick() {
		wait.until(ExpectedConditions.elementToBeClickable(addItems)).click();
	}

	public void checkBox() {
		wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
	}

	public void archiveItem() {
		wait.until(ExpectedConditions.elementToBeClickable(Archive)).click();
	}

	public void beautyClick() {
		wait.until(ExpectedConditions.elementToBeClickable(beauty)).click();
	}

	public void skinCareClick() {
		wait.until(ExpectedConditions.elementToBeClickable(skinCare)).click();
	}

	public void editClick() {
		wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
	}

	public void removeButtonClick() {
		wait.until(ExpectedConditions.visibilityOf(removeButton)).click();
	}

	public void saveButtonClick() {
		wait.until(ExpectedConditions.visibilityOf(saveButton)).click();
	}

	public void enterItemNameUsingKeyboard(String ItemName) {

		// code to use Android Keyboard
		for (char c : ItemName.toCharArray()) {
			// Convert char to AndroidKey
			AndroidKey key = AndroidKey.valueOf(String.valueOf(c).toUpperCase());
			driver.pressKey(new KeyEvent(key));
		}
		// Press Keyboard ENTER
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));

	}

}
