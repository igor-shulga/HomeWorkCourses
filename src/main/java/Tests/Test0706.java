package Tests;
import PageObjects.BasePage;
import org.junit.Test;
import org.openqa.selenium.By;
public class Test0706 extends BaseTest {
    BasePage basePage;

    private String pageUrl;
    private By locator;
    private By selectElement;
    private String text;

    @Test
    public void demoQA() {
        pageUrl = "http://demoqa.com/registration/";
        locator = By.id("yy_date_8");
        text = "2014";
        basePage = new BasePage(driver);

        basePage.openPage(pageUrl);
        basePage.dropDownWrapper(locator, text);
    }

    @Test
    public void getValueFromInputForm() {
        pageUrl = "http://semantic-ui.com/elements/input.html"; // base url
        locator = By.xpath(".//*[@id='example']/div[4]/div[1]/div[2]/div[2]/div[22]/div/input"); // locator of input element
        text = "value"; // attribute name, we need to show

        basePage = new BasePage(driver);

        basePage.openPage(pageUrl);
        basePage.showValueFromInputForm(locator, text);

    }

    @Test
    public void reloadPageAndWaitTillElementBecameVisible() {
        pageUrl = "http://semantic-ui.com/elements/input.html";// base url
        locator = By.xpath(".//*[@id='example']/div[4]/div[1]/div[2]/div[2]/div[22]/div/input"); // locator of input element

        basePage = new BasePage(driver);

        basePage.openPage(pageUrl);
        basePage.reloadPage();
        basePage.waitTillElementWillBeVisible(locator);
    }


    @Test //not fixed yet "ElementNotVisibleException"
    public void selectFromDropDownValueMale() {
        pageUrl = "http://semantic-ui.com/modules/dropdown"; // base url
        locator = By.xpath(".//*[@id='example']/div[4]/div[1]/div[2]/div[2]/div[1]/div[4]/div/select");
        text = "Male"; // value we need to select at DropDown

        basePage = new BasePage(driver);

        basePage.openPage(pageUrl);
        basePage.dropDownWrapper(locator, text);
    }
}