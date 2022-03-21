package match;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

    @ExtendWith(SerenityJUnit5Extension.class)
    class HomePageTests extends UIInteractions {

        @Managed(driver = "chrome")
        WebDriver driver;

        CurrentPage page;

        @Test
        void navigateToLocationPage() {
            openUrl("http://localhost:3000");

            WebElementFacade ctaButton = page.findByTestId(DataTestId.homepageSectionFourCTADesktop);
            WebElementFacade locationInput= page.findByTestId(DataTestId.locationPostalCodeInput);

            ctaButton.click();

            locationInput.shouldBeVisible();
        }

    }
