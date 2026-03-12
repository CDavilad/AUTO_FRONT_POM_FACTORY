package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps;
import steps.TicketManagementSteps;

public class TicketManagementStepDefinitions {
    
    @Steps
    private TicketManagementSteps ticketSteps;
    
    @Given("the admin is on the login page")
    public void theAdminIsOnTheLoginPage() {
        ticketSteps.openLoginPage();
    }
    
    @When("the admin enters email {string} and password {string}")
    public void theAdminEntersEmailAndPassword(String email, String password) {
        ticketSteps.enterLoginCredentials(email, password);
    }
    
    @And("the admin submits the login form")
    public void theAdminSubmitsTheLoginForm() {
        ticketSteps.submitLoginForm();
    }
    
    @Then("the admin should see the tickets dashboard")
    public void theAdminShouldSeeTheTicketsDashboard() {
        ticketSteps.verifyTicketsDashboard();
    }
    
    @When("the admin navigates to create ticket page")
    public void theAdminNavigatesToCreateTicketPage() {
        ticketSteps.navigateToCreateTicketPage();
    }
    
    @And("the admin enters ticket title {string}")
    public void theAdminEntersTicketTitle(String title) {
        ticketSteps.enterTicketTitle(title);
    }
    
    @And("the admin enters ticket description {string}")
    public void theAdminEntersTicketDescription(String description) {
        ticketSteps.enterTicketDescription(description);
    }
    
    @And("the admin submits the ticket form")
    public void theAdminSubmitsTheTicketForm() {
        ticketSteps.submitTicketForm();
    }
    
    @Then("the admin should see the new ticket in the dashboard")
    public void theAdminShouldSeeTheNewTicketInTheDashboard() {
        ticketSteps.verifyTicketCreated();
    }
    
    @When("the admin clicks on the created ticket")
    public void theAdminClicksOnTheCreatedTicket() {
        ticketSteps.clickOnCreatedTicket();
    }
    
    @Then("the admin should see the ticket detail page")
    public void theAdminShouldSeeTheTicketDetailPage() {
        ticketSteps.verifyTicketDetailPage();
    }
    
    @When("the admin changes the priority to {string}")
    public void theAdminChangesThePriorityTo(String priority) {
        ticketSteps.changePriority(priority);
    }
    
    @And("the admin saves the priority change")
    public void theAdminSavesThePriorityChange() {
        ticketSteps.savePriorityChange();
    }
    
    @Then("the priority should be updated successfully")
    public void thePriorityShouldBeUpdatedSuccessfully() {
        ticketSteps.verifyPriorityUpdated();
    }
    
}
