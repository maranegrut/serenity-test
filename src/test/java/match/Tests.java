package match;

import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.webdriver.javascript.JavascriptExecutorFacade;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class Tests {

    @Managed(driver = "chrome")
    WebDriver driver;

    NavigateActions navigate;
    ClickActions click;
    CurrentPage page;
    PageInteractions interaction;
    LoginActions login;

    @Test
    void navigateToLocationPage() throws InterruptedException {
        navigate.toTheHomePage();
        click.clickCtaButton();
        assertThat(page.getTitle()).isEqualTo("Find Your Best Financial Advisor Matches | Edward Jones");
        assertThat(interaction.getLocationHeading()).isEqualTo("Where are you located?");
        Thread.sleep(30000);
    }

    @Test
    void getDataLayerEvent() {
        navigate.toTheHomePage();
        click.clickCtaButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        assertThat(js.executeScript("return window.dataLayer")).isNotNull();
        assertThat(js.executeScript("return window.dataLayer.filter(e => e.event === \"cta_button\")[0].event")).isNotNull();
        assertThat(js.executeScript("return window.dataLayer.filter(e => e.event === \"cta_button\")[0].button_copy")).isEqualTo("Take the quiz");
    }

    @Test
    void logIntoPreferences() {
        navigate.toThePreferencesPage();
        login.loginWithId("0200253");
        click.clickLoginButton();
        assertThat(page.getTitle()).isEqualTo("Find Your Best Financial Advisor Matches | Edward Jones");
    }



    @Test
    void navigateToMatchedAdvisorsPage() throws InterruptedException {
        navigate.toTheHomePage();

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
        assertThat(interaction.getHomepageHeading()).isEqualTo("Instantly match with financial advisors ready to work with you.");

        Thread.sleep(50000);
    }
}
