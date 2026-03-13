package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import steps.LoginSteps;

public class LoginStepDefinitions {
    
    @Steps
    private LoginSteps loginSteps;
    
    @Given("the admin is on the login page")
    public void theAdminIsOnTheLoginPage() {
        loginSteps.openLoginPage();
    }
    
    @When("the admin enters email {string} and password {string}")
    public void theAdminEntersEmailAndPassword(String email, String password) {
        loginSteps.enterLoginCredentials(email, password);
    }
    
    @And("the admin submits the login form")
    public void theAdminSubmitsTheLoginForm() {
        loginSteps.submitLoginForm();
    }
    
    @Then("the admin should see the tickets dashboard")
    public void theAdminShouldSeeTheTicketsDashboard() {
        loginSteps.verifyTicketsDashboard();
    }
    
}
