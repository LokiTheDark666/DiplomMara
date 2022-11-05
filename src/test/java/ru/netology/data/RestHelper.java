package ru.netology.data;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import lombok.experimental.UtilityClass;

import static io.restassured.RestAssured.given;

@UtilityClass
public class RestHelper {

    public String pathBuyPage = "/api/v1/pay";
    public String pathCreditPage = "/api/v1/credit";

    private RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("http://localhost")
            .setPort(8080)
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public static String sendFormBuy(DataGenerator.OwnerInfo cards) {
        return given()
                .spec(requestSpec)
                .body(cards)
                .when()
                .post(pathBuyPage)
                .then()
                .statusCode(200)
                .extract().response().asString();
    }

    public static String sendFormCredit(DataGenerator.OwnerInfo cards) {
        return given()
                .spec(requestSpec)
                .body(cards)
                .when()
                .post(pathCreditPage)
                .then()
                .statusCode(200)
                .extract().response().asString();
    }
}
