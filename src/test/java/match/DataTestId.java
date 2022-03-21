package match;

public enum DataTestId {
    navigationButton("navigation-button"),
    backLink("back-link"),
    backMobileText("back-mobile-text"),
    headerLogo("header-logo"),
    headerMatchLogo("header-logo-match"),
    homepageSectionOneCTADesktop("homepage-section-one-cta-desktop"),
    homepageSectionOneCTAMobile("homepage-section-one-cta-mobile"),
    homepageSectionFourCTADesktop("homepage-section-four-cta-desktop"),
    homepageCopyLinkCTA("homepage-copy-link"),
    footerDisclosures("footer-disclosures-link"),
    footerPrivacy("footer-privacy-link"),
    footerFinra("footer-finra-link"),
    footerSipc("footer-sipc-link"),
    footerSipcMobile("footer-sipc-link-mobile"),
    locationPostalCodeInput("location-zipcode-input"),
    locationNavigationButton("location-navigation-button"),
    useMyLocation("use-my-location"),
    outOfMarketCTA("out-of-market-cta"),
    noFinancialAdvisor("not-financial-advisor"),
    exploratoryConversation("exploratory-conversation"),
    retirement("retirement"),
    textOtherGoals("text-other-goals"),
    reachedGoals("reached-goals"),
    experienced("experienced"),
    simpleFinances("simple-finances"),
    earlyMiddleAdulthood("early-middle-adulthood"),
    asSoonAsPossibleRetireEarly("as-soon-as-possible-retire-early"),
    minTwoMillion("min2000k"),
    fullTimeEmployment("full-time-employment"),
    incomeBetween140kAnd200k("between-140k-and-200k"),
    myself("myself"),
    partner("partner"),
    familyOther("family-other"),
    familyOtherTextbox("text-family-other"),
    textInputErrorMessageOtherFamily("text-input-error-message-otherFamily"),
    uniqueConsiderations("unique-considerations-option"),
    charitableIntent("charitable-intent"),
    lgbtqFinancialConsiderations("lgbtq+-financial-considerations"),
    sociallyConsciousInvesting("socially-concious-investing"),
    advisor("advisor"),
    matchedAdvisorsBackLink("matched-advisors-back-link"),
    advisorViewProfile("advisor-view-profile"),
    profileBackLink("profile-back-link"),
    profileAdvisorAddress("profile-advisor-address"),
    profileAdvisorPhoneNumber("profile-advisor-phone-number"),
    contactFormFullName("contact-form-full-name"),
    contactFormEmail("contact-form-email"),
    contactFormPhone("contact-form-phone"),
    contactFormPermissionCheckbox("contact-form-permission-checkbox"),
    contactFormSubmitButton("contact-form-submit"),
    thankYouLinkInitialConversation("thank-you-link-1"),
    thankYouLinkQuestions("thank-you-link-2"),
    thankYouLinkFARelationship("thank-you-link-3"),
    thankYouBackLink("thank-you-back-link"),

    // Advisor Preferences
    yesEnrolled("yes-enrolled"),
    noEnrolled("no-enrolled"),
    breakerPageHeading("breaker-page-heading"),
    unenrolledPageHeading("unenrolled-page-heading"),
    assetMinimum50000("asset-minimum-50000"),
    yesUndisclosedAssets("yes-undisclosed-assets"),
    yesVirtualMeetings("yes-virtual-meetings"),
    complexCharacteristic("complex-characteristic"),
    experiencedCharacteristic("experienced-characteristic"),
    widowedCharacteristic("widowed-characteristic"),
    lateSaverCharacteristic("late-saver-characteristic"),
    newInvestorsCharacteristic("new-investor-characteristic"),
    earlyLifeStage("early-life-stage"),
    lateMiddleLifeStage("late-middle-life-stage"),
    lateLifeStage("late-life-stage"),
    charitableGivingFocus("charitable-giving-focus"),
    intergenerationalPlanningFocus("intergenerational-planning-focus"),
    suddenWealthStrategiesFocus("sudden-wealth-strategies-focus"),
    retirementIncomeStrategiesFocus("retirement-income-strategies-focus"),
    taxSmartStrategiesFocus("tax-smart-strategies-focus"),
    editPreferencesButton("edit-preferences-button");

    private final String idValue;

    DataTestId(String idValue) {
        this.idValue = idValue;

    }

    public String getIdValue() {
        return idValue;
    }

}
