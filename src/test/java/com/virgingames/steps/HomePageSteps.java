package com.virgingames.steps;

import com.virgingames.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomePageSteps {
    @Given("I am on Homepage")
    public void iAmOnHomepage() {
        new HomePage().getCurrentUrl();
    }

    @And("I have clicked on cookies")
    public void iHaveClickedOnCookies() {
        new HomePage().clickOnAcceptAllCookies();
    }

    @And("I verify the header links from {string}")
    public void iVerifyTheHeaderLinksFromTopMenu(String menu) {
        new  HomePage().selectMenu(menu);
    }

    @When("I click on link All Games in top menu")
    public void iClickOnLinkAllGamesInTopMenu() {
        new HomePage().clickOnAllGames();
    }

    @Then("I navigate to {string} page")
    public void iNavigateToPage(String text) {
        Assert.assertEquals(new HomePage().getOnlineSlotsText(), text);
    }
}