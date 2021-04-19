package com.unifyconsulting.superSmoothies;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SuperSmoothiesSteps {

    private final DrinkCatalog drinkCatalog = new DrinkCatalog();
    private final SuperSmoothiesSchema superSmoothieSchema = new SuperSmoothiesSchema(drinkCatalog);
    private iCustomer customer;

    @Given("the following drink categories:")
    public void the_following_drink_categories(List<Map<String, String>> drinkCategories) {
        drinkCategories.forEach(drinkCategory -> {
            String drink = drinkCategory.get("Drink");
            String category = drinkCategory.get("Category");
            Integer points = Integer.parseInt(drinkCategory.get("Points"));
            drinkCatalog.add(drink, category);
            superSmoothieSchema.setPointsPerCategory(category, points);
        });
    }

    @Given("^(.*) is a Morning Freshness member$")
    public void customer_is_a_morning_freshness_member(String name) {
        customer = new MorningFreshCustomer(name, superSmoothieSchema, true);
    }

    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void member_purchases_apple_and_kale_drinks(String name,
                                                        Integer quantity,
                                                        String drink) {

        System.out.println(String.format("### Customer %s is ordering %d %s",name, quantity, drink));
        customer.orders(quantity, drink);
    }

    @Then("(s)he should earn {int} points")
    public void she_should_earn_points(Integer expectedPoints) {
        assertThat(customer.getEarnedPoints()).isEqualTo(expectedPoints);
    }

    @Given("^(.*) is not a Morning Freshness member")
    public void jack_is_not_a_morning_freshness_member(String name) {
        customer = new MorningFreshCustomer(name,superSmoothieSchema, false);
    }

}
