import org.checkerframework.checker.units.qual.C;
import org.example.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class SmokeTests {
    private static Main mainpage;
    private static WebDriver driver;


    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
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
        mainpage.SearchFor("Cierra").DeleteFirstOption();
        assertFalse(mainpage.SearchFor("Cierra").GetFirstOption().contains("Cierra"));
    }

    @Test
    public void TestEmptySearchResult() {
        assertTrue(mainpage.SearchFor("aaaaaa").GotNoData());
    }

    @Test
    public void TestAddNewClient(){
        mainpage.ClickAdd()
                .AddFirstName("Ahmad")
                .AddLastName("Nassar")
                .AddEmail("Ahmad@email.com")
                .AddAge("24")
                .AddSalary("99999")
                .AddDepartment("IT")
                .Submit();

        assertTrue(mainpage.SearchFor("Ahmad").GetFirstOption()
                .contains("Ahmad"));

    }




    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
