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

        When("Click on the Consulting tab", () -> {
            homePage.clickOnConsultingTab();
        });

        When("Click on the Contact Us tab", () -> {
            homePage.clickOnContactUsTab();
        });

        Then("Spelling error at the Development level", () -> {
            homePage.verifyDevelopmentSpelling();
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifyDevelopmentSpelling(),true);
        });

        Then("options for redirecting to social networks should appear only one time", () -> {
            homePage.verifyDuplicateSocialNetwork();
        });

        But("Facebook and Instagram social media access options appear in duplicate", () -> {
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifyDuplicateSocialNetwork(),true);
        });

        When("Enter your email address in the newsletter subscription field", () -> {
            homePage.setNewsletterEmail();
        });

        When("Click on the Subscribe button", () -> {
            homePage.clickOnSubscribre();
        });

        Then("A registration confirmation message should appear", () -> {
            homePage.verifyNewsletterSubscription();
        });

        But("We are redirected to a page without content with an error message at the foot of the page", () -> {
            homePage.saveScreenShotPNG();
            Assert.assertEquals(homePage.verifyNewsletterSubscription(),true);
        });

    }

}
