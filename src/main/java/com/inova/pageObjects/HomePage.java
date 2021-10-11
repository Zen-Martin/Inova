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

    @FindBy(linkText = "Nous contacter")
    private WebElement contactUs;

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
        scroll((footer.getLocation().getY()+300));
    }

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
    }

    public void clickOnSubscribre(){
        newsletterEmailField.sendKeys(Keys.ENTER);
        handleAccess();
        scroll(750);
    }

    public void clickOnConsultingTab(){
        clickOn(consultingTab);
        handleAccess();
    }

    public void clickOnContactUsTab(){
        clickOn(contactUs);
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
        return (driver.getCurrentUrl().contains("https"));
    }

    public boolean verifyDevelopmentSpelling(){
        return (!developmentOptionText().contains("Développelent"));
    }

    public boolean verifyDuplicateSocialNetwork(){
        return (!isFacebookMultipleOccurrence() && !isInstagramMultipleOccurrence());
    }

    public boolean verifyNewsletterSubscription(){
        return (!isEffectiveNewsletterRedirection());
    }

}
