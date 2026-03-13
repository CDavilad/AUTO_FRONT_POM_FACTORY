package steps;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import pages.LoginPage;
import pages.TicketsPage;

public class LoginSteps {

    private LoginPage loginPage;
    private TicketsPage ticketsPage;

    @Step("Open the login page")
    public void openLoginPage() {
        loginPage.openLoginPage();
        Assert.assertTrue("Login page should be displayed after navigation",
                loginPage.isLoginPageDisplayed());
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
        Assert.assertTrue("Tickets dashboard should be visible after login",
                ticketsPage.isDashboardDisplayed());
    }

}
