package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Footer_Page extends BasePage {

    @FindBy(css = ".content")
    @CacheLookup
    public WebElement Content;
    @FindBy(partialLinkText = "TERMS AND CONDITIONS")
    @CacheLookup
    private WebElement TERMS_CONDITIONS_btn;
    @FindBy(partialLinkText = "RESPONSIBLE GAMING")
    @CacheLookup
    private WebElement LEGAL_RESPONSIBLE_btn;
    @FindBy(partialLinkText = "DISPUTE RESOLUTION")
    @CacheLookup
    private WebElement DISPUTE_RESOLUTION_btn;

    @FindBy(partialLinkText = "SELF EXCLUSION")
    @CacheLookup
    private WebElement SELF_EXLUSION_btn;

    @FindBy(partialLinkText = "AML")
    @CacheLookup
    private WebElement AML_btn;

    @FindBy(partialLinkText = "FAIR GAMING AND RNG")
    @CacheLookup
    private WebElement FAIR_GAMING_AND_RNG_btn;

    @FindBy(partialLinkText = "Գաղտնիության քաղաքականություն")
    @CacheLookup
    private WebElement PRIVACY_POLICY_btn;

    @FindBy(partialLinkText = "ACCOUNT, PAYOUTS, BONUSES")
    @CacheLookup
    private WebElement ACCOUNT_PAYOUTS_BONUSES_btn;

    @FindBy(partialLinkText = "KYC POLICIES, PRIVACY AND MANAGEMENT OF PERSONAL DATA")
    @CacheLookup
    private WebElement KYC_POLICIES_PRIVACY_AND_MANAGEMENT_OF_PERSONAL_DATA_btn;

    @FindBy(partialLinkText = "PREMIER LEAGUE")
    @CacheLookup
    private WebElement PREMIER_LEAGUE_btn;

    @FindBy(partialLinkText = "LIGUE 1")
    @CacheLookup
    private WebElement LIGUE_1_btn;

    @FindBy(partialLinkText = "BUNDESLIGA")
    @CacheLookup
    private WebElement SERIE_A_btn;

    @FindBy(partialLinkText = "SERIE A")
    @CacheLookup
    private WebElement BUNDESLIGA_btn;

    @FindBy(partialLinkText = "CHAMPIONS LEAGUE")
    @CacheLookup
    private WebElement CHAMPIONS_LEAGUE_btn;

    @FindBy(partialLinkText = "EVOLUTION")
    @CacheLookup
    private WebElement EVOLUTION_btn;

    @FindBy(partialLinkText = "EZUGI")
    @CacheLookup
    private WebElement EZUGI_btn;

    @FindBy(partialLinkText = "VIVO GAMING")
    @CacheLookup
    private WebElement Vivo_Gaming__btn;

    @FindBy(partialLinkText = "PRAGMATIC PLAY")
    @CacheLookup
    private WebElement Pragmatic_Play__btn;

    @FindBy(partialLinkText = "BINGO 37")
    @CacheLookup
    private WebElement BINGO_37_btn;

    @FindBy(partialLinkText = "KENO")
    @CacheLookup
    private WebElement KENO_btn;

    @FindBy(partialLinkText = "CRASH")
    @CacheLookup
    private WebElement CRASH_btn;

    @FindBy(partialLinkText = "HIGH LOW")
    @CacheLookup
    private WebElement HIGH_LOW_btn;

    @FindBy(partialLinkText = "BET ON RACING")
    @CacheLookup
    private WebElement BET_ON_RACING_btn;

    @FindBy(partialLinkText = "BET ON POKER")
    @CacheLookup

    private WebElement BET_ON_POKER_btn;

    @FindBy(partialLinkText = "BINGO 47")
    @CacheLookup
    private WebElement BINGO_47_btn;

    @FindBy(partialLinkText = "COLORS")
    @CacheLookup
    private WebElement COLORS_btn;

    @FindBy(partialLinkText = "MINESWEEPER")
    @CacheLookup
    private WebElement MINESWEPPER_btn;

    @FindBy(css = ".ft-images-type1-item")
    @CacheLookup
    private List<WebElement> Social_icons;


    public Footer_Page() {
        PageFactory.initElements(BasePage.driver, this);

    }

    BasePage basePage = new BasePage(driver);

    public void TERMS_CONDITIONS() {
        basePage.scrollToSpecificElementOnCenter(TERMS_CONDITIONS_btn);
        basePage.javaScriptClick(TERMS_CONDITIONS_btn);
        basePage.SwitchtoActiveTab();

    }

    public void RESPONSIBLE_GAMING() {
        basePage.scrollToSpecificElementOnCenter(LEGAL_RESPONSIBLE_btn);
        basePage.javaScriptClick(LEGAL_RESPONSIBLE_btn);
        basePage.SwitchtoActiveTab();
        basePage.waitAction(4000);
    }

    public void SELF_EXLUSION() {
        basePage.scrollToSpecificElementOnCenter(SELF_EXLUSION_btn);
        basePage.javaScriptClick(SELF_EXLUSION_btn);
        basePage.SwitchtoActiveTab();
    }

    public void DISPUTE_RESOLUTION() {
        basePage.scrollToSpecificElementOnCenter(DISPUTE_RESOLUTION_btn);
        basePage.javaScriptClick(DISPUTE_RESOLUTION_btn);
        basePage.SwitchtoActiveTab();
    }

    public void AML() {
        basePage.scrollToSpecificElementOnCenter(AML_btn);
        basePage.javaScriptClick(AML_btn);
        basePage.SwitchtoActiveTab();
    }

    public void FAIR_GAMING_AND_RNG() {
        basePage.scrollToSpecificElementOnCenter(FAIR_GAMING_AND_RNG_btn);
        basePage.javaScriptClick(FAIR_GAMING_AND_RNG_btn);
        basePage.SwitchtoActiveTab();
    }

    public void PRIVACY_POLICY() {
        basePage.scrollToSpecificElementOnCenter(PRIVACY_POLICY_btn);
        basePage.javaScriptClick(PRIVACY_POLICY_btn);
        basePage.SwitchtoActiveTab();
    }

    public void ACCOUNT_PAYOUTS_BONUSES() {
        basePage.scrollToSpecificElementOnCenter(ACCOUNT_PAYOUTS_BONUSES_btn);
        basePage.javaScriptClick(ACCOUNT_PAYOUTS_BONUSES_btn);
        basePage.SwitchtoActiveTab();

    }

    public void KYC_POLICIES_PRIVACY_AND_MANAGEMENT_OF_PERSONAL_DATA() {
        basePage.scrollToSpecificElementOnCenter(KYC_POLICIES_PRIVACY_AND_MANAGEMENT_OF_PERSONAL_DATA_btn);
        basePage.javaScriptClick(KYC_POLICIES_PRIVACY_AND_MANAGEMENT_OF_PERSONAL_DATA_btn);
        basePage.SwitchtoActiveTab();

    }

    public void PREMIER_LEAGUE() {
        basePage.scrollToSpecificElementOnCenter(PREMIER_LEAGUE_btn);
        basePage.javaScriptClick(PREMIER_LEAGUE_btn);
        basePage.SwitchtoActiveTab();
    }

    public void LIGUE_1() {
        basePage.scrollToSpecificElementOnCenter(LIGUE_1_btn);
        basePage.javaScriptClick(LIGUE_1_btn);
        basePage.SwitchtoActiveTab();
    }

    public void BUNDESLIGA() {
        basePage.scrollToSpecificElementOnCenter(BUNDESLIGA_btn);
        basePage.javaScriptClick(BUNDESLIGA_btn);
        basePage.SwitchtoActiveTab();

    }

    public void SERIE_A() {
        basePage.scrollToSpecificElementOnCenter(SERIE_A_btn);
        basePage.javaScriptClick(SERIE_A_btn);
        basePage.SwitchtoActiveTab();
    }

    public void CHAMPIONS_LEAGUE() {
        basePage.scrollToSpecificElementOnCenter(CHAMPIONS_LEAGUE_btn);
        basePage.javaScriptClick(CHAMPIONS_LEAGUE_btn);
        basePage.SwitchtoActiveTab();
    }

    public void EVOLUTION() {
        basePage.scrollToSpecificElementOnCenter(EVOLUTION_btn);
        basePage.javaScriptClick(EVOLUTION_btn);
        basePage.SwitchtoActiveTab();
    }

    public void EZUGI() {
        basePage.scrollToSpecificElementOnCenter(EZUGI_btn);
        basePage.javaScriptClick(EZUGI_btn);
        basePage.SwitchtoActiveTab();

    }

    public void BINGO_37() {
        basePage.scrollToSpecificElementOnCenter(BINGO_37_btn);
        basePage.javaScriptClick(BINGO_37_btn);
    }

    public void KENO() {
        basePage.scrollToSpecificElementOnCenter(KENO_btn);
        basePage.javaScriptClick(KENO_btn);
    }

    public void CRASH() {
        basePage.scrollToSpecificElementOnCenter(CRASH_btn);
        basePage.javaScriptClick(CRASH_btn);
    }

    public void HIGH_LOW() {
        basePage.scrollToSpecificElementOnCenter(HIGH_LOW_btn);
        basePage.javaScriptClick(HIGH_LOW_btn);
    }

    public void BET_ON_RACING() {
        basePage.scrollToSpecificElementOnCenter(BET_ON_RACING_btn);
        basePage.javaScriptClick(BET_ON_RACING_btn);
    }

    public void BET_ON_POKER() {
        basePage.scrollToSpecificElementOnCenter(BET_ON_POKER_btn);
        basePage.javaScriptClick(BET_ON_POKER_btn);
    }

    public void BINGO_47() {
        basePage.scrollToSpecificElementOnCenter(BINGO_47_btn);
        basePage.javaScriptClick(BINGO_47_btn);
    }

    public void COLORS() {
        basePage.scrollToSpecificElementOnCenter(COLORS_btn);
        basePage.javaScriptClick(COLORS_btn);
    }

    public void MINESWEEPER() {
        basePage.scrollToSpecificElementOnCenter(MINESWEPPER_btn);
        basePage.javaScriptClick(MINESWEPPER_btn);

    }

    public void Payment_icons() {
        for (int p = 0; p < Social_icons.size(); p++) {
            basePage.scrollToSpecificElementOnCenter(Social_icons.get(p));
            basePage.waitAction(1000);
            basePage.javaScriptClick(Social_icons.get(p));

        }
    }
}
