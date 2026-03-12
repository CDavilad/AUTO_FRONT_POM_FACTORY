package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class TicketsPage extends BasePage {
    
    @FindBy(css = "h1")
    private WebElement dashboardTitle;
    
    @FindBy(css = "a[href='/tickets/new']")
    private WebElement createTicketLink;
    
    @FindBy(css = "h3")
    private WebElement createdTicket;
    
    public boolean isDashboardDisplayed() {
        waitABit(5000);
        return dashboardTitle.isDisplayed();
    }
    
    public void clickCreateTicketLink() {
        waitABit(1000);
        createTicketLink.click();
        waitABit(3000);
    }
    
    public boolean isTicketDisplayed() {
        waitABit(2000);
        return createdTicket.isDisplayed();
    }
    
    public void clickOnCreatedTicket() {
        waitABit(1000);
        createdTicket.click();
        waitABit(3000);
    }
    
}
