import org.example.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


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
        assertTrue(mainpage.SearchFor("Cierra").GetFirstOption().contains("Cierra"));
        assertTrue(mainpage.SearchFor("Alden").GetFirstOption().contains("Alden"));
        assertTrue(mainpage.SearchFor("Kierra").GetFirstOption().contains("Kierra"));
    }

    @Test
    public void TestSearchBoxFirstNameSmall() {
        assertTrue(mainpage.SearchFor("cierra").GetFirstOption().contains("Cierra"));
        assertTrue(mainpage.SearchFor("alden").GetFirstOption().contains("Alden"));
        assertTrue(mainpage.SearchFor("kierra").GetFirstOption().contains("Kierra"));
    }

    @Test
    public void TestSearchBoxFirstNameCapital() {
        assertTrue(mainpage.SearchFor("CIERRA").GetFirstOption().contains("Cierra"));
        assertTrue(mainpage.SearchFor("ALDEN").GetFirstOption().contains("Alden"));
        assertTrue(mainpage.SearchFor("KIERRA").GetFirstOption().contains("Kierra"));
    }

    @Test
    public void TestSearchBoxFirstNameShort() {
        assertTrue(mainpage.SearchFor("Cierr").GetFirstOption().contains("Cierra"));
        assertTrue(mainpage.SearchFor("Cier").GetFirstOption().contains("Cierra"));
        assertTrue(mainpage.SearchFor("Cie").GetFirstOption().contains("Cierra"));
        assertTrue(mainpage.SearchFor("Ci").GetFirstOption().contains("Cierra"));
    }

    @Test
    public void TestSearchBoxAge() {
        assertTrue(mainpage.SearchFor("39").GetFirstOption().contains("39"));
        assertTrue(mainpage.SearchFor("3").GetFirstOption().contains("39"));
        assertTrue(mainpage.SearchFor("45").GetFirstOption().contains("45"));
        assertTrue(mainpage.SearchFor("4").GetFirstOption().contains("45"));
        assertTrue(mainpage.SearchFor("29").GetFirstOption().contains("29"));
    }

    @Test
    public void TestSearchBoxSalary() {
        assertTrue(mainpage.SearchFor("10000").GetFirstOption().contains("10000"));
        assertTrue(mainpage.SearchFor("10").GetFirstOption().contains("10000"));
        assertTrue(mainpage.SearchFor("12000").GetFirstOption().contains("12000"));
    }

    @Test
    public void TestSearchBoxDepartment() {
        assertTrue(mainpage.SearchFor("Insurance").GetFirstOption().contains("Insurance"));
        assertTrue(mainpage.SearchFor("Compliance").GetFirstOption().contains("Compliance"));
        assertTrue(mainpage.SearchFor("Legal").GetFirstOption().contains("Legal"));
    }

    @Test
    public void TestSortingByFirstNameUP() {
        assertTrue(mainpage.ClickFirstName().GetFirstOption().contains("Alden"));
    }

    @Test
    public void TestSortingByFirstNameDown() {
        assertTrue(mainpage.ClickFirstName().ClickFirstName().GetFirstOption().contains("Kierra"));
    }

    @Test
    public void TestSortingByLastnameUP() {
        assertTrue(mainpage.ClickLastName().GetFirstOption().contains("Cantrell"));
    }

    @Test
    public void TestSortingByLastnameDown() {
        assertTrue(mainpage.ClickLastName().ClickLastName().GetFirstOption().contains("Vega"));
    }

    @Test
    public void TestSortingByAgeUP() {
        assertTrue(mainpage.ClickAge().GetFirstOption().contains("29"));
    }

    @Test
    public void TestSortingByAgeDown() {
        assertTrue(mainpage.ClickAge().ClickAge().GetFirstOption().contains("45"));
    }

    @Test
    public void TestSortingByEmailUP() {
        assertTrue(mainpage.ClickEmail().GetFirstOption().contains("alden@example.com"));
    }

    @Test
    public void TestSortingByEmailDown() {
        assertTrue(mainpage.ClickEmail().ClickEmail().GetFirstOption().contains("kierra@example.com"));
    }

    @Test
    public void TestSortingBySalaryUP() {
        assertTrue(mainpage.ClickSalary().GetFirstOption().contains("2000"));
    }

    @Test
    public void TestSortingBySalaryDown() {
        assertTrue(mainpage.ClickSalary().ClickSalary().GetFirstOption().contains("12000"));
    }

    @Test
    public void TestSortingByDepartmentUp() {
        assertTrue(mainpage.ClickDepartment().GetFirstOption().contains("Compliance"));
    }

    @Test
    public void TestSortingByDepartmentDown() {
        assertTrue(mainpage.ClickDepartment().ClickDepartment().GetFirstOption().contains("Legal"));
    }

    @Test
    public void TestDeleteRow(){
        mainpage.SearchFor("Cierra").DeleteFirstOption();
        assertFalse(mainpage.SearchFor("Cierra").GetFirstOption().contains("Cierra"));
    }

    @Test
    public void TestEditFirstName(){
        mainpage.SearchFor("Cierra").EditFirstOption().ChangeFirstName("Mike").Submit();
        assertTrue(mainpage.SearchFor("Mike").GetFirstOption().contains("Mike"));
    }

    @Test
    public void TestEditLastName(){
        mainpage.SearchFor("Vega").EditFirstOption().ChangeLastName("Stark").Submit();
        assertTrue(mainpage.SearchFor("Stark").GetFirstOption().contains("Stark"));
    }

    @Test
    public void TestEditAge(){
        mainpage.SearchFor("39").EditFirstOption().ChangeAge("40").Submit();
        assertTrue(mainpage.SearchFor("40").GetFirstOption().contains("40"));
    }

    @Test
    public void TestEditEmail(){
        mainpage.SearchFor("Vega").EditFirstOption().ChangeEmail("NewVega@example.com").Submit();
        assertTrue(mainpage.SearchFor("NewVega@example.com").GetFirstOption().contains("NewVega@example.com"));
    }

    @Test
    public void TestEditSalaray(){
        mainpage.SearchFor("10000").EditFirstOption().ChangeSalary("99").Submit();
        assertTrue(mainpage.SearchFor("99").GetFirstOption().contains("99"));
    }

    @Test
    public void TestEditDepartment(){
        mainpage.SearchFor("Insurance").EditFirstOption().ChangeDepartment("IT").Submit();
        assertTrue(mainpage.SearchFor("IT").GetFirstOption().contains("IT"));
    }

    @Test
    public void TestAddNewClient(){
        mainpage.ClickAdd()
                .AddFirstName("Ahmad")
                .AddLastName("Nassar")
                .AddEmail("Ahmad@email.com")
                .AddAge("24")
                .AddSalary("99999")
                .AddDepartment("Engineering")
                .Submit();

        assertTrue(mainpage.SearchFor("Ahmad").GetFirstOption().contains("Ahmad"));

    }




    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
