Feature: We want to be able to collect customer's email and or phone for communicating specials etc

  Scenario: Add a customer cell phone
    Given "Jamil" is not a Morning Freshness member
    And he enrolls as a member
    And he provides his cell phone number "555-555-5555"
    Then he should earn 10 points
    And a welcome text is sent to him

  Scenario: Add a customer email address
    Given "Eva" is not a Morning Freshness member
    And she enrolls as a member
    And she provides her email "customerEva@supersmoothies.example.com"
    Then she should earn 10 points
    And a welcome email is sent to her