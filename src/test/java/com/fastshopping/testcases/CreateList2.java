package com.fastshopping.testcases;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.*;
import com.fastshopping.pages.*;

public class CreateList2 extends BaseClass {

	@Test(priority = 2)
	public void testGoToShoppingLists() {

		// SoftAssert softAssert = new SoftAssert();
		Home homePage = new Home(driver, wait);
		ShoppingLists shoppingList = new ShoppingLists(driver, wait);
		ListItems listItems = new ListItems(driver, wait);

		// will click "No list selected" to go to Add Lists Page
		homePage.goToShoppingLists();

		// Assert to make sure Shopping Lists page opened
		Assert.assertTrue(shoppingList.isPageDisplayed());
		// softAssert.assertAll();

		// Add new List
		shoppingList.addNewList();

		// create New List
		shoppingList.enterListNameUsingKeyboard(config.getDataFromConfig("list2"));

		listItems.addItemsClick();
		// press Add Items
		listItems.enterItemNameUsingKeyboard("skinCare");
		listItems.skinCareClick();
		listItems.editClick();
		listItems.enterItemNameUsingKeyboard("new");
		//listItems.saveButtonClick();

		listItems.removeButtonClick();
		listItems.beautyClick();
		shoppingList.pressShowMenu();
		shoppingList.pressRename();
		shoppingList.enterListNameUsingKeyboard("new");

	}

}
