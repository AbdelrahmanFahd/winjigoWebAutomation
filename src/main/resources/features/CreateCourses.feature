Feature: Create Courses

  Background:
    Given User Navigate to "https://swinji.azurewebsites.net"

  Scenario: create Courses
    Given User Enter "testregister@aaa.com" and "Wakram_123"
    And Go to Courses Page
    When User Click on Add Course Button And Enter "Flutter" as the name, "5" Grade and "nada rehan" as a Teacher of the course
    Then Course Title should be displayed in courses List
