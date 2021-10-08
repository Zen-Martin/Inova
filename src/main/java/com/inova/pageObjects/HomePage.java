package com.inova.pageObjects;

import com.inova.config.Configuration;
import com.inova.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends Page {


    @FindBy(id = "footer")
    private WebElement footer;

    @FindBy(xpath = "//header/div[1]/a[1]/img[1]")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(text(),\"Développelent d'applications\")]")
    private WebElement developmentOption;

    private final static Configuration PROP  = Properties.Config;

    public HomePage() {
    }

    public void navigateToHomePage(){
        get(PROP.getEnvironment());
        waitForLoadingPage();
        shortUntil(visibilityOf(logo));
    }

    public void scrollToFooter(){
        shortUntil(visibilityOf(footer));
        scroll((footer.getLocation().getY()-20));
    }

    public String getURLHeader(){
        return driver.getCurrentUrl();
    }

    public String developmentOptionText(){
        return developmentOption.getText();
    }

    public boolean verifySecurePage(){
        System.out.println("\n Page URL : "+getURLHeader());
        if (getURLHeader().contains("https")){
            System.out.println("\n Secured URL : "
                    + "\n\n\tBug Corrigé !!!");
            return true;

        } else {
            System.out.println("\n Unsecured URL : "
                    + "\n\n\tBug Non Corrigé !!!");
            return false;
        }

    }

    public boolean verifyDevelopmentSpelling(){
        System.out.println("\n Option Spelling : "+developmentOptionText());
        if (!developmentOptionText().contains("Développelent")){
            System.out.println("\n Good Spelling : "
                    + "\n\n\tBug Corrigé !!!");
            return true;

        } else {
            System.out.println("\n Bad Spelling : "
                    + "\n\n\tBug Non Corrigé !!!");
            return false;
        }

    }

}
