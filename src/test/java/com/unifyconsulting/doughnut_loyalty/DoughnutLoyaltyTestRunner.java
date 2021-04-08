package com.unifyconsulting.doughnut_loyalty;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/doughNutLoyalty.html"},
        features = "classpath:features/doughnut_loyalty",
        glue = "com.unifyconsulting.doughnut_loyalty"
)

public class DoughnutLoyaltyTestRunner {
}
