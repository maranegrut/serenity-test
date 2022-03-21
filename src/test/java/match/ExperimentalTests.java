package match;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class ExperimentalTests extends UIInteractions {

    @Managed(driver = "chrome")
    WebDriver driver;

    CurrentPage page;
    LoginActions login;

    @Test
    void getDataLayerEvent() {
        driver.get("http://localhost:3000");

        WebElementFacade ctaButton = page.findByTestId(DataTestId.homepageSectionFourCTADesktop);
        ctaButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        assertThat(js.executeScript("return window.dataLayer")).isNotNull();
        assertThat(js.executeScript("return window.dataLayer.filter(e => e.event === \"cta_button\")[0].event")).isNotNull();
        assertThat(js.executeScript("return window.dataLayer.filter(e => e.event === \"cta_button\")[0].button_copy")).isEqualTo("Take the quiz");
    }

    @Test
    void logIntoPreferences() {
        driver.get("http://localhost:3000/preferences?target-idp=willowtree");
        login.withAdvisorId("0200253");
        WebElementFacade loginButton = page.find("#btn-sign-in");
        loginButton.click();
        assertThat(page.getTitle()).isEqualTo("Find Your Best Financial Advisor Matches | Edward Jones");
    }



    @Test
    void navigateToMatchedAdvisorsPage() throws InterruptedException {
        driver.get("http://localhost:3000");

        JavascriptExecutorFacade js = new JavascriptExecutorFacade(driver);

        js.executeScript(
                "window.localStorage.setItem(\"investor-session\", JSON.stringify({\n" +
                        "  id: 12345,\n" +
                        "  postalCode: \"77521\",\n" +
                        "  stateName: \"Texas\",\n" +
                        "  searchRadius: 20,\n" +
                        "  idealSearchRadii: {}," +
                        "  investorPersona: [\n" +
                        "    \"S_NOADVISOR\",\n" +
                        "    \"G_EXPLORATORY_CONVERSATION\",\n" +
                        "    \"G_EMERGENCY\",\n" +
                        "    \"G_MAJORPURCHASE\",\n" +
                        "    \"G_DEBT\",\n" +
                        "    \"S_NEW\",\n" +
                        "    \"S_SIMPLE\",\n" +
                        "    \"AGE_EARLY_MIDDLE\",\n" +
                        "    \"RT_NOT_SOON_RETIRE_EARLY\",\n" +
                        "    \"ASSETMINIMUM=STRATEGIZE\",\n" +
                        "    \"F_MYSELF\",\n" +
                        "    \"F_PARTNER\",\n" +
                        "    \"F_YOUNG_CHILDREN\",\n" +
                        "    \"F_OTHER\",\n" +
                        "  ]," +
                        "  otherTextFields: {},\n" +
                        "  contactedAdvisorIds: [],\n" +
                        "  optimizeToggles: { isInGoogleOptimizeExperiment: false }}));" +
                        ""
        );
        assertThat(page.getTitle()).isEqualTo("Find Your Best Financial Advisor Matches | Edward Jones");

        Thread.sleep(50000);
    }
}
