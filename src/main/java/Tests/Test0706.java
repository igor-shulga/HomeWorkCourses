package Tests;
import PageObjects.BasePage;
import org.junit.Test;
import org.openqa.selenium.By;
public class Test0706 extends BaseTest {
    BasePage basePage;
    @Test
    public void testStudy(){
        basePage = new BasePage(driver);
        basePage.openPage();
    }
}