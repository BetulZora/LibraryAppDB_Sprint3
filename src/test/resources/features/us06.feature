@us06
Feature: Books module
  As a librarian, I should be able to add new book into library

  @ui@db
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page
    And the user navigates to "Books" page
    When the librarian click to add book_IN
    And the librarian enter book name "<Book Name>"_IN
    When the librarian enter ISBN "<ISBN>"_IN
    And the librarian enter year "<Year>"_IN
    When the librarian enter author "<Author>"_IN
    And the librarian choose the book category "<Book Category>"_IN
    And the librarian click to save changes_IN
    Then verify "The book has been created" message is displayed_IN
    And verify "<Book Name>" information must match with DB_IN
    Examples:
      | Book Name             | ISBN     | Year | Author       | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey  | Short Story          |