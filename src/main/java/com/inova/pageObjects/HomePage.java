package com.inova.pageObjects;

import com.inova.config.Configuration;
import com.inova.config.Properties;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "//body/footer[@id='footer']/div[1]/div[1]/div[1]/div[1]/form[1]/input[3]")
    private WebElement newsletterEmailField;

    @FindBy(css = "body")
    private WebElement sectionContent;

    @FindBy(linkText = "Consulting")
    private WebElement consultingTab;

    private final static Configuration PROP  = Properties.Config;

    private final static String URI  = PROP.getEnvironment()+"contact.php";

    public HomePage() {
    }

    public void handleAccess(){
        waitForLoadingPage();
        shortUntil(visibilityOf(logo));
    }

    public void navigateToHomePage(){
        get(URI);
        handleAccess();
    }

    public void scrollToFooter(){
        shortUntil(visibilityOf(footer));
        scroll((footer.getLocation().getY()-20));
    }

    /*public String getURLHeader(){
        return driver.getCurrentUrl();
    }*/

    public String developmentOptionText(){
        return developmentOption.getText();
    }

    public boolean isFacebookMultipleOccurrence(){
        return facebookLogo.getAttribute("href")
                           .equals(facebookOption.getAttribute("href"));
    }

    public void setNewsletterEmail(){
        shortUntil(visibilityOf(newsletterEmailField));
        newsletterEmailField.sendKeys(PROP.getEmail());
        newsletterEmailField.sendKeys(Keys.ENTER);
        handleAccess();
    }

    public void goToConsultingSection(){
        clickOn(consultingTab);
        waitForLoadingPage();
        handleAccess();
    }

    public boolean isEffectiveNewsletterRedirection(){
        return sectionContent.getText()
                             .contains("Erreur !: SQLSTATE[HY000]");
    }

    public boolean isInstagramMultipleOccurrence(){
        return instagramLogo.getAttribute("href")
                            .equals(instagramOption.getAttribute("href"));
    }

    public boolean verifySecurePage(){
        System.out.println("\n Page URL : "+driver.getCurrentUrl());
        if (driver.getCurrentUrl().contains("https")){
            System.out.println("\n Secured URL : "
                    + "\n\n\tBug Corrigé !!!");
        } else {
            System.out.println("\n Unsecured URL : "
                    + "\n\n\tBug Non Corrigé !!!");
        }
        return (driver.getCurrentUrl().contains("https"));
    }

    public boolean verifyDevelopmentSpelling(){
        System.out.println("\n Option Spelling : "+developmentOptionText());
        if (!developmentOptionText().contains("Développelent")){
            System.out.println("\n Good Spelling : "
                    + "\n\n\tBug Corrigé !!!");
        } else {
            System.out.println("\n Bad Spelling : "
                    + "\n\n\tBug Non Corrigé !!!");
        }
        return (!developmentOptionText().contains("Développelent"));
    }

    public boolean verifyDuplicateSocialNetwork(){
        System.out.println("\nDuplicate Facebook redirection : "+isFacebookMultipleOccurrence()
        +"\nDuplicate Instagram redirection : "+isInstagramMultipleOccurrence());
        if (isFacebookMultipleOccurrence()==false && isInstagramMultipleOccurrence()==false){
            System.out.println("\n Social Networks redirection non duplicated : "
                    + "\n\n\tBug Corrigé !!!");
        } else {
            System.out.println("\n Social Networks redirection duplicated : "
                    + "\n\n\tBug Non Corrigé !!!");
        }
        return (isFacebookMultipleOccurrence()==false && isInstagramMultipleOccurrence()==false);
    }

    public boolean verifyNewsletterSubscription(){
        System.out.println("\nNewsletter subscription statut : "+isEffectiveNewsletterRedirection());
        if (isEffectiveNewsletterRedirection()==true){
            System.out.println("\n Effective Newsletter subscription : "
                    + "\n\n\tBug Corrigé !!!");
        } else {
            System.out.println("\n Newsletter subscription not effective : "
                    + "\n\n\tBug Non Corrigé !!!");
        }
        return (isEffectiveNewsletterRedirection()==true);
    }

}
