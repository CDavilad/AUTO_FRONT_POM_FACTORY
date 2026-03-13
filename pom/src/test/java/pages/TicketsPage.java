package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class TicketsPage extends BasePage {

    @FindBy(css = "h1")
    private WebElement dashboardTitle;

    @FindBy(css = "a[href='/tickets/new']")
    private WebElement createTicketLink;

    // Note: css="h3" is generic; refine if multiple h3 elements exist on the page
    @FindBy(css = "h3")
    private WebElement createdTicket;

    public boolean isDashboardDisplayed() {
        waitFor(dashboardTitle).shouldBeVisible();
        return dashboardTitle.isDisplayed();
    }

    public void clickCreateTicketLink() {
        waitFor(createTicketLink).shouldBeVisible();
        createTicketLink.click();
    }

    public boolean isTicketDisplayed() {
        waitFor(createdTicket).shouldBeVisible();
        return createdTicket.isDisplayed();
    }

    public void clickOnCreatedTicket() {
        waitFor(createdTicket).shouldBeVisible();
        createdTicket.click();
    }

}
