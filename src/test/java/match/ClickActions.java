package match;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class ClickActions extends UIInteractions {

    @Step("click on button")
    public void clickButton() {
        $("//*[@id=\"__next\"]/main/div[1]/div/a").click();
//        $("a[className^='section1_cta-desktop']").click();


    }
}
