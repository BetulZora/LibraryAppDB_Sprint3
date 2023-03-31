@us06
Feature: Books module
  As a librarian, I should be able to add new book into library

  @db @ui
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page IB
    And the user navigates  to "Books" page IB
    When the librarian click to add book IB
    And the librarian enter book name "<Book Name>" IB
    When the librarian enter ISBN "<ISBN>" IB
    And the librarian enter year "<Year>" IB
    When the librarian enter author "<Author>" IB
    And the librarian choose the book category "<Book Category>" IB
    And the librarian click to save changes IB
    Then verify "The book has been created" message is displayed IB
    And verify "<Book Name>" information must match with DB IB

    Examples:
      | Book Name             | ISBN     | Year | Author       | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey  | Short Story          |