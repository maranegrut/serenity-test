package match;

import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

public class PageInteractions extends UIInteractions {

    @Step("find location heading")
    public String getLocationHeading() {
       return $("//*[@id=\"zipcodeQuestion\"]/h1").getText();
    }
    @Step("find homepage heading")
    public String getHomepageHeading() {
        return $("//*[@id=\"__next\"]/main/div[1]/section/div[2]/h1").getText();
    }
    @Step("find matched advisors heading")
    public String getAvisorsHeading() {
        return $("//*[@id=\"__next\"]/main/div/section/h1").getText();
    }
}
