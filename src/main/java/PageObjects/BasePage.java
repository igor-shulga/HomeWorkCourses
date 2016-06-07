package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;


public class BasePage {

    private WebDriver driver;
    private By input = By.xpath(".//*[@id='example']/div[4]/div[1]/div[2]/div[2]/div[22]/div/input");
    private By className = By.id("ui left action input");
    private By inputTag = By.tagName("input");



    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        driver.navigate().to("http://semantic-ui.com/elements/input.html");
        Actions reloadPage = new Actions(driver);
        reloadPage.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(input));




       // System.out.println(element.getAttribute("value"));
    }


    /* get value from form

     private By input = By.xpath(".//*[@id='example']/div[4]/div[1]/div[2]/div[2]/div[22]/div/input");

    driver.navigate().to("http://semantic-ui.com/elements/input.html");
        WebElement element = driver.findElement(input);



        System.out.println(element.getAttribute("value"));
     */



}