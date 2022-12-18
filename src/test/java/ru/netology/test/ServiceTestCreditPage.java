package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;
import ru.netology.page.CreditPage;
import ru.netology.page.TourPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTestCreditPage {

    private TourPage tourPage;
    private CreditPage creditPage;

    @BeforeAll
    static void setupAll() {
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
        tourPage = new TourPage();
        creditPage = tourPage.toCredit();
    }

    @AfterAll
    static void tearDownAll() {
        DataGenerator.cleanData();
    }

    @Test
    void shouldTestApprovedCard() {

        creditPage.fillFormCredit(DataGenerator.getApprovedCard());
        creditPage.sendForm();
        creditPage.approvedMessage();
        var id = DataGenerator.getIdOperationBuyInCredit();
        var status = DataGenerator.getStatusOperationBuyInCredit();
        assertEquals(id, status.getBank_id());
        assertEquals("APPROVED", status.getStatus());
    }

    @Test
    void shouldTestDeclinedCard() {

        creditPage.fillFormCredit(DataGenerator.getDeclinedCard());
        creditPage.sendForm();
        creditPage.declinedMessage();
        var id = DataGenerator.getIdOperationBuyInCredit();
        var status = DataGenerator.getStatusOperationBuyInCredit();
        assertEquals(id, status.getBank_id());
        assertEquals("DECLINED", status.getStatus());
    }

    @Test
    void shouldFillFormWithLatinaInNumberCardField() {

        creditPage.fillFormCredit(DataGenerator.getLatinaInFiledNumber());
        creditPage.sendForm();
        creditPage.wrongFormatFieldNumberCard();
    }

    @Test
    void shouldFillFormWithSymbolInNumberCardField() {

        creditPage.fillFormCredit(DataGenerator.getSymbolInCardField());
        creditPage.sendForm();
        creditPage.wrongFormatFieldNumberCard();
    }

    @Test
    void shouldFillFormWithSpaceInNumberCardField() {

        creditPage.fillFormCredit(DataGenerator.getSpaceInCardField());
        creditPage.sendForm();
        creditPage.emptyFieldNumberCard();
    }

    @Test
    void shouldFillFormWithoutFieldNumberCard() {

        creditPage.fillFormCredit(DataGenerator.getEmptyCardField());
        creditPage.sendForm();
        creditPage.emptyFieldNumberCard();
    }

    @Test
    void shouldFillFormWithWrongMonth() {

        creditPage.fillFormCredit(DataGenerator.getWrongMonth());
        creditPage.sendForm();
        creditPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithZeroInMonthField() {

        creditPage.fillFormCredit(DataGenerator.getZeroMonth());
        creditPage.sendForm();
        creditPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithLatinaInMonthField() {

        creditPage.fillFormCredit(DataGenerator.getLatinaInFieldMonth());
        creditPage.sendForm();
        creditPage.wrongFormatFieldMonth();
    }

    @Test
    void shouldFillFormWithSymbolInMonthField() {

        creditPage.fillFormCredit(DataGenerator.getSymbolInFieldMonth());
        creditPage.sendForm();
        creditPage.wrongFormatFieldMonth();
    }

    @Test
    void shouldFillFormWithSpaceInMonthField() {

        creditPage.fillFormCredit(DataGenerator.getSpaceInFieldMonth());
        creditPage.sendForm();
        creditPage.emptyFieldMonth();
    }

    @Test
    void shouldFillFormWithoutMonthField() {

        creditPage.fillFormCredit(DataGenerator.getEmptyFieldMonth());
        creditPage.sendForm();
        creditPage.emptyFieldMonth();
    }

    @Test
    void shouldFillFormWithExpiredCardInMonth() {

        creditPage.fillFormCredit(DataGenerator.getExpiredMonth());
        creditPage.sendForm();
        creditPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithEarlierYear() {

        creditPage.fillFormCredit(DataGenerator.getEarlyYear());
        creditPage.sendForm();
        creditPage.cardExpiredFieldYear();
    }

    @Test
    void shouldFillFormWithLaterYear() {

        creditPage.fillFormCredit(DataGenerator.getLaterYear());
        creditPage.sendForm();
        creditPage.wrongPeriodYearField();
    }

    @Test
    void shouldFillFormWithLatinaInYearField() {

        creditPage.fillFormCredit(DataGenerator.getLatinaInFieldYear());
        creditPage.sendForm();
        creditPage.wrongFormatFieldYear();
    }

    @Test
    void shouldFillFormWithSymbolInYearField() {

        creditPage.fillFormCredit(DataGenerator.getSymbolInFieldYear());
        creditPage.sendForm();
        creditPage.wrongFormatFieldYear();
    }

    @Test
    void shouldFillFormWithSpaceInYearField() {

        creditPage.fillFormCredit(DataGenerator.getSpaceInFieldYear());
        creditPage.sendForm();
        creditPage.emptyFieldYear();
    }

    @Test
    void shouldFillFormWithoutYearField() {

        creditPage.fillFormCredit(DataGenerator.getEmptyFieldYear());
        creditPage.sendForm();
        creditPage.emptyFieldYear();
    }

    @Test
    void shouldFillFormWithDoubleSecondNameInNameField() {

        creditPage.fillFormCredit(DataGenerator.getDoubleSecondName());
        creditPage.sendForm();
        creditPage.approvedMessage();
    }

    @Test
    void shouldFillFormWithLowerCaseInNameField() {

        creditPage.fillFormCredit(DataGenerator.getLowerCaseName());
        creditPage.sendForm();
        creditPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithNameConsistTwoLetter() {

        creditPage.fillFormCredit(DataGenerator.getNameConsistTwoLetter());
        creditPage.sendForm();
        creditPage.approvedMessage();
    }

    @Test
    void shouldFillFormWithCirilicUpperCaseInNameField() {

        creditPage.fillFormCredit(DataGenerator.getCirilicNameWithUpperCase());
        creditPage.sendForm();
        creditPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithCirilicLowerCaseInNameField() {

        creditPage.fillFormCredit(DataGenerator.getCirilicNameWithLowerCase());
        creditPage.sendForm();
        creditPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithNumbersInNameField() {

        creditPage.fillFormCredit(DataGenerator.getNumbersInFieldOwner());
        creditPage.sendForm();
        creditPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithSymbolInNameField() {

        creditPage.fillFormCredit(DataGenerator.getSymbolInFieldOwner());
        creditPage.sendForm();
        creditPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithSpaceInNameField() {

        creditPage.fillFormCredit(DataGenerator.getSpaceInFieldOwner());
        creditPage.sendForm();
        creditPage.emptyFieldOwner();
    }

    @Test
    void shouldFillFormWithoutNameField() {

        creditPage.fillFormCredit(DataGenerator.getEmptyFieldOwner());
        creditPage.sendForm();
        creditPage.emptyFieldOwner();
    }

    @Test
    void shouldFillFormWithSymbolInCvcField() {

        creditPage.fillFormCredit(DataGenerator.getSymbolInFieldCvc());
        creditPage.sendForm();
        creditPage.wrongFormatFieldCvc();
    }

    @Test
    void shouldFillFormWithLatinaInCvcField() {

        creditPage.fillFormCredit(DataGenerator.getLatinaInFieldCvc());
        creditPage.sendForm();
        creditPage.wrongFormatFieldCvc();
    }

    @Test
    void shouldFillFormWithSpaceInCvcField() {

        creditPage.fillFormCredit(DataGenerator.getSpaceInFieldCvc());
        creditPage.sendForm();
        creditPage.emptyFieldCvc();
    }

    @Test
    void shouldFillFormWithoutCvcField() {

        creditPage.fillFormCredit(DataGenerator.getEmptyFieldCvc());
        creditPage.sendForm();
        creditPage.emptyFieldCvc();
    }

    @Test
    void shouldNotFillFormFields() {

        creditPage.fillFormCredit(DataGenerator.getEmptyFormFields());
        creditPage.sendForm();
        creditPage.emptyFieldNumberCard();
        creditPage.emptyFieldMonth();
        creditPage.emptyFieldYear();
        creditPage.emptyFieldOwner();
        creditPage.emptyFieldCvc();
    }
}
