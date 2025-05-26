package Tests;

import org.example.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.*;
import static Tests.TestData.*;


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
    public void TestSearchBoxByFirstName() {
        assertTrue(mainpage.SearchFor(FIRST_NAME_1).GetFirstOption().contains(FIRST_NAME_1));
    }

    @Test
    public void TestSortingByFirstName() {
        assertTrue(mainpage.ClickFirstName().GetFirstOption().contains(FIRST_NAME_2));
    }

    @Test
    public void TestDeleteRow(){
        assertTrue(mainpage.SearchFor(FIRST_NAME_1).DeleteFirstOption().SearchFor(FIRST_NAME_1).GotNoData());
    }

    @Test
    public void TestSearchForEmptyResult() {
        assertTrue(mainpage.SearchFor(FIRST_NAME_4).GotNoData());
    }

    @Test
    public void TestEditFirstName() {
        assertTrue(mainpage.SearchFor(FIRST_NAME_1).EditFirstOption().ChangeFirstName(FIRST_NAME_4)
                .Submit().SearchFor(FIRST_NAME_4).GetFirstOption().contains(FIRST_NAME_4));
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
