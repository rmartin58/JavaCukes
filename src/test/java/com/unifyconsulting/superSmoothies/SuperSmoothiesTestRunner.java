package com.unifyconsulting.superSmoothies;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/superSmoothies.html"},
        features = "classpath:features/superSmoothies",
        glue = "com.unifyconsulting.superSmoothies"
)

public class SuperSmoothiesTestRunner {
}
