package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @FindBy(css = "input[placeholder='tu@email.com']")
    private WebElement emailInput;

    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(css = "h1")
    private WebElement loginTitle;

    public void openLoginPage() {
        openAt("/");
        waitFor(loginTitle).shouldBeVisible();
    }

    public void enterEmail(String email) {
        waitFor(emailInput).shouldBeVisible();
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        waitFor(passwordInput).shouldBeVisible();
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        waitFor(loginButton).shouldBeVisible();
        loginButton.click();
    }

    public boolean isLoginPageDisplayed() {
        waitFor(loginTitle).shouldBeVisible();
        return loginTitle.isDisplayed();
    }

}
