package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import pages.TicketsPage;
import pages.CreateTicketPage;
import pages.TicketDetailPage;
import utils.Priority;

public class TicketManagementSteps {

    private TicketsPage ticketsPage;
    private CreateTicketPage createTicketPage;
    private TicketDetailPage ticketDetailPage;

    @Step("Navigate to create ticket page")
    public void navigateToCreateTicketPage() {
        ticketsPage.clickCreateTicketLink();
        Assert.assertTrue("Create ticket page should be displayed",
                createTicketPage.isCreateTicketPageDisplayed());
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
        Assert.assertTrue("Created ticket should be visible in the dashboard",
                ticketsPage.isTicketDisplayed());
    }

    @Step("Click on the created ticket")
    public void clickOnCreatedTicket() {
        ticketsPage.clickOnCreatedTicket();
    }

    @Step("Verify ticket detail page is displayed")
    public void verifyTicketDetailPage() {
        Assert.assertTrue("Ticket detail page should be displayed",
                ticketDetailPage.isTicketDetailDisplayed());
    }

    @Step("Change priority to: {0}")
    public void changePriority(String priority) {
        String priorityText = Priority.fromString(priority).getDisplayText();
        Serenity.setSessionVariable("selectedPriority").to(priorityText);
        ticketDetailPage.selectPriority(priorityText);
    }

    @Step("Save priority change")
    public void savePriorityChange() {
        ticketDetailPage.clickSaveButton();
    }

    @Step("Verify priority was updated")
    public void verifyPriorityUpdated() {
        String selectedPriority = Serenity.sessionVariableCalled("selectedPriority");
        Assert.assertTrue("Priority should be updated to: " + selectedPriority,
                ticketDetailPage.isPriorityUpdated(selectedPriority));
    }

}
