Feature: Super Dough Loyalty Cards

  Background:
    Given the following menu items:
      | MenueItem | Category | Cost | Points |
      | Small     | Coffee   | 1.25 | 12     |
      | Medium    | Coffee   | 1.50 | 15     |
      | Large     | Coffee   | 1.75 | 17     |
      | XLarge    | Coffee   | 2.50 | 30     |
      | Normal    | DoughNut | 2.25 | 22     |
      | Fancy     | Doughnut | 2.65 | 27     |
      | Filled    | Doughnut | 3.15 | 30     |

  Scenario Outline: Earning loyalty points
    Given Jane is a Dough-Nut loyalty member
    When she orders <Quantity> <Item> from the menue
    Then Jane earns <Points> points

    Examples:
      | Quantity | Item   | Points |
      | 1        | Filled | 30     |
      | 2        | Normal | 44     |
      | 4        | XLarge | 120    |