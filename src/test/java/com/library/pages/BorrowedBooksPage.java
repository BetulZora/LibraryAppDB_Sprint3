package com.library.pages;

import com.library.utility.DB_Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

public class BorrowedBooksPage extends BasePage{


    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;

    public int popularityOfBook(){
        //this query finds all returned books
        String queryAllBorrows = "select book_id from book_borrow where is_returned=0";
        DB_Util.runQuery(queryAllBorrows);
        List<String>  allBorrows= DB_Util.getColumnDataAsList("book_id");
        System.out.println("allBorrows = " + allBorrows);
        Map<String, Integer> allBorrowsFrequencyMap=null;
        int frequencyOfEachBorrowed;
        for (String each : allBorrows) {
            frequencyOfEachBorrowed=0;

            for (String bookID : allBorrows) {
                if(bookID == each){
                    frequencyOfEachBorrowed++;
                }
            }
            System.out.println("each="+each + " "+ "frequency="+frequencyOfEachBorrowed);

            allBorrowsFrequencyMap.put(each, (Integer)frequencyOfEachBorrowed );
            System.out.println("allBorrowsFrequencyMap = " + allBorrowsFrequencyMap);
        }

        int bookID=0;
        //this query finds how many times a book with a known ID is borrowed
        //select count(book_id) from book_borrow where book_id=912
        String queryForBorrowCountByBookID = "select count(book_id) from book_borrow where book_id="+bookID;

        //this query finds the book category of a book given its ID
        //select book_category_id from books where id=912
        String queryForBookCategory = "select book_category_id from books where id="+bookID;



        int popularity=0;

        return popularity;
    }
}
