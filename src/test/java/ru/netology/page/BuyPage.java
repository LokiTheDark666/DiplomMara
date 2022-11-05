package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Selenide.*;

public class BuyPage {

    private SelenideElement numberCard = $("input[placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $("input[placeholder='08']");
    private SelenideElement year = $("input[placeholder='22']");
    private ElementsCollection owner = $$("input[class='input__control']");
    private ElementsCollection cvc = $$("input[class='input__control']");

    private ElementsCollection buttons = $$("button[role='button']");

    private SelenideElement messageSuccess = $x("//div[contains(text(),'Успешно')]");
    private SelenideElement messageApproved = $x("//div[contains(text(),'Операция одобрена Банком')]");
    private SelenideElement messageFailure = $x("//*[text()='Ошибка']");
    private SelenideElement messageDeclined = $x("//div[contains(text(),'Ошибка! Банк отказал в проведении операции')]");

    private SelenideElement numberCardError = $x("//span[contains(text(),'Номер карты')]").parent().$(".input__sub");
    private SelenideElement monthError = $x("//span[contains(text(),'Месяц')]").parent().$(".input__sub");
    private SelenideElement yearError = $x("//span[contains(text(),'Год')]").parent().$(".input__sub");
    private SelenideElement ownerError = $x("//span[contains(text(),'Владелец')]").parent().$(".input__sub");
    private SelenideElement cvcError = $x("//span[contains(text(),'CVC/CVV')]").parent().$(".input__sub");

    public void declinedMessage() {
        messageFailure.shouldBe(Condition.visible);
        messageDeclined.shouldBe(Condition.visible);
    }

    public void approvedMessage() {
        messageSuccess.shouldBe(Condition.visible);
        messageApproved.shouldBe(Condition.visible);
    }

    public void sendForm() {
        buttons.get(2).click();
    }

    public void emptyFieldNumberCard() {
        numberCardError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void wrongFormatFieldNumberCard() {
        numberCardError.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void emptyFieldMonth() {
        monthError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void wrongFormatFieldMonth() {
        monthError.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void wrongPeriodMonthField() {
        monthError.shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void emptyFieldYear() {
        yearError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void wrongFormatFieldYear() {
        yearError.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void wrongPeriodYearField() {
        yearError.shouldHave(Condition.exactText("Неверно указан срок действия карты"));
    }

    public void cardExpiredFieldYear() {
        yearError.shouldHave(Condition.exactText("Истёк срок действия карты"));
    }

    public void emptyFieldOwner() {
        ownerError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void wrongFormatFieldOwner() {
        ownerError.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void emptyFieldCvc() {
        cvcError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
    }

    public void wrongFormatFieldCvc() {
        cvcError.shouldHave(Condition.exactText("Неверный формат"));
    }

    public void fillFormBuy(DataGenerator.OwnerInfo ownerInfo) {
        numberCard.sendKeys(ownerInfo.getNumber());
        month.setValue(ownerInfo.getMonth());
        year.setValue(ownerInfo.getYear());
        owner.get(3).val(ownerInfo.getHolder());
        cvc.get(4).val(ownerInfo.getCvc());
    }

}
