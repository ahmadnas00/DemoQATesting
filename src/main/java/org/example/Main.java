package org.example;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import static org.example.MainPageLocators.*;



public class Main {
    public static String mainURL = MainPageLocators.mainURL;
    private static WebDriver driver;


    public Main(WebDriver driver) {
        this.driver = driver;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleContains("DEMOQA"));
        } catch (TimeoutException e) {
            throw new IllegalStateException("Timeout waiting for page title to contain 'DEMOQA'. Current title: " + driver.getTitle());
        }
    }

    public Main SearchFor(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(MainPageLocators.SearchBox));
        WebElement searchField = driver.findElement(SearchBox);
        searchField.clear();
        searchField.sendKeys(name);
        searchField.sendKeys(Keys.RETURN);
        return this;
    }


    public List<String> GetFirstOption() {
        try {
            Thread.sleep(100); // Wait for 0.5 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement firstRowLine = wait.until(ExpectedConditions.presenceOfElementLocated(firstRow));
        List<WebElement> cells = firstRowLine.findElements(FirstRowCells);
        List<String> cellTexts = new ArrayList<>();
        for (WebElement cell : cells) {
            cellTexts.add(cell.getText());
        }
        return cellTexts;
    }


    public Main ClickFirstName() {
        WebElement FirstHeader = driver.findElement(FirstNameHeader);
        FirstHeader.click();
        return this;
    }


    public Main ClickLastName() {
        WebElement LastHeader = driver.findElement(LastNameHeader);
        LastHeader.click();
        return this;
    }

    public Main ClickAge() {
        WebElement AgeHeaderoloumn = driver.findElement(AgeHeader);
        AgeHeaderoloumn.click();
        return this;
    }

    public Main ClickEmail() {
        WebElement EmailHeaderColoumn = driver.findElement(EmailHeader);
        EmailHeaderColoumn.click();
        return this;
    }

    public Main ClickSalary() {
        WebElement SalaryColoumn = driver.findElement(Salary);
        SalaryColoumn.click();
        return this;
    }

    public Main ClickDepartment() {
        WebElement DepartmentColoumn = driver.findElement(Department);
        DepartmentColoumn.click();
        return this;
    }

    public Main DeleteFirstOption() {
        WebElement DeleteIcon = driver.findElement(DeleteButton);
        DeleteIcon.click();
        return this;

    }

    public Main EditFirstOption() {
        WebElement EditIcon = driver.findElement(EditButton);
        EditIcon.click();
        return this;
    }

    public Main ChangeFirstName(String name) {
        WebElement ChangeableFirst = driver.findElement(ChangeFirstNameBar);
        ChangeableFirst.clear();
        ChangeableFirst.sendKeys(name);
        return this;
    }

    public Main Submit() {
        WebElement SubmitButton = driver.findElement(SubmitIcon);
        SubmitButton.click();
        return this;
    }

    public Main ChangeLastName(String newlastname) {
        WebElement ChangeableLast = driver.findElement(ChangeLastNameBar);
        ChangeableLast.clear();
        ChangeableLast.sendKeys(newlastname);
        return this;
    }

    public Main ChangeAge(String newagenumber) {
        WebElement ChangeableAge = driver.findElement(ChangeAge);
        ChangeableAge.clear();
        ChangeableAge.sendKeys(newagenumber);
        return this;
    }

    public Main ChangeEmail(String mail) {
        WebElement ChangeAbleEmail = driver.findElement(ChangeEmail);
        ChangeAbleEmail.clear();
        ChangeAbleEmail.sendKeys(mail);
        return this;
    }

    public Main ClickAdd() {
        WebElement AddIcon = driver.findElement(AddButton);
        AddIcon.click();
        return this;
    }

    public Main AddFirstName(String FirstName) {
        WebElement FirstNameOption = driver.findElement(ChangeFirstNameBar);
        FirstNameOption.sendKeys(FirstName);
        return this;
    }

    public Main AddLastName(String LastName) {
        WebElement LastNameOption = driver.findElement(ChangeLastNameBar);
        LastNameOption.sendKeys(LastName);
        return this;
    }

    public Main AddEmail(String mail) {
        WebElement ChangeAbleEmail = driver.findElement(ChangeEmail);
        ChangeAbleEmail.sendKeys(mail);
        return this;
    }

    public Main AddAge(String Age) {
        WebElement ChangeableAge = driver.findElement(ChangeAge);
        ChangeableAge.sendKeys(Age);
        return this;
    }

    public Main AddSalary(String Salary) {
        WebElement ChangableSalary = driver.findElement(ChangeSalary);
        ChangableSalary.sendKeys(Salary);
        return this;
    }

    public Main AddDepartment(String Dep) {
        WebElement ChangableDep = driver.findElement(ChangeDep);
        ChangableDep.sendKeys(Dep);
        return this;
    }

    public Main ChangeSalary(String NewSalary) {
        WebElement ChangableSalary = driver.findElement(ChangeSalary);
        ChangableSalary.clear();
        ChangableSalary.sendKeys(NewSalary);
        return this;

    }

    public Main ChangeDepartment(String NewDep) {
        WebElement ChangableDep = driver.findElement(ChangeDep);
        ChangableDep.clear();
        ChangableDep.sendKeys(NewDep);
        return this;
    }

    public boolean GotNoData() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement Element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(NoData)
            );
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isAddWindowOpen() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            return !wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("registration-form-modal")));
        } catch (TimeoutException e) {
            return true; // Still visible → modal still open
        }
    }


}