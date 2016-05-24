package Tests;

import PageObjects.CoursePage;
import PageObjects.HomePage;
import PageObjects.PopUp;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NetCourseTest extends BaseTest {

    HomePage homePage;
    CoursePage coursePage;
    PopUp popUp;

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
        assertEquals("Artem is not the coach","Артем Фурсенко",coursePage.CoachName("Артем"));
    }

    @Test
    public void applicationPopUpIsPresent() throws Exception {
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);

        homePage.openCoursesList();
        homePage.openCoursePage(courseName);

        coursePage.clickLeaveApplication();
        coursePage.switchToPopUp(); // focus on pop-up
        assertTrue("Pop up was not shown", coursePage.popUpShown());
    }

    @Test
    public void checkAllFieldsFromPopUp() throws Exception {
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);
        popUp = new PopUp(driver);

        homePage.openCoursesList();
        homePage.openCoursePage(courseName);

        coursePage.clickLeaveApplication();
        coursePage.switchToPopUp(); // focus on pop-up

        assertEquals("Имя is not field name", "Имя", popUp.getFieldName("Имя"));
        assertEquals("Фамилия is not field name", "Фамилия", popUp.getFieldName("Фамилия"));
        assertEquals("Электронная почта is not field name", "Электронная почта", popUp.getFieldName("Электронная почта"));
        assertEquals("Телефон is not field name", "Телефон", popUp.getFieldName("Телефон"));
    }




}
