package com.inova.steps.test;

import com.inova.context.ScenarioContext;
import com.inova.pageObjects.ConsultingPage;
import io.cucumber.java8.En;
import org.testng.Assert;


public class ConsultingStep implements En {

    public ConsultingStep(
            ConsultingPage consultingPage,
            ScenarioContext scenario
    ){

        When("Click Software integration", () -> {
            consultingPage.clickOnSoftwareIntegration();
        });

        Then("The redirection of each link should be done to each service block that has the description located on the same page.", () -> {
            consultingPage.saveScreenShotPNG();
        });

        But("The redirection is made to the banner of the same page", () -> {
            Assert.assertEquals(consultingPage.verifyLinkRedirection(),true);
        });

        When("Scroll down", () -> {
            consultingPage.goToCommandSection();
        });

        When("Click the Order button of the Ten Pack under Famoco Tool", () -> {
            consultingPage.clickOnOrderButton();
        });

        Then("The action should initiate the order of the pack", () -> {
            consultingPage.saveScreenShotPNG();
        });

        But("No reaction occurs", () -> {
            Assert.assertEquals(consultingPage.verifyOrderRedirection(),true);
        });


    }
}
