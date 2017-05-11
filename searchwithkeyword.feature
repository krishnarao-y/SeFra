
Feature: Open google.co.in website, search for any text and capture the no of results

  Scenario: Search for any text and get the results
    Given Open the google india application
    When Enter Selenium in google search text box
    Then Get the results text from the page
    Then Closes the google application
    
  Scenario: show facebook login page and close
    Given Open facebook application
    When verify facebook opened or not
    Then Closes the facebook application  
