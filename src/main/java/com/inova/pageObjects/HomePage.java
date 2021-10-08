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

    @FindBy(linkText = "Page Facebook")
    private WebElement facebookOption;

    @FindBy(xpath = "//body/footer[@id='footer']/div[2]/div[1]/div[1]/div[4]/div[1]/a[2]")
    private WebElement facebookLogo;

    @FindBy(linkText = "Page Instagram")
    private WebElement instagramOption;

    @FindBy(xpath = "//body/footer[@id='footer']/div[2]/div[1]/div[1]/div[4]/div[1]/a[3]")
    private WebElement instagramLogo;

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

    public boolean isFacebookMultipleOccurrence(){

        if(facebookLogo.getAttribute("href").equals(facebookOption.getAttribute("href"))){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean isInstagramMultipleOccurrence(){

        if(instagramLogo.getAttribute("href").equals(instagramOption.getAttribute("href"))){
            return true;
        }
        else{
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

    public boolean verifyDuplicateSocialNetwork(){
        System.out.println("\nDuplicate Facebook redirection : "+isFacebookMultipleOccurrence()
        +"\nDuplicate Instagram redirection : "+isInstagramMultipleOccurrence());
        if (isFacebookMultipleOccurrence()==false && isInstagramMultipleOccurrence()==false){
            System.out.println("\n Social Networks redirection non duplicated : "
                    + "\n\n\tBug Corrigé !!!");
            return true;

        } else {
            System.out.println("\n Social Networks redirection duplicated : "
                    + "\n\n\tBug Non Corrigé !!!");
            return false;
        }

    }

}
