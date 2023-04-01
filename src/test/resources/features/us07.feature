@KRA @ui @db
Feature: Books module
  As a students, I should be able to borrow book

  Scenario: Student borrow new book
    Given the "student" on the home page
    And the user navigates to "Books" page KA
    And the user searches book name called "Head First Java"
    When the user clicks Borrow Book KA
    Then verify that book is shown in "Borrowing Books" page
    And  verify logged student has same book in database