package com.inova.pageObjects;

import com.inova.config.Configuration;
import com.inova.config.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConsultingPage extends Page{

    @FindBy(linkText = "Intégration de logiciel")
    private WebElement softwareIntegration;

    @FindBy(xpath = "//body/main[@id='main']/section[@id='tools']/div[1]/div[2]/div[2]/div[1]/a[1]")
    private WebElement orderButton;

    private final static Configuration PROP  = Properties.Config;

    private final static String softwareIntegrationURI  = PROP.getEnvironment()+"consulting.php#";

    private final static String orderURI = PROP.getEnvironment()+"consulting.php#contact";

    public ConsultingPage() {

    }

    public void goToCommandSection(){
        scroll(orderButton.getSize().getHeight());
    }

    public void clickOnSoftwareIntegration(){
        softwareIntegration.sendKeys(Keys.ENTER);
    }

    public void clickOnOrderButton(){
        js.executeScript("arguments[0].click()",orderButton);
    }

    public boolean isFakeRedirection(){
        return softwareIntegration.getAttribute("href")
                                  .equals(softwareIntegrationURI);
    }

    public boolean isOrderRedirection(){
        return orderButton.getAttribute("href")
                          .equals(orderURI);
    }

    public boolean verifyLinkRedirection(){
        return !isFakeRedirection();
    }

    public boolean verifyOrderRedirection(){
        return !isOrderRedirection();
    }

}