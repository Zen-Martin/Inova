package com.inova.steps.test;

import com.inova.context.ScenarioContext;
import com.inova.pageObjects.ContactUsPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class ContactUsStep implements En {

    public ContactUsStep(
            ContactUsPage contactUsPage,
            ScenarioContext scenario
    ){

        When("Fill in the form", () -> {
            contactUsPage.fillForm();
        });

        When("Click on Send message", () -> {
            contactUsPage.clickOnSend();
        });

        Then("The redirection of this link should be done to the service block that has the description located on the same page.", () -> {
            contactUsPage.verifyContactUsFunctionality();
        });

        But("The redirection is made on banner of the same page", () -> {
            contactUsPage.saveScreenShotPNG();
            Assert.assertEquals(contactUsPage.verifyContactUsFunctionality(),true);
        });

    }
}
