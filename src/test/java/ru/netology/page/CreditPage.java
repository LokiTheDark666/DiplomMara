package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataGenerator;

import static com.codeborne.selenide.Selenide.*;

public class CreditPage {

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

    public void fillFormCredit(DataGenerator.OwnerInfo ownerInfo) {
        numberCard.sendKeys(ownerInfo.getNumber());
        month.setValue(ownerInfo.getMonth());
        year.setValue(ownerInfo.getYear());
        owner.get(3).val(ownerInfo.getHolder());
        cvc.get(4).val(ownerInfo.getCvc());
    }

    public void sendForm() {
        buttons.get(2).click();
    }

    public void declinedMessage() {
        messageFailure.waitUntil(Condition.visible, 15000);
        messageDeclined.waitUntil(Condition.visible, 15000);
    }

    public void approvedMessage() {
        messageSuccess.waitUntil(Condition.visible, 15000);
        messageApproved.waitUntil(Condition.visible, 15000);
    }

    public void emptyFieldNumberCard() {
        numberCardError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
        numberCardError.waitUntil(Condition.visible,1500);
    }

    public void wrongFormatFieldNumberCard() {
        numberCardError.shouldHave(Condition.exactText("Неверный формат"));
        numberCardError.waitUntil(Condition.visible,1500);
    }

    public void emptyFieldMonth() {
        monthError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
        monthError.waitUntil(Condition.visible,1500);
    }

    public void wrongFormatFieldMonth() {
        monthError.shouldHave(Condition.exactText("Неверный формат"));
        monthError.waitUntil(Condition.visible,1500);
    }

    public void wrongPeriodMonthField() {
        monthError.shouldHave(Condition.exactText("Неверно указан срок действия карты"));
        monthError.waitUntil(Condition.visible,1500);
    }

    public void emptyFieldYear() {
        yearError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
        yearError.waitUntil(Condition.visible,1500);
    }

    public void wrongFormatFieldYear() {
        yearError.shouldHave(Condition.exactText("Неверный формат"));
        yearError.waitUntil(Condition.visible,1500);
    }

    public void wrongPeriodYearField() {
        yearError.shouldHave(Condition.exactText("Неверно указан срок действия карты"));
        yearError.waitUntil(Condition.visible,1500);
    }

    public void cardExpiredFieldYear() {
        yearError.shouldHave(Condition.exactText("Истек срок действия карты"));
        yearError.waitUntil(Condition.visible,1500);
    }

    public void emptyFieldOwner() {
        ownerError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
        ownerError.waitUntil(Condition.visible,1500);
    }

    public void wrongFormatFieldOwner() {
        ownerError.shouldHave(Condition.exactText("Неверный формат"));
        ownerError.waitUntil(Condition.visible,1500);
    }

    public void emptyFieldCvc() {
        cvcError.shouldHave(Condition.exactText("Поле обязательно для заполнения"));
        cvcError.waitUntil(Condition.visible,1500);
    }

    public void wrongFormatFieldCvc() {
        cvcError.shouldHave(Condition.exactText("Неверный формат"));
        cvcError.waitUntil(Condition.visible,1500);
    }
}
