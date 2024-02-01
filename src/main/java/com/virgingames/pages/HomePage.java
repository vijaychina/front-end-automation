package com.virgingames.pages;

import com.virgingames.propertyreader.PropertyReader;
import com.virgingames.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @CacheLookup
    @FindBy(xpath = "//div[@class='StyledNavigationMenuWrapper-sc-v46bks-0 jLmDjy']/ul/li")
    List<WebElement> topMenu;

    @CacheLookup
    @FindBy(linkText = "All Games")
    WebElement allGames;

    @CacheLookup
    @FindBy(xpath = "//h2[1]")
    WebElement onlineSlotsText;

    @CacheLookup
    @FindBy(xpath = "(//label[@class='dialog_button'])[2]")
    WebElement acceptAllCookies;

    public void getCurrentUrl(){
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = PropertyReader.getInstance().getProperty("baseUrl");
        Assert.assertEquals(actualUrl, expectedUrl);
        log.info("Verifying Homepage Url");
    }
    public void selectMenu(String menuItem){
        List<WebElement> list = topMenu;
        for(WebElement name : list){
            if(name.getText().trim().equalsIgnoreCase(menuItem)){
                mouseHoverToElement(name);
                log.info("Hover mouse to menu bar.");
                break;
            }
        }
    }

    public void clickOnAcceptAllCookies() {
        clickOnElement(acceptAllCookies);
        log.info("Accepting cookies " + acceptAllCookies.toString());
    }
    public void clickOnAllGames (){
        clickOnElement(allGames);
        log.info("Clicking on All Games : " + allGames.toString());
    }

    public String getOnlineSlotsText() {
        log.info("Getting Online Slots text : " + onlineSlotsText.toString());
        return getTextFromElement(onlineSlotsText);
    }

}