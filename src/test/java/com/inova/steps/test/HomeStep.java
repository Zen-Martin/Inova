package com.inova.steps.test;

import com.inova.context.ScenarioContext;
import com.inova.pageObjects.HomePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class HomeStep implements En {

    public HomeStep(
            HomePage homePage,
            ScenarioContext scenario
    ){

        Given("I am on the homePage", () -> {
            homePage.navigateToHomePage();
        });

        When("Check URL", () -> {
            homePage.verifySecurePage();
        });

        Then("Access is unsecured", () -> {
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifySecurePage(),true);
        });

        When("Scroll to the footer", () -> {
            homePage.scrollToFooter();
        });

        Then("Spelling error at the Development level", () -> {
            homePage.verifyDevelopmentSpelling();
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifyDevelopmentSpelling(),true);
        });



    }

}
