@wip
Feature: As a data consumer, I want UI and DB book information are match.
@ui  @db
  Scenario: Verify book information with DB
    Given the "librarian" on the home page MG
    And the user navigates to "Books" page MG
    When the user searches for "Clean Code" book MG
    And  the user clicks edit book button MG
    Then book information must match the Database MG