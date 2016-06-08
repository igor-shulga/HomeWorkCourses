package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;


public class BasePage {

    private WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String pageUrl) {
        driver.navigate().to(pageUrl);
        }

    public void dropDownWrapper(By locator, String selectElement) {
        WebElement dropDownListBox = driver.findElement(locator);
        Select clickThis = new Select(dropDownListBox);
        clickThis.selectByVisibleText(selectElement);
        // clickThis.selectByIndex(1);

    }


    public void showValueFromInputForm(By locator, String attributeName) {
        WebElement element = driver.findElement(locator);
        System.out.println(element.getAttribute(attributeName));
    }

    public void reloadPage() {
        Actions reloadPage = new Actions(driver);
        reloadPage.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
    }

    public void waitTillElementWillBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    
}
