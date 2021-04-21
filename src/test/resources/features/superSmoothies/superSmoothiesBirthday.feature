Feature: A customer gets a single free super smoothie for their birthday
  This free smoothie can be redeemed between 30 days before and 30 days after their birthday

  Scenario: Billy has a birthday today
    Given "Billy" is a Morning Freshness member
    When "Billy" purchases 1 "Apple and Kale" drink
    Then she should earn 135 points
