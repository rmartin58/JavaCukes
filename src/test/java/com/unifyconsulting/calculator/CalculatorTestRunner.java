package com.unifyconsulting.calculator;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber.html"},
        features = "classpath:features/calculator",
        glue = "com.unifyconsulting.calculator"
)

public class CalculatorTestRunner {
}
