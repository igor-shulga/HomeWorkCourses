package Tests;

import PageObjects.CoursePage;
import PageObjects.HomePage;
import PageObjects.PopUp;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

public class AndroidCourseTest extends BaseTest{
    HomePage homePage;
    CoursePage coursePage;
    PopUp popUp;
    String courseName = "Android";

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
    public void validateCourseNameIsAndroid(){
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);

        homePage.openCoursesList();
        homePage.openCoursePage(courseName);
        assertEquals("Course has wrong name","Diving into Android Development (Погружение в разработку под Android)",coursePage.CoachCourse());
    }

    @Test
    public void validateCoachNameIsDmitry(){
        homePage = new HomePage(driver);
        coursePage = new CoursePage(driver);

        homePage.openCoursesList();
        homePage.openCoursePage(courseName);
        assertEquals("Dmitry is not the coach","Дмитрий Ильченко",coursePage.CoachName("Дмитрий"));
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
