package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US04_VN_StepDefs {

    BookPage bookPage;

    @Given("the user navigates to {string} page VN")
    public void the_user_navigates_to_page_vn(String moduleName) {
        bookPage = new BookPage();
        bookPage.navigateModule(moduleName);
        BrowserUtil.waitFor(1);
    }

    String bookName;
    @When("the user searches for {string} book VN")
    public void the_user_searches_for_book_vn(String name) {
        bookName = name;
        bookPage = new BookPage();
        bookPage.search.sendKeys(bookName);
    }

    @When("the user clicks edit book button VN")
    public void the_user_clicks_edit_book_button_vn() {
        bookPage = new BookPage();
        BrowserUtil.waitForClickablility(bookPage.editBook(bookName), 3).click();
        BrowserUtil.waitFor(2);
    }

    @Then("book information must match the Database VN")
    public void book_information_must_match_the_database_vn() {
        bookPage = new BookPage();
        String bookNameUI = bookPage.bookName.getAttribute("value");
        String authorNameUI = bookPage.author.getAttribute("value");
        String isbnUI = bookPage.isbn.getAttribute("value");
        String year = bookPage.year.getAttribute("value");

        Select select = new Select(bookPage.categoryDropdown);
        String categoryUI = select.getFirstSelectedOption().getText();

        List<String> bookInfoUI = new ArrayList<>(Arrays.asList(bookNameUI, authorNameUI, isbnUI, year, categoryUI));

        // DB
        String query = "select b.name, author, isbn, year, bc.name from books b join book_categories bc on b.book_category_id = bc.id\n" +
                "where b.name = '" + bookName + "'\n" +
                "order by isbn desc";
        DB_Util.runQuery(query);

        List<String> bookInfoDB = DB_Util.getRowDataAsList(1);
        System.out.println("bookInfoDB = " + bookInfoDB);

        Assert.assertEquals(bookInfoDB, bookInfoUI);

    }

}
