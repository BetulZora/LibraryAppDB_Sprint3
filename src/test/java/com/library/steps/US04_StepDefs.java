package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;

import java.util.List;

public class US04_StepDefs {

    BookPage bookPage = new BookPage();
    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {
        bookPage.search.click();
        bookPage.search.sendKeys(bookName);


    }


    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {
        bookPage.editBook("Clean Code").click();
        //BrowserUtil.waitFor(5);


    }
    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
    //TODO: finish this step definition


        DB_Util.createConnection();
        DB_Util.runQuery("select name,isbn,year,author\n" +
                "from books\n" +
                "where name like '%Clean Code%'");
        List<String> actualBookInfo = DB_Util.getRowDataAsList(1);
        System.out.println("actualBookInfo = " + actualBookInfo);


        DB_Util.destroy();
    }


}
