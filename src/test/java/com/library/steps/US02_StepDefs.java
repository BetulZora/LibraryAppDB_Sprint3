package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class US02_StepDefs {
    LoginPage loginPage;
    DashBoardPage dashBoardPage;
    String actualBorrowedBookNr;
    @Given("the {string} on the home page DB")
    public void the_on_the_home_page_db(String user) {
        loginPage = new LoginPage();
        loginPage.login(user);
        BrowserUtil.waitFor(2);
    }
    @When("the librarian gets borrowed books number DB")
    public void the_librarian_gets_borrowed_books_number_db() {
        dashBoardPage = new DashBoardPage();

        actualBorrowedBookNr = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBookNr = " + actualBorrowedBookNr);
    }
    @Then("borrowed books number information must match with DB DB")
    public void borrowed_books_number_information_must_match_with_db_db() {

        String query = "select count(*) from book_borrow where is_returned=0";

        DB_Util.runQuery(query);

        String expectedBorrowedBookNr = DB_Util.getCellValue(1, 1);

        Assert.assertEquals(expectedBorrowedBookNr,actualBorrowedBookNr);
    }



}
