package Tests;

import PageObjects.CoursePage;
import PageObjects.HomePage;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetCourseTest extends BaseTest {

    HomePage homePage;
    CoursePage coursePage;
    String courseName = ".NET";

    @Test
    public void checkCourseIsPresentAtTheList(){
        homePage = new HomePage(driver);
        homePage.openCoursesList();

        try {
            homePage.openCoursePage(courseName);
        }catch (NoSuchElementException e) {
            System.err.println("There is no such courses" + e.getMessage());}
    }

    @Test
    public void validateCourseNameIsDotNet(){
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);

        homePage.openCoursesList();
        homePage.openCoursePage(courseName);

        assertEquals("Course has wrong name","Diving into .NET Platform (Погружение в .NET)",coursePage.CoachCourse());
    }

    @Test
    public void validateCoachNameIsArtem(){
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);

        homePage.openCoursesList();
        homePage.openCoursePage(courseName);
        assertEquals("Artem is not the coach","Артем Фурсенко",coursePage.CoachName());
    }

    @Test
    public void applicationPopUpIsPresent() throws Exception {
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);

        homePage.openCoursesList();
        homePage.openCoursePage(courseName);

        coursePage.clickLeaveApplication();
        coursePage.swithToPopUp(); // focus on pop-up
        assertTrue("Pop up was not shown", coursePage.popUpShown());
    }

    @Test
    public void checkAllFieldsFromPopUp() throws Exception {
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);

        homePage.openCoursesList();
        homePage.openCoursePage(courseName);

        coursePage.clickLeaveApplication();
        coursePage.swithToPopUp(); // focus on pop-up

        assertEquals("Имя is not field name", "Имя", getFieldName("Имя"));
        assertEquals("Фамилия is not field name", "Фамилия", getFieldName("Фамилия"));
        assertEquals("Электронная почта is not field name", "Электронная почта", getFieldName("Электронная почта"));
        assertEquals("Телефон is not field name", "Телефон", getFieldName("Телефон"));
    }

    public List<String> expectedFields() {
        List<String> expectedNames = new ArrayList<String>();
        expectedNames.add("Имя");
        expectedNames.add("Фамилия");
        expectedNames.add("Электронная почта");
        expectedNames.add("Телефон");

        return expectedNames;
    }

    public String getFieldName(String name) {
        coursePage = new CoursePage(driver);
        Map<String, String> Map = new HashMap<String, String>();
        for (int i = 0; i < 4; i++) {
            Map.put(expectedFields().get(i), coursePage.getAllFields().get(i) );
        }

        for (String key : Map.keySet()) {
            return Map.get(name);
        }

        return Map.get(name);
    }
}
