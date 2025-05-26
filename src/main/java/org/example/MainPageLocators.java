package org.example;
import org.openqa.selenium.By;


public class MainPageLocators {
    public static final String mainURL = "https://demoqa.com/webtables";
    public static final By SearchBox = By.id("searchBox");
    public static final By firstRow = By.cssSelector(".rt-tbody .rt-tr");
    public static final By FirstRowCells = By.cssSelector(".rt-td");
    public static final By FirstNameHeader = By.xpath("//div[text()='First Name']");
    public static final By LastNameHeader = By.xpath("//div[text()='Last Name']");
    public static final By AgeHeader = By.xpath("//div[text()='Age']");
    public static final By EmailHeader = By.xpath("//div[text()='Email']");
    public static final By Salary = By.xpath("//div[text()='Salary']");
    public static final By Department = By.xpath("//div[text()='Department']");
    public static final By DeleteButton = By.id("delete-record-1");
    public static final By EditButton = By.id("edit-record-1");
    public static final By ChangeFirstNameBar = By.id("firstName");
    public static final By ChangeLastNameBar = By.id("lastName");
    public static final By ChangeAge = By.id("age");
    public static final By ChangeEmail = By.id("userEmail");
    public static final By ChangeSalary = By.id("salary");
    public static final By ChangeDep = By.id("department");
    public static final By AddButton = By.id("addNewRecordButton");
    public static final By SubmitIcon = By.id("submit");
    public static final By NoData = By.className("rt-noData");
}
