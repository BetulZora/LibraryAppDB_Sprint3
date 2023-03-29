@US02
Feature: As a librarian, I want to know borrowed books number
  @ui @db
  Scenario: verify the total amount of borrowed books
    Given the "librarian" on the home page DB
    When the librarian gets borrowed books number DB
    Then borrowed books number information must match with DB DB
