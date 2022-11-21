package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.var;
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

    private final TourPage tourPage = new TourPage();
    private final CreditPage creditPage = new CreditPage();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setup() {
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
        tourPage.toCredit();
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
        tourPage.toCredit();
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
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getLatinaInFiledNumber());
        creditPage.sendForm();
        creditPage.wrongFormatFieldNumberCard();
    }

    @Test
    void shouldFillFormWithSymbolInNumberCardField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getSymbolInCardField());
        creditPage.sendForm();
        creditPage.wrongFormatFieldNumberCard();
    }

    @Test
    void shouldFillFormWithSpaceInNumberCardField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getSpaceInCardField());
        creditPage.sendForm();
        creditPage.emptyFieldNumberCard();
    }

    @Test
    void shouldFillFormWithoutFieldNumberCard() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getEmptyCardField());
        creditPage.sendForm();
        creditPage.emptyFieldNumberCard();
    }

    @Test
    void shouldFillFormWithWrongMonth() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getWrongMonth());
        creditPage.sendForm();
        creditPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithZeroInMonthField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getZeroMonth());
        creditPage.sendForm();
        creditPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithLatinaInMonthField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getLatinaInFieldMonth());
        creditPage.sendForm();
        creditPage.wrongFormatFieldMonth();
    }

    @Test
    void shouldFillFormWithSymbolInMonthField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getSymbolInFieldMonth());
        creditPage.sendForm();
        creditPage.wrongFormatFieldMonth();
    }

    @Test
    void shouldFillFormWithSpaceInMonthField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getSpaceInFieldMonth());
        creditPage.sendForm();
        creditPage.emptyFieldMonth();
    }

    @Test
    void shouldFillFormWithoutMonthField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getEmptyFieldMonth());
        creditPage.sendForm();
        creditPage.emptyFieldMonth();
    }

    @Test
    void shouldFillFormWithExpiredCardInMonth() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getExpiredMonth());
        creditPage.sendForm();
        creditPage.wrongPeriodMonthField();
    }

    @Test
    void shouldFillFormWithEarlierYear() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getEarlyYear());
        creditPage.sendForm();
        creditPage.cardExpiredFieldYear();
    }

    @Test
    void shouldFillFormWithLaterYear() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getLaterYear());
        creditPage.sendForm();
        creditPage.wrongPeriodYearField();
    }

    @Test
    void shouldFillFormWithLatinaInYearField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getLatinaInFieldYear());
        creditPage.sendForm();
        creditPage.wrongFormatFieldYear();
    }

    @Test
    void shouldFillFormWithSymbolInYearField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getSymbolInFieldYear());
        creditPage.sendForm();
        creditPage.wrongFormatFieldYear();
    }

    @Test
    void shouldFillFormWithSpaceInYearField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getSpaceInFieldYear());
        creditPage.sendForm();
        creditPage.emptyFieldYear();
    }

    @Test
    void shouldFillFormWithoutYearField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getEmptyFieldYear());
        creditPage.sendForm();
        creditPage.emptyFieldYear();
    }

    @Test
    void shouldFillFormWithDoubleSecondNameInNameField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getDoubleSecondName());
        creditPage.sendForm();
        creditPage.approvedMessage();
    }

    @Test
    void shouldFillFormWithLowerCaseInNameField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getLowerCaseName());
        creditPage.sendForm();
        creditPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithNameConsistTwoLetter() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getNameConsistTwoLetter());
        creditPage.sendForm();
        creditPage.approvedMessage();
    }

    @Test
    void shouldFillFormWithCirilicUpperCaseInNameField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getCirilicNameWithUpperCase());
        creditPage.sendForm();
        creditPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithCirilicLowerCaseInNameField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getCirilicNameWithLowerCase());
        creditPage.sendForm();
        creditPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithNumbersInNameField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getNumbersInFieldOwner());
        creditPage.sendForm();
        creditPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithSymbolInNameField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getSymbolInFieldOwner());
        creditPage.sendForm();
        creditPage.wrongFormatFieldOwner();
    }

    @Test
    void shouldFillFormWithSpaceInNameField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getSpaceInFieldOwner());
        creditPage.sendForm();
        creditPage.emptyFieldOwner();
    }

    @Test
    void shouldFillFormWithoutNameField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getEmptyFieldOwner());
        creditPage.sendForm();
        creditPage.emptyFieldOwner();
    }

    @Test
    void shouldFillFormWithSymbolInCvcField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getSymbolInFieldCvc());
        creditPage.sendForm();
        creditPage.wrongFormatFieldCvc();
    }

    @Test
    void shouldFillFormWithLatinaInCvcField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getLatinaInFieldCvc());
        creditPage.sendForm();
        creditPage.wrongFormatFieldCvc();
    }

    @Test
    void shouldFillFormWithSpaceInCvcField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getSpaceInFieldCvc());
        creditPage.sendForm();
        creditPage.emptyFieldCvc();
    }

    @Test
    void shouldFillFormWithoutCvcField() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getEmptyFieldCvc());
        creditPage.sendForm();
        creditPage.emptyFieldCvc();
    }

    @Test
    void shouldNotFillFormFields() {
        tourPage.toCredit();
        creditPage.fillFormCredit(DataGenerator.getEmptyFormFields());
        creditPage.sendForm();
        creditPage.emptyFieldNumberCard();
        creditPage.emptyFieldMonth();
        creditPage.emptyFieldYear();
        creditPage.emptyFieldOwner();
        creditPage.emptyFieldCvc();
    }
}
