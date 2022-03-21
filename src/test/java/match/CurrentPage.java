package match;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;

public class CurrentPage extends PageObject {

    @Step("find element by data-testid {0}")
    public WebElementFacade findByTestId(DataTestId testId) {
        return $(String.format("[data-testid=%s]", testId.getIdValue()));
    }
}
