package com.inova.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ContactUsPage extends Page{

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "subject")
    private WebElement subjectField;

    @FindBy(tagName = "textarea")
    private WebElement messageField;

    @FindBy(xpath = "//div[contains(text(),'Error: 404 Not Found http://inova-si.com/forms/con')]")
    private WebElement errorField;

    public ContactUsPage() {
    }

    public void fillForm(){
        nameField.sendKeys(config.getEmail().substring(0,4));
        emailField.sendKeys(config.getEmail());
        subjectField.sendKeys("Need help");
        messageField.sendKeys("I want more informations about you");
    }

    public void clickOnSend(){
        subjectField.sendKeys(Keys.ENTER);
        shortUntil(visibilityOf(errorField));
        scroll(300);
    }

    public boolean verifyContactUsFunctionality(){
        return !errorField.isDisplayed();
    }

}
