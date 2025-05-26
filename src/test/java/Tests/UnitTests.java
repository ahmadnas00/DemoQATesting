package Tests;

import org.example.Main;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;
import static Tests.TestData.*;


public class UnitTests {
    private static Main mainpage;
    private static WebDriver driver;


    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // run without GUI
        options.addArguments("--disable-gpu"); // optional but recommended
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(Main.mainURL);
        mainpage = new Main(driver);
    }


    @Test
    public void TestSearchBoxFirstFullName() {
        assertTrue(mainpage.SearchFor(FIRST_NAME_1).GetFirstOption().contains(FIRST_NAME_1));
        assertTrue(mainpage.SearchFor(FIRST_NAME_2).GetFirstOption().contains(FIRST_NAME_2));
        assertTrue(mainpage.SearchFor(FIRST_NAME_3).GetFirstOption().contains(FIRST_NAME_3));
    }

    @Test
    public void TestSearchBoxFirstNameSmall() {
        assertTrue(mainpage.SearchFor("cierra").GetFirstOption().contains(FIRST_NAME_1));
        assertTrue(mainpage.SearchFor("alden").GetFirstOption().contains(FIRST_NAME_2));
        assertTrue(mainpage.SearchFor("kierra").GetFirstOption().contains(FIRST_NAME_3));
    }

    @Test
    public void TestSearchBoxFirstNameCapital() {
        assertTrue(mainpage.SearchFor("CIERRA").GetFirstOption().contains(FIRST_NAME_1));
        assertTrue(mainpage.SearchFor("ALDEN").GetFirstOption().contains(FIRST_NAME_2));
        assertTrue(mainpage.SearchFor("KIERRA").GetFirstOption().contains(FIRST_NAME_3));
    }

    @Test
    public void TestSearchBoxFirstNameShort() {
        assertTrue(mainpage.SearchFor("Cierr").GetFirstOption().contains(FIRST_NAME_1));
        assertTrue(mainpage.SearchFor("Cier").GetFirstOption().contains(FIRST_NAME_1));
        assertTrue(mainpage.SearchFor("Cie").GetFirstOption().contains(FIRST_NAME_1));
        assertTrue(mainpage.SearchFor("Ci").GetFirstOption().contains(FIRST_NAME_1));
    }

    @Test
    public void TestSearchBoxAge() {
        assertTrue(mainpage.SearchFor("39").GetFirstOption().contains(AGE_1));
        assertTrue(mainpage.SearchFor("3").GetFirstOption().contains(AGE_1));
        assertTrue(mainpage.SearchFor("45").GetFirstOption().contains(AGE_2));
        assertTrue(mainpage.SearchFor("4").GetFirstOption().contains(AGE_2));
        assertTrue(mainpage.SearchFor("29").GetFirstOption().contains(AGE_3));
    }

    @Test
    public void TestSearchBoxSalary() {
        assertTrue(mainpage.SearchFor(SALARY_1).GetFirstOption().contains(SALARY_1));
        assertTrue(mainpage.SearchFor("10").GetFirstOption().contains(SALARY_1));
        assertTrue(mainpage.SearchFor(SALARY_2).GetFirstOption().contains(SALARY_2));
    }

    @Test
    public void TestSearchBoxDepartment() {
        assertTrue(mainpage.SearchFor(DEPARTMENT_1).GetFirstOption().contains(DEPARTMENT_1));
        assertTrue(mainpage.SearchFor(DEPARTMENT_2).GetFirstOption().contains(DEPARTMENT_2));
        assertTrue(mainpage.SearchFor(DEPARTMENT_3).GetFirstOption().contains(DEPARTMENT_3));
    }

    @Test
    public void TestSortingByFirstNameUP() {
        assertTrue(mainpage.ClickFirstName().GetFirstOption().contains(FIRST_NAME_2));
    }

    @Test
    public void TestSortingByFirstNameDown() {
        assertTrue(mainpage.ClickFirstName().ClickFirstName().GetFirstOption().contains(FIRST_NAME_3));
    }

    @Test
    public void TestSortingByLastnameUP() {
        assertTrue(mainpage.ClickLastName().GetFirstOption().contains(LAST_NAME_2));
    }

    @Test
    public void TestSortingByLastnameDown() {
        assertTrue(mainpage.ClickLastName().ClickLastName().GetFirstOption().contains(LAST_NAME_1));
    }

    @Test
    public void TestSortingByAgeUP() {
        assertTrue(mainpage.ClickAge().GetFirstOption().contains(AGE_3));
    }

    @Test
    public void TestSortingByAgeDown() {
        assertTrue(mainpage.ClickAge().ClickAge().GetFirstOption().contains(AGE_2));
    }

    @Test
    public void TestSortingByEmailUP() {
        assertTrue(mainpage.ClickEmail().GetFirstOption().contains(EMAIL_2));
    }

    @Test
    public void TestSortingByEmailDown() {
        assertTrue(mainpage.ClickEmail().ClickEmail().GetFirstOption().contains(EMAIL_3));
    }

    @Test
    public void TestSortingBySalaryUP() {
        assertTrue(mainpage.ClickSalary().GetFirstOption().contains(SALARY_3));
    }

    @Test
    public void TestSortingBySalaryDown() {
        assertTrue(mainpage.ClickSalary().ClickSalary().GetFirstOption().contains(SALARY_2));
    }

    @Test
    public void TestSortingByDepartmentUp() {
        assertTrue(mainpage.ClickDepartment().GetFirstOption().contains(DEPARTMENT_2));
    }

    @Test
    public void TestSortingByDepartmentDown() {
        assertTrue(mainpage.ClickDepartment().ClickDepartment().GetFirstOption().contains(DEPARTMENT_3));
    }


    @Test
    public void TestEditLastName() {
        assertTrue(mainpage.SearchFor(LAST_NAME_1).EditFirstOption().ChangeLastName(LAST_NAME_4)
                .Submit().SearchFor(LAST_NAME_4).GetFirstOption().contains(LAST_NAME_4));
    }

    @Test
    public void TestEditAge() {
        assertTrue(mainpage.SearchFor(AGE_1).EditFirstOption().ChangeAge(AGE_4)
                .Submit().SearchFor(AGE_4).GetFirstOption().contains(AGE_4));
    }

    @Test
    public void TestEditEmail() {
        assertTrue(mainpage.SearchFor(LAST_NAME_1).EditFirstOption().ChangeEmail(EMAIL_4)
                .Submit().SearchFor(EMAIL_4).GetFirstOption().contains(EMAIL_4));
    }

    @Test
    public void TestEditSalaray() {
        assertTrue(mainpage.SearchFor(SALARY_1).EditFirstOption().ChangeSalary(SALARY_4)
                .Submit().SearchFor(SALARY_4).GetFirstOption().contains(SALARY_4));
    }

    @Test
    public void TestEditDepartment() {
        assertTrue(mainpage.SearchFor(DEPARTMENT_1).EditFirstOption().ChangeDepartment(DEPARTMENT_4)
                .Submit().SearchFor(DEPARTMENT_4).GetFirstOption().contains(DEPARTMENT_4));
    }

    @Test
    public void TestAddNewClient() {
        assertTrue(mainpage.ClickAdd()
                .AddFirstName(FIRST_NAME_5)
                .AddLastName(LAST_NAME_5)
                .AddEmail(EMAIL_5)
                .AddAge(AGE_5)
                .AddSalary(SALARY_5)
                .AddDepartment(DEPARTMENT_5)
                .Submit().SearchFor(FIRST_NAME_5).GetFirstOption().contains(FIRST_NAME_5));
    }




    @Test
    public void TestSameEmailDifferentUsers() {
        assertTrue(mainpage.ClickAdd()
                .AddFirstName(FIRST_NAME_5)
                .AddLastName(LAST_NAME_5)
                .AddEmail(EMAIL_2)  // This email has already been used !
                .AddAge(AGE_5)
                .AddSalary(SALARY_5)
                .AddDepartment(DEPARTMENT_5)
                .Submit().SearchFor(FIRST_NAME_5).GetFirstOption().contains(FIRST_NAME_5));

    }





    @Test
    public void EnterThreeDigitsAge() {
        assertFalse(mainpage.ClickAdd()
                .AddFirstName(FIRST_NAME_5)
                .AddLastName(LAST_NAME_5)
                .AddEmail(EMAIL_5)
                .AddAge(AGE_6)
                .AddSalary(SALARY_5)
                .AddDepartment(DEPARTMENT_5)
                .Submit().SearchFor(FIRST_NAME_5).GetFirstOption().contains(AGE_6));
    }



    @Test
    public void EnterEmptyInputs() {
        assertTrue(mainpage.ClickAdd()
                .AddFirstName("")
                .AddLastName("")
                .AddEmail("")
                .AddAge("")
                .AddSalary("")
                .AddDepartment("")
                .Submit().isAddWindowOpen());
    }



    @Test
    public void EnterStringAge() {
        assertTrue(mainpage.ClickAdd()
                .AddFirstName(FIRST_NAME_5)
                .AddLastName(LAST_NAME_5)
                .AddEmail(EMAIL_5)
                .AddAge(AGE_7)
                .AddSalary(SALARY_5)
                .AddDepartment(DEPARTMENT_5)
                .Submit().isAddWindowOpen());
    }



    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
