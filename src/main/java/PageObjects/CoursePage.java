package PageObjects;


import com.sun.jdi.event.WatchpointEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CoursePage {
    private WebDriver driver;
    private By pageHeader = By.className("greenHeader");
    private By coachName = By.className("name");
    private By popUp = By.id("u11508");
    private By applicationButton = By.className("button");
    private By popUpFields = By.className("header");
    private String foundName;

    public CoursePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
    }

    public String CoachName(String name) {
        List<WebElement> allFields = driver.findElements(coachName);
        for(WebElement i : allFields){
            if(i.getText().contains(name)){
                foundName = i.getText();
                break;
            }
        }
        return foundName;
    }

    public String CoachCourse() {
        return driver.findElement(pageHeader).getText();
    }

    public void clickLeaveApplication(){
        driver.findElement(applicationButton).click();
    }

    public void swithToPopUp() throws Exception {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('u11508').focus();");
        }

    public boolean popUpShown(){
        return driver.findElement(popUp).isDisplayed();
    }

    public List<String> getAllFields (){
        List<WebElement> allFields = driver.findElements(popUpFields);
        List<String> fieldNames = new ArrayList<String>();
        for (WebElement i: allFields){
            fieldNames.add (i.getText());
        }
        return fieldNames;
    }

}
