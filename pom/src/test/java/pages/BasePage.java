package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends PageObject {
    
    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }
    
}
