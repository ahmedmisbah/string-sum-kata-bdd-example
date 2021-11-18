package step_definitions;

import com.orange.StringSum;
import com.orange.exceptions.InvalidNumberException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class MyStepDefSum {

    long sum;
    boolean flag = false;

    @When("I input numbers {string} and {string}")
    public void i_input_numbers_and(String firstNumber, String secondNumber) {
        try {
            sum = StringSum.sum(firstNumber,secondNumber);
        } catch (InvalidNumberException e) {
            flag = true;
        }
    }

    @Then("I should get the result {long}")
    public void i_should_get_the_result(long result) {
        Assert.assertEquals(result , sum);
    }


    @Then("I should get an error")
    public void i_should_get_an_error() {
        Assert.assertTrue(flag);
    }

}
