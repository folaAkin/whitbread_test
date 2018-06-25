package com.whitebread.apps.stepDefs;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import static org.junit.Assert.*;

import com.whitbread.apps.page_objects.mobile.CategoryPage;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheeseCategoriesStepDef {
	 private static final Log LOG = LogFactory.getLog(CheeseCategoriesStepDef.class);
	 private CategoryPage categoryPage;

	public CheeseCategoriesStepDef(CategoryPage categoryPage) {
		this.categoryPage = categoryPage;
	}

	@Given("^I am on the Cheesessquare app category page and \"([^\"]*)\" is displayed$")
	public void i_am_on_the_Cheesessquare_app_category_page_and_is_displayed(String pageMenu) throws Throwable {
		LOG.info("Checking if Cheesesuare is displayed on the page" );
		assertEquals("Cheesesquare is not dislayed", categoryPage.getCheeseSquareText(), pageMenu);


	}

	@When("^I select the Ellipsis dots on the top right of the App$")
	public void i_select_the_Ellipsis_dots_on_the_top_right_of_the_App() throws Throwable {
		categoryPage.selectEllipsis();

	}

	@Then("^the below categories should be displayed$")
	public void the_below_categories_should_be_displayed(List<String> cheeseCategories) throws Throwable {

		assertTrue("CATEGORY 1 is not displayed on the page",
				categoryPage.getAllCheeseCategory().contains(cheeseCategories.get(0)));

		assertTrue("CATEGORY 2 is not displayed on the page",
				categoryPage.getAllCheeseCategory().contains(cheeseCategories.get(1)));

		assertTrue("CATEGORY 3 is not displayed on the page",
				categoryPage.getAllCheeseCategory().contains(cheeseCategories.get(2)));

	}

	@Given("^I choose a cheese in the list$")
	public void i_select_choose_a() throws Throwable {
		categoryPage.selectCheeseInTheList();

	}

	@Then("^I should see \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_see_and(String info, String friends, String related) throws Throwable {
		assertEquals("Info is not disaplyed", categoryPage.checkInfoIsDispayed(), info);
		assertEquals("Friends is not disaplyed", categoryPage.checkFriendIsDispayed(), friends);
		categoryPage.scrollToElement();
		assertEquals("Related is not disaplyed", categoryPage.checkRelatedIsDispayed(), related);

	}

	@When("^I click on Night mode$")
	public void i_click_on_Night_mode() throws Throwable {
		categoryPage.selectNightModeDropdown();

	}

	@When("^I select Night always mode$")
	public void i_select_Night_always_mode() throws Throwable {
		categoryPage.selectNightAlwaysRadioButton();
	}

}
