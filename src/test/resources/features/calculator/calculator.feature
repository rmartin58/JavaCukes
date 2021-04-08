Feature: Calculator

  Background:
    Given I have a calculator

  Scenario Outline: Add two integers
    When I add <int1> and <int2>
    Then I should get <sumInt>
    And I should not get an exception
    Examples:
      | int1 | int2 | sumInt |
      | 3    | 6    | 9      |
      | 10   | -5   | 5      |
      | 5    | -8   | -3     |
      | 5    | 0    | 5      |
      | 0    | -0   | -0     |

  Scenario Outline: Divide on integer by another
    When I divide <dividend> by <divisor>
    Then I should get <quotient>
    Examples:
      | dividend | divisor | quotient |
      | 6        | 3       | 2        |
      | 25       | 5       | 5        |

  Scenario Outline: Divide by zero
    When I divide <dividend> by <divisor>
    Then I should get <errorMessage>

    Examples:
      | dividend | divisor | errorMessage |
      | 2        | 0       | "java.lang.ArithmeticException: / by zero"  |
      | 3        | 0       | "ArithmeticException"  |
      | -10      | 0       | "/ by zero"  |
