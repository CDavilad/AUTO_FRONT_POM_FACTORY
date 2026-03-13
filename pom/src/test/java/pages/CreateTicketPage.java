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

    @FindBy(css = "form button[type='submit']")
    private WebElement createButton;

    public boolean isCreateTicketPageDisplayed() {
        waitFor(createTicketTitle).shouldBeVisible();
        return createTicketTitle.isDisplayed();
    }

    public void enterTitle(String title) {
        waitFor(titleInput).shouldBeVisible();
        titleInput.clear();
        titleInput.sendKeys(title);
    }

    public void enterDescription(String description) {
        waitFor(descriptionInput).shouldBeVisible();
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }

    public void clickCreateButton() {
        waitFor(createButton).shouldBeVisible();
        createButton.click();
    }

}
