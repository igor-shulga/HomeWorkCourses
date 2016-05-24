package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopUp {
    private WebDriver driver;
    private By popUpFields = By.className("header");

    public PopUp (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public List<String> expectedFields() {
        List<String> expectedNames = new ArrayList<String>();
        expectedNames.add("Имя");
        expectedNames.add("Фамилия");
        expectedNames.add("Электронная почта");
        expectedNames.add("Телефон");

        return expectedNames;
    }

    public List<String> getAllFields (){
        List<WebElement> allFields = driver.findElements(popUpFields);
        List<String> fieldNames = new ArrayList<String>();
        for (WebElement i: allFields){
            fieldNames.add (i.getText());
        }
        return fieldNames;
    }

    public String getFieldName(String name) {

        Map<String, String> Map = new HashMap<String, String>();
        for (int i = 0; i < 4; i++) {
            Map.put(expectedFields().get(i), getAllFields().get(i) );
        }

        for (String key : Map.keySet()) {
            return Map.get(name);
        }

        return Map.get(name);
    }
}
