package match;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class ClickActions extends UIInteractions {

    @Step("click on cta button")
    public void clickCtaButton() {
        $("[data-testid=\"homepage-section-one-cta-desktop\"]").click();
    }
    @Step("click on login button")
    public void clickLoginButton() {
        $("//*[@id=\"btn-sign-in\"]").click();
    }
}
