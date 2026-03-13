package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TicketDetailPage extends BasePage {

    @FindBy(css = "h1")
    private WebElement ticketTitle;

    @FindBy(css = "form select")
    private WebElement prioritySelect;

    @FindBy(css = "form button[type='submit']")
    private WebElement saveButton;

    @FindBy(xpath = "/html/body/div/div[1]/div/div[1]/span[3]")
    private WebElement prioritySpan;

    public boolean isTicketDetailDisplayed() {
        waitFor(ticketTitle).shouldBeVisible();
        return ticketTitle.isDisplayed();
    }

    public void selectPriority(String priority) {
        waitFor(prioritySelect).shouldBeVisible();
        Select select = new Select(prioritySelect);
        select.selectByVisibleText(priority);
    }

    public void clickSaveButton() {
        waitFor(saveButton).shouldBeVisible();
        saveButton.click();
    }

    public boolean isPriorityUpdated(String expectedPriority) {
        waitFor(prioritySpan).shouldBeVisible();
        return prioritySpan.getText().contains(expectedPriority);
    }

}
