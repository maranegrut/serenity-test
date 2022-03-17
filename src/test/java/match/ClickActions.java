package match;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class ClickActions extends UIInteractions {

    @Step("click on cta button")
    public void clickCtaButton() {
        $("//*[@id=\"__next\"]/main/div[1]/section/div[2]/div/a").click();
//        $("a[className^='section1_cta-desktop']").click();
    }
    @Step("click on login button")
    public void clickLoginButton() {
        $("//*[@id=\"btn-sign-in\"]").click();
    }
}
