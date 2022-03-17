package match;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class LoginActions extends UIInteractions {

    @Step("Type username")
    public void loginWithId(String keyword) {
        $("//*[@id=\"userName\"]").clear();
        $("//*[@id=\"userName\"]").sendKeys(keyword);
    }
}
