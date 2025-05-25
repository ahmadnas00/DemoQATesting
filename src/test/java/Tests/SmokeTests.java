

import org.checkerframework.checker.units.qual.C;
import org.example.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;


public class SmokeTests {
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
    }

    @Test
    public void TestSortingByFirstNameUP() {
        assertTrue(mainpage.ClickFirstName().GetFirstOption().contains("Alden"));
    }

    @Test
    public void TestDeleteRow(){
        assertTrue(mainpage.SearchFor("Cierra").DeleteFirstOption().SearchFor("Cierra").GotNoData());
    }

    @Test
    public void TestEmptySearchResult() {
        assertTrue(mainpage.SearchFor("aaaaaa").GotNoData());
    }

    @Test
    public void TestAddNewClient() {
        assertTrue(mainpage.ClickAdd()
                .AddFirstName("Ahmad")
                .AddLastName("Nassar")
                .AddEmail("Ahmad@email.com")
                .AddAge("24")
                .AddSalary("99999")
                .AddDepartment("Engineering")
                .Submit().SearchFor("Ahmad").GetFirstOption().contains("Ahmad"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
