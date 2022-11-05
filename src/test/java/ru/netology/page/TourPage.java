package ru.netology.page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class TourPage {

    private ElementsCollection buttons = $$("button[role='button']");

    private SelenideElement mainPage = $x("//h2[text()='Путешествие дня']");

    private SelenideElement buy = $x("//h3[contains(text(),'Оплата по карте')]");

    private SelenideElement credit = $x("//h3[contains(text(),'Кредит по данным карты')]");

    public BuyPage toBuy() {
        buttons.get(0).click();
        buy.shouldBe(Condition.visible);
        return new BuyPage();
    }

    public TourPage() {
        mainPage.shouldBe(Condition.visible);
    }

    public CreditPage toCredit() {
        buttons.get(1).click();
        credit.shouldBe(Condition.visible);
        return new CreditPage();
    }

}
