package steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import pages.LoginPage;
import pages.TicketsPage;
import pages.CreateTicketPage;
import pages.TicketDetailPage;

public class TicketManagementSteps {
    
    private LoginPage loginPage;
    private TicketsPage ticketsPage;
    private CreateTicketPage createTicketPage;
    private TicketDetailPage ticketDetailPage;
    private String selectedPriority = "";

    @Step("Open the login page")
    public void openLoginPage() {
        loginPage.openLoginPage("http://localhost:3000/");
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
    
    @Step("Enter login credentials: {0} and password")
    public void enterLoginCredentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }
    
    @Step("Submit the login form")
    public void submitLoginForm() {
        loginPage.clickLoginButton();
    }

    @Step("Verify tickets dashboard is displayed")
    public void verifyTicketsDashboard() {
        Assert.assertTrue(ticketsPage.isDashboardDisplayed());
    }
    
    @Step("Navigate to create ticket page")
    public void navigateToCreateTicketPage() {
        ticketsPage.clickCreateTicketLink();
        Assert.assertTrue(createTicketPage.isCreateTicketPageDisplayed());
    }
    
    @Step("Enter ticket title: {0}")
    public void enterTicketTitle(String title) {
        createTicketPage.enterTitle(title);
    }
    
    @Step("Enter ticket description: {0}")
    public void enterTicketDescription(String description) {
        createTicketPage.enterDescription(description);
    }
    
    @Step("Submit the ticket form")
    public void submitTicketForm() {
        createTicketPage.clickCreateButton();
    }
    
    @Step("Verify ticket was created and displayed in dashboard")
    public void verifyTicketCreated() {
        Assert.assertTrue(ticketsPage.isTicketDisplayed());
    }
    
    @Step("Click on the created ticket")
    public void clickOnCreatedTicket() {
        ticketsPage.clickOnCreatedTicket();
    }
    
    @Step("Verify ticket detail page is displayed")
    public void verifyTicketDetailPage() {
        Assert.assertTrue(ticketDetailPage.isTicketDetailDisplayed());
    }
    
    @Step("Change priority to: {0}")
    public void changePriority(String priority) {
        String priorityText = "Alta";
        if (priority.equals("HIGH")) {
            priorityText = "Alta";
        } else if (priority.equals("MEDIUM")) {
            priorityText = "Media";
        } else if (priority.equals("LOW")) {
            priorityText = "Baja";
        }
        selectedPriority = priorityText;
        ticketDetailPage.selectPriority(priorityText);
    }
    
    @Step("Save priority change")
    public void savePriorityChange() {
        ticketDetailPage.clickSaveButton();
    }
    
    @Step("Verify priority was updated")
    public void verifyPriorityUpdated() {
        Assert.assertTrue("Priority should be updated to: " + selectedPriority, 
            ticketDetailPage.isPriorityUpdated(selectedPriority));
    }
    
}
