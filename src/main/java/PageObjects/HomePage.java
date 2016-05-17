package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private String homeUrl = "http://skillsup.ua/";
    private By training = By.xpath(".//*[@id='menu1078']/a");
    private By courses = By.xpath(".//*[@id='menu1078']/ul/li[1]");
    private By coursesList = By.xpath(".//*[@id='subMenuSubNodes1189']/li[position()>0]/a");



    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCoursesList() {
        driver.navigate().to(homeUrl);
        WebElement hoverOnTraining = driver.findElement(training);
        WebElement hoverOnCourses = driver.findElement(courses);
        Actions openCoursesList = new Actions(driver);
        openCoursesList.moveToElement(hoverOnTraining).perform();
        openCoursesList.moveToElement(hoverOnCourses).perform();
    }



    public void openCoursePage(String courseName) {
        List<WebElement> element = driver.findElements(coursesList);

        for (WebElement i: element){

            if(i.getAttribute("text").contains(courseName)){
                i.click();
                break;
            }
        }

    }
}






