Feature: Super Freshness Member Loyalty Cards


  Background:
    Given the following drink categories:
      | Drink              | Category | Points | Price |
      | Apple and Kale     | Regular  | 15     | 3.25  |
      | Triple Berry Blend | Fancy    | 20     | 4.00  |
      | Earl Gray          | Tea      | 10     | 2.50  |

  Scenario: Earning loyalty points with single item orders
    Given "Ahmed" is a Morning Freshness member
    When "Ahmed" purchases 1 "Triple Berry Blend" drink
    Then he should earn 20 points

  Scenario Outline: Earning loyalty points with multiple same item orders
    Given "Michael" is a Morning Freshness member
    When "Michael" purchases <Quantity> <Drink> drinks
    Then he should earn <Points> points

    Examples:
      | Drink                | Quantity | Points |
      | "Apple and Kale"     | 2        | 30     |
      | "Triple Berry Blend" | 1        | 20     |
      | "Earl Gray"          | 3        | 30     |

  Scenario: When Jane orders multiple items she earns points
    Given "Jane" is a Morning Freshness member
    When "Jane" purchases 1 "Apple and Kale" drink
    And "Jane" purchases 3 "Triple Berry Blend" drinks
    And "Jane" purchases 6 "Earl Gray" drinks
    Then she should earn 135 points

  Scenario: When Jack orders a single item he earns zero points
    Given "Jack" is not a Morning Freshness member
    When "Jack" purchases 1 "Triple Berry Blend" drink
    Then he should earn 0 points

  Scenario: Anne enrolls as a member while ordering a drink and gets 10 sign-on points
    Given "Anne" is not a Morning Freshness member
    When she enrolls as a member
    And "Anne" purchases 1 "Earl Gray" drink
    Then she should earn 20 points