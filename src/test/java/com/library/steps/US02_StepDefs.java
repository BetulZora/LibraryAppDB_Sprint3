package com.library.steps;

import com.library.pages.BorrowedBooksPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_StepDefs {
    LoginPage loginPage = new LoginPage();
    BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();

    DashBoardPage dashBoardPage = new DashBoardPage();


    @Given("the {string} on the home page")
    public void the_on_the_home_page(String librarian) {
        loginPage.login(librarian);

    }

    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
        //int actualBorrowedBooksNumber = Integer.parseInt(borrowedBooksPage.borrowedBooksNumber.getText());
        String actualBorrowedBooksNumber = dashBoardPage.getModuleCount("Borrowed Books");
        BrowserUtil.waitFor(2);
        System.out.println("actualBorrowedBooksNumber = " + actualBorrowedBooksNumber);

    }

    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
                //int actualBorrowedBooksNumber = Integer.parseInt(borrowedBooksPage.borrowedBooksNumber.getText());
        String actualBorrowedBooksNumber = dashBoardPage.getModuleCount("Borrowed Books");
        DB_Util.createConnection();
        DB_Util.runQuery("select count(*) from book_borrow\n" +
                "where is_returned=0");
        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBorrowedBooksNumber = " + expectedBorrowedBooksNumber);
        Assert.assertEquals(expectedBorrowedBooksNumber, actualBorrowedBooksNumber);
        DB_Util.destroy();
    }
}
