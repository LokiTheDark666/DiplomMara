package ru.netology.test;

import lombok.val;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.assertTrue;//
import static ru.netology.data.DataGenerator.getApprovedCard;
import static ru.netology.data.DataGenerator.getDeclinedCard;
import static ru.netology.data.RestHelper.sendFormBuy;
import static ru.netology.data.RestHelper.sendFormCredit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiServiceTest {

    @Test
    public void shouldGetStatusValidApprovedCardBuy() {
        val validApprovedCard = getApprovedCard();
        val status = sendFormBuy(validApprovedCard);
       //assertTrue(status.contains("APPROVED"));//
        assertEquals(true, status.contains("APPROVED"));

    }

    @Test
    public void shouldGetStatusValidApprovedCredit() {
        val validApprovedCard = getApprovedCard();
        val status = sendFormCredit(validApprovedCard);
       // assertTrue(status.contains("APPROVED"));//
        assertEquals(true, status.contains("APPROVED"));
    }

    @Test
    public void shouldGetStatusValidDeclinedCardBuy() {
        val validDeclinedCard = getDeclinedCard();
        val status = sendFormBuy(validDeclinedCard);
       // assertTrue(status.contains("DECLINED"));//
        assertEquals(true, status.contains("DECLINED"));
    }

    @Test
    public void shouldGetStatusValidDeclinedCredit() {
        val validDeclinedCard = getDeclinedCard();
        val status = sendFormCredit(validDeclinedCard);
        assertEquals(true, status.contains("DECLINED"));
    }
}
