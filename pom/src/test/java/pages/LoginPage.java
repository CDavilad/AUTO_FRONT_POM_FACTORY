package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    
    @FindBy(css = "input[placeholder='tu@email.com']")
    private WebElement emailInput;
    
    @FindBy(css = "input[type='password']")
    private WebElement passwordInput;
    
    @FindBy(css = "button")
    private WebElement loginButton;
    
    @FindBy(css = "h1")
    private WebElement loginTitle;
    
    public void openLoginPage(String url) {
        openUrl(url);
        waitABit(3000);
    }
    
    public void enterEmail(String email) {
        waitABit(1000);
        emailInput.clear();
        emailInput.sendKeys(email);
        waitABit(500);
    }
    
    public void enterPassword(String password) {
        waitABit(500);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        waitABit(500);
    }
    
    public void clickLoginButton() {
        waitABit(1000);
        loginButton.click();
        waitABit(5000);
    }
    
    public boolean isLoginPageDisplayed() {
        waitABit(1000);
        return loginTitle.isDisplayed();
    }
    
}
