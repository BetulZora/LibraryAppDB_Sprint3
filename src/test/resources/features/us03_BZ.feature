
Feature: As a data consumer, I want UI and DB book categories are match.
  @ui @db
  Scenario: verify book categories with DB
    Given the "librarian" on the home page BZ
    When the user navigates to "Books" page BZ
    And the user clicks book categories BZ
    Then verify book categories must match book_categories table from db BZ