package com.unifyconsulting.superSmoothies;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SuperSmoothiesSteps {

    private DrinkCatalog drinkCatalog = new DrinkCatalog();
    private SuperSmoothiesSchema superSmoothieSchema = new SuperSmoothiesSchema(drinkCatalog);
    private MorningFreshMember morningFreshMember;

    @Given("the following drink categories:")
    public void the_following_drink_categories(List<Map<String, String>> drinkCategories) {
        drinkCategories.stream().forEach( drinkCategory -> {
            String drink = drinkCategory.get("Drink");
            String category = drinkCategory.get("Category");
            Integer points = Integer.parseInt(drinkCategory.get("Points"));
            drinkCatalog.add(drink, category);
            superSmoothieSchema.setPointsPerCategory(category, points);
        });
    }

    @Given("^(.*) is a Morning Freshness member$")
    public void customer_is_a_morning_freshness_member(String name) {
        morningFreshMember = new MorningFreshMember(name, superSmoothieSchema);
    }

    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void member_purchases_apple_and_kale_drinks(String name,
                                                        Integer quantity,
                                                        String drink) {
        morningFreshMember.orders(quantity, drink);
    }

    @Then("(s)he should earn {int} points")
    public void she_should_earn_points(Integer expectedPoints) {
        assertThat(morningFreshMember.getEarnedPoints()).isEqualTo(expectedPoints);
    }
}
