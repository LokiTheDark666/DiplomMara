package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import lombok.var;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;
import ru.netology.page.BuyPage;
import ru.netology.page.TourPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class serviceTestBuyPage {

    private TourPage tourPage = new TourPage();
    private BuyPage buyPage = new BuyPage();


    @BeforeAll
    static void setup() {
        Configuration.holdBrowserOpen = true;
        open("http://localhost:8080");
    }


    @AfterAll
    static void tearDownAll() {
        DataGenerator.cleanData();
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldTestApprovedCard() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getApprovedCard());
        buyPage.sendForm();
        buyPage.approvedMessage();
        var id = DataGenerator.getIdOperationBuyToCard();
        var status = DataGenerator.getStatusOperationBuyToCard();
        assertEquals(id, status.getTransaction_id());
        assertEquals("APPROVED", status.getStatus());
    }

    @Test
    void shouldTestDeclinedCard() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getDeclinedCard());
        buyPage.sendForm();
        buyPage.declinedMessage();
        var id = DataGenerator.getIdOperationBuyToCard();
        var status = DataGenerator.getStatusOperationBuyToCard();
        assertEquals(id, status.getTransaction_id());
        assertEquals("DECLINED", status.getStatus());
    }

    @Test
    void shouldFillFormWithLatinaInNumberCardField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getLatinaInFiledNumber());
        buyPage.sendForm();
        buyPage.wrongFormatFieldNumberCard();
    }

    @Test
    void shouldFillFormWithSymbolInNumberCardField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getSymbolInCardField());
        buyPage.sendForm();
        buyPage.wrongFormatFieldNumberCard();
    }

    @Test
    void shouldFillFormWithSpaceInNumberCardField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getSpaceInCardField());
        buyPage.sendForm();
        buyPage.emptyFieldNumberCard();
    }

    @Test
    void shouldFillFormWithoutFieldNumberCard() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getEmptyCardField());
        buyPage.sendForm();
        buyPage.emptyFieldNumberCard();
    }

    @Test
    void shouldFillFormWithWrongMonth() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getWrongMonth());
        buyPage.sendForm();
        buyPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithZeroInMonthField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getZeroMonth());
        buyPage.sendForm();
        buyPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithLatinaInMonthField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getLatinaInFieldMonth());
        buyPage.sendForm();
        buyPage.wrongFormatFieldMonth();
    }

    @Test
    void shouldFillFormWithSymbolInMonthField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getSymbolInFieldMonth());
        buyPage.sendForm();
        buyPage.wrongFormatFieldMonth();
    }

    @Test
    void shouldFillFormWithSpaceInMonthField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getSpaceInFieldMonth());
        buyPage.sendForm();
        buyPage.emptyFieldMonth();
    }

    @Test
    void shouldFillFormWithoutMonthField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getEmptyFieldMonth());
        buyPage.sendForm();
        buyPage.emptyFieldMonth();
    }

    @Test
    void shouldFillFormWithExpiredCardInMonth() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getExpiredMonth());
        buyPage.sendForm();
        buyPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithEarlierYear() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getEarlyYear());
        buyPage.sendForm();
        buyPage.cardExpiredFieldYear();
    }

    @Test
    void shouldFillFormWithLaterYear() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getLaterYear());
        buyPage.sendForm();
        buyPage.wrongPeriodYearField();
    }

    @Test
    void shouldFillFormWithLatinaInYearField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getLatinaInFieldYear());
        buyPage.sendForm();
        buyPage.wrongFormatFieldYear();
    }

    @Test
    void shouldFillFormWithSymbolInYearField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getSymbolInFieldYear());
        buyPage.sendForm();
        buyPage.wrongFormatFieldYear();
    }

    @Test
    void shouldFillFormWithSpaceInYearField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getSpaceInFieldYear());
        buyPage.sendForm();
        buyPage.emptyFieldYear();
    }

    @Test
    void shouldFillFormWithoutYearField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getEmptyFieldYear());
        buyPage.sendForm();
        buyPage.emptyFieldYear();
    }

    @Test
    void shouldFillFormWithDoubleSecondNameInNameField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getDoubleSecondName());
        buyPage.sendForm();
        buyPage.approvedMessage();
    }

    @Test
    void shouldFillFormWithLowerCaseInNameField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getLowerCaseName());
        buyPage.sendForm();
        buyPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithNameConsistTwoLetter() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getNameConsistTwoLetter());
        buyPage.sendForm();
        buyPage.approvedMessage();
    }

    @Test
    void shouldFillFormWithCirilicUpperCaseInNameField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getCirilicNameWithUpperCase());
        buyPage.sendForm();
        buyPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithCirilicLowerCaseInNameField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getCirilicNameWithLowerCase());
        buyPage.sendForm();
        buyPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithNumbersInNameField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getNumbersInFieldOwner());
        buyPage.sendForm();
        buyPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithSymbolInNameField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getSymbolInFieldOwner());
        buyPage.sendForm();
        buyPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithSpaceInNameField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getSpaceInFieldOwner());
        buyPage.sendForm();
        buyPage.emptyFieldOwner();
    }

    @Test
    void shouldFillFormWithoutNameField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getEmptyFieldOwner());
        buyPage.sendForm();
        buyPage.emptyFieldOwner();
    }

    @Test
    void shouldFillFormWithSymbolInCvcField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getSymbolInFieldCvc());
        buyPage.sendForm();
        buyPage.wrongFormatFieldCvc();
    }

    @Test
    void shouldFillFormWithLatinaInCvcField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getLatinaInFieldCvc());
        buyPage.sendForm();
        buyPage.wrongFormatFieldCvc();
    }


    @Test
    void shouldFillFormWithSpaceInCvcField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getSpaceInFieldCvc());
        buyPage.sendForm();
        buyPage.emptyFieldCvc();
    }


    @Test
    void shouldFillFormWithoutCvcField() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getEmptyFieldCvc());
        buyPage.sendForm();
        buyPage.emptyFieldCvc();
    }

    @Test
    void shouldNotFillFormFields() {
        tourPage.toBuy();
        buyPage.fillFormBuy(DataGenerator.getEmptyFormFields());
        buyPage.sendForm();
        buyPage.emptyFieldNumberCard();
        buyPage.emptyFieldMonth();
        buyPage.emptyFieldYear();
        buyPage.emptyFieldOwner();
        buyPage.emptyFieldCvc();
    }
}
