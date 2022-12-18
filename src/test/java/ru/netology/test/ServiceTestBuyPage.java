package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;
import ru.netology.page.BuyPage;
import ru.netology.page.TourPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTestBuyPage {

    private TourPage tourPage;
    private BuyPage buyPage;


    @BeforeAll
    static void setupAll() {
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
        tourPage = new TourPage();
        buyPage = tourPage.toBuy();
    }


    @AfterAll
    static void tearDownAll() {
        DataGenerator.cleanData();
    }

    @Test
    void shouldTestApprovedCard() {

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

        buyPage.fillFormBuy(DataGenerator.getLatinaInFiledNumber());
        buyPage.sendForm();
        buyPage.wrongFormatFieldNumberCard();
    }

    @Test
    void shouldFillFormWithSymbolInNumberCardField() {

        buyPage.fillFormBuy(DataGenerator.getSymbolInCardField());
        buyPage.sendForm();
        buyPage.wrongFormatFieldNumberCard();
    }

    @Test
    void shouldFillFormWithSpaceInNumberCardField() {

        buyPage.fillFormBuy(DataGenerator.getSpaceInCardField());
        buyPage.sendForm();
        buyPage.emptyFieldNumberCard();
    }

    @Test
    void shouldFillFormWithoutFieldNumberCard() {

        buyPage.fillFormBuy(DataGenerator.getEmptyCardField());
        buyPage.sendForm();
        buyPage.emptyFieldNumberCard();
    }

    @Test
    void shouldFillFormWithWrongMonth() {

        buyPage.fillFormBuy(DataGenerator.getWrongMonth());
        buyPage.sendForm();
        buyPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithZeroInMonthField() {

        buyPage.fillFormBuy(DataGenerator.getZeroMonth());
        buyPage.sendForm();
        buyPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithLatinaInMonthField() {

        buyPage.fillFormBuy(DataGenerator.getLatinaInFieldMonth());
        buyPage.sendForm();
        buyPage.wrongFormatFieldMonth();
    }

    @Test
    void shouldFillFormWithSymbolInMonthField() {

        buyPage.fillFormBuy(DataGenerator.getSymbolInFieldMonth());
        buyPage.sendForm();
        buyPage.wrongFormatFieldMonth();
    }

    @Test
    void shouldFillFormWithSpaceInMonthField() {

        buyPage.fillFormBuy(DataGenerator.getSpaceInFieldMonth());
        buyPage.sendForm();
        buyPage.emptyFieldMonth();
    }

    @Test
    void shouldFillFormWithoutMonthField() {

        buyPage.fillFormBuy(DataGenerator.getEmptyFieldMonth());
        buyPage.sendForm();
        buyPage.emptyFieldMonth();
    }

    @Test
    void shouldFillFormWithExpiredCardInMonth() {

        buyPage.fillFormBuy(DataGenerator.getExpiredMonth());
        buyPage.sendForm();
        buyPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithEarlierYear() {

        buyPage.fillFormBuy(DataGenerator.getEarlyYear());
        buyPage.sendForm();
        buyPage.cardExpiredFieldYear();
    }

    @Test
    void shouldFillFormWithLaterYear() {

        buyPage.fillFormBuy(DataGenerator.getLaterYear());
        buyPage.sendForm();
        buyPage.wrongPeriodYearField();
    }

    @Test
    void shouldFillFormWithLatinaInYearField() {

        buyPage.fillFormBuy(DataGenerator.getLatinaInFieldYear());
        buyPage.sendForm();
        buyPage.wrongFormatFieldYear();
    }

    @Test
    void shouldFillFormWithSymbolInYearField() {

        buyPage.fillFormBuy(DataGenerator.getSymbolInFieldYear());
        buyPage.sendForm();
        buyPage.wrongFormatFieldYear();
    }

    @Test
    void shouldFillFormWithSpaceInYearField() {

        buyPage.fillFormBuy(DataGenerator.getSpaceInFieldYear());
        buyPage.sendForm();
        buyPage.emptyFieldYear();
    }

    @Test
    void shouldFillFormWithoutYearField() {

        buyPage.fillFormBuy(DataGenerator.getEmptyFieldYear());
        buyPage.sendForm();
        buyPage.emptyFieldYear();
    }

    @Test
    void shouldFillFormWithDoubleSecondNameInNameField() {

        buyPage.fillFormBuy(DataGenerator.getDoubleSecondName());
        buyPage.sendForm();
        buyPage.approvedMessage();
    }

    @Test
    void shouldFillFormWithLowerCaseInNameField() {

        buyPage.fillFormBuy(DataGenerator.getLowerCaseName());
        buyPage.sendForm();
        buyPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithNameConsistTwoLetter() {

        buyPage.fillFormBuy(DataGenerator.getNameConsistTwoLetter());
        buyPage.sendForm();
        buyPage.approvedMessage();
    }

    @Test
    void shouldFillFormWithCirilicUpperCaseInNameField() {

        buyPage.fillFormBuy(DataGenerator.getCirilicNameWithUpperCase());
        buyPage.sendForm();
        buyPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithCirilicLowerCaseInNameField() {

        buyPage.fillFormBuy(DataGenerator.getCirilicNameWithLowerCase());
        buyPage.sendForm();
        buyPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithNumbersInNameField() {

        buyPage.fillFormBuy(DataGenerator.getNumbersInFieldOwner());
        buyPage.sendForm();
        buyPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithSymbolInNameField() {

        buyPage.fillFormBuy(DataGenerator.getSymbolInFieldOwner());
        buyPage.sendForm();
        buyPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithSpaceInNameField() {

        buyPage.fillFormBuy(DataGenerator.getSpaceInFieldOwner());
        buyPage.sendForm();
        buyPage.emptyFieldOwner();
    }

    @Test
    void shouldFillFormWithoutNameField() {

        buyPage.fillFormBuy(DataGenerator.getEmptyFieldOwner());
        buyPage.sendForm();
        buyPage.emptyFieldOwner();
    }

    @Test
    void shouldFillFormWithSymbolInCvcField() {

        buyPage.fillFormBuy(DataGenerator.getSymbolInFieldCvc());
        buyPage.sendForm();
        buyPage.wrongFormatFieldCvc();
    }

    @Test
    void shouldFillFormWithLatinaInCvcField() {

        buyPage.fillFormBuy(DataGenerator.getLatinaInFieldCvc());
        buyPage.sendForm();
        buyPage.wrongFormatFieldCvc();
    }


    @Test
    void shouldFillFormWithSpaceInCvcField() {

        buyPage.fillFormBuy(DataGenerator.getSpaceInFieldCvc());
        buyPage.sendForm();
        buyPage.emptyFieldCvc();
    }


    @Test
    void shouldFillFormWithoutCvcField() {

        buyPage.fillFormBuy(DataGenerator.getEmptyFieldCvc());
        buyPage.sendForm();
        buyPage.emptyFieldCvc();
    }

    @Test
    void shouldNotFillFormFields() {

        buyPage.fillFormBuy(DataGenerator.getEmptyFormFields());
        buyPage.sendForm();
        buyPage.emptyFieldNumberCard();
        buyPage.emptyFieldMonth();
        buyPage.emptyFieldYear();
        buyPage.emptyFieldOwner();
        buyPage.emptyFieldCvc();
    }
}
