package com.library.steps;

import com.library.pages.BorrowedBooksPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US05_BZ_StepDefs {
    BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();

    @Given("Establish the database connection BZ")
    public void establish_the_database_connection_bz() {
        // this step is completed in the Hooks

    }
    @When("I execute query to find most popular book genre BZ")
    public void i_execute_query_to_find_most_popular_book_genre_bz() {
        borrowedBooksPage.popularityOfBook();



    }
    @Then("verify {string} is the most popular book genre. BZ")
    public void verify_is_the_most_popular_book_genre_bz(String string) {

    }

}
