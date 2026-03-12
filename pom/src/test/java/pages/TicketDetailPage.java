package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TicketDetailPage extends BasePage {
    
    @FindBy(css = "h1")
    private WebElement ticketTitle;
    
    @FindBy(xpath = "/html/body/div/div[1]/form/div[1]/select")
    private WebElement prioritySelect;
    
    @FindBy(xpath = "/html/body/div/div[1]/form/button")
    private WebElement saveButton;
    
    @FindBy(xpath = "//div[contains(text(),'Alta')] | //span[contains(text(),'Alta')] | //*[contains(text(),'Alta')]")
    private WebElement priorityBadgeHigh;
    
    @FindBy(xpath = "//div[contains(text(),'Media')] | //span[contains(text(),'Media')] | //*[contains(text(),'Media')]")
    private WebElement priorityBadgeMedium;
    
    @FindBy(xpath = "//div[contains(text(),'Baja')] | //span[contains(text(),'Baja')] | //*[contains(text(),'Baja')]")
    private WebElement priorityBadgeLow;
    
    public boolean isTicketDetailDisplayed() {
        waitABit(2000);
        return ticketTitle.isDisplayed();
    }
    
    public void selectPriority(String priority) {
        waitABit(1000);
        Select select = new Select(prioritySelect);
        select.selectByVisibleText(priority);
        waitABit(500);
    }
    
    public void clickSaveButton() {
        waitABit(1000);
        saveButton.click();
        waitABit(5000);
    }
    
    public boolean isPriorityUpdated(String expectedPriority) {
        waitABit(2000);
        return switch (expectedPriority) {
            case "Alta" -> priorityBadgeHigh.isDisplayed();
            case "Media" -> priorityBadgeMedium.isDisplayed();
            case "Baja" -> priorityBadgeLow.isDisplayed();
            default -> false;
        };
    }
    
}
