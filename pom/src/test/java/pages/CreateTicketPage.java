package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class CreateTicketPage extends BasePage {
    
    @FindBy(css = "h1")
    private WebElement createTicketTitle;
    
    @FindBy(css = "input[id='ticket-title']")
    private WebElement titleInput;
    
    @FindBy(css = "textarea[id='ticket-description']")
    private WebElement descriptionInput;
    
    @FindBy(xpath = "/html/body/div/div[1]/form/button")
    private WebElement createButton;
    
    public boolean isCreateTicketPageDisplayed() {
        waitABit(1000);
        return createTicketTitle.isDisplayed();
    }
    
    public void enterTitle(String title) {
        waitABit(1000);
        titleInput.clear();
        titleInput.sendKeys(title);
        waitABit(500);
    }
    
    public void enterDescription(String description) {
        waitABit(500);
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
        waitABit(500);
    }
    
    public void clickCreateButton() {
        waitABit(1000);
        createButton.click();
        waitABit(5000);
    }
    
}
