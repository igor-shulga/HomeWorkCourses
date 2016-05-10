package Tests;

import PageObjects.CoursePage;
import PageObjects.HomePage;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

public class AndroidCourseTest extends BaseTest{
    HomePage homePage;
    CoursePage coursePage;
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
        assertEquals("Dmitry is not the coach","Дмитрий Ильченко",coursePage.CoachName());
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

        assertEquals("Имя is not field name", "Имя", coursePage.getFieldName(0));
        assertEquals("Фамилия is not field name", "Фамилия", coursePage.getFieldName(1));
        assertEquals("Электронная почта is not field name", "Электронная почта", coursePage.getFieldName(2));
        assertEquals("Телефон is not field name", "Телефон", coursePage.getFieldName(3));
    }
}
