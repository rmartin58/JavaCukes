package com.unifyconsulting.calculator;

import com.unifyconsulting.Calculator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorSteps {

    private Calculator calculator;
    private int result;
    private String errorMsg;
    private String errString;


    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void iAddTwoIntegers(int int1, int int2) {
        result = calculator.add(int1, int2);
    }

    @Then("I should get {int}")
    public void iShouldGet(Integer expectedResult) {
        assertThat(result).isEqualTo(expectedResult);
    }

    @When("I divide {int} by {int}")
    public void divideDividendByDivisor(Integer dividend, Integer divisor) {
        try {
            result = calculator.divide(dividend, divisor);
        } catch (ArithmeticException e) {
            errString = e.toString();
            errorMsg = e.getMessage();
        }
    }

    @Then("I should get {string}")
    public void iShouldGetErrorMessage(String errorMessage) {
        assertThat(errString).contains(errorMessage);
    }

    @And("I should not get an exception")
    public void iShouldNotGetAnException() {
        assertThat(errString).isNullOrEmpty();
    }
}
