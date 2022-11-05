package ru.netology.data;

import com.github.javafaker.Faker;
import com.mysql.cj.jdbc.Driver;
import lombok.SneakyThrows;
import lombok.Value;
import lombok.val;
import lombok.var;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    public static Faker faker = new Faker(new Locale("en"));

    public static String generateCardNumber() {
        return faker.business().creditCardNumber();
    }

    public static String generateMonth() {
        int month = faker.number().numberBetween(0, 13);
        String date = LocalDate.now().plusMonths(month).format(DateTimeFormatter.ofPattern("MM"));
        return date;
    }

    public static String generateYear() {
        int year = faker.number().numberBetween(1, 6);
        String date = LocalDate.now().plusYears(year).format(DateTimeFormatter.ofPattern("yy"));
        return date;
    }

    public static String generateOwner() {
        String name = faker.name().fullName().toUpperCase();
        return name;
    }

    public static String generateCvc() {
        return faker.number().digits(3);
    }

    public static String generateSymbol() {
        return String.valueOf(faker.random().nextInt(5));
    }

    @Value
    public static class OwnerInfo {
        String number;
        String month;
        String year;
        String holder;
        String cvc;
    }

    public static OwnerInfo getApprovedCard() {
        var approvedCard = "4444 4444 4444 4441";
        return new OwnerInfo(approvedCard, generateMonth(), generateYear(), generateOwner(), generateCvc());

    }

    public static OwnerInfo getDeclinedCard() {
        var DeclinedCard = "4444 4444 4444 4442";
        return new OwnerInfo(DeclinedCard, generateMonth(), generateYear(), generateOwner(), generateCvc());

    }

    public static OwnerInfo getLatinaInFiledNumber() {
        var card = "abcdef";
        return new OwnerInfo(card, generateMonth(), generateYear(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getSymbolInCardField() {
        return new OwnerInfo(generateSymbol(), generateMonth(), generateYear(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getSpaceInCardField() {
        var card = " ";
        return new OwnerInfo(card, generateMonth(), generateYear(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getEmptyCardField() {
        var card = "";
        return new OwnerInfo(card, generateMonth(), generateYear(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getWrongMonth() {
        var wrongMonth = "13";
        return new OwnerInfo(generateCardNumber(), wrongMonth, generateYear(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getZeroMonth() {
        var wrongMonth = "00";
        return new OwnerInfo(generateCardNumber(), wrongMonth, generateYear(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getLatinaInFieldMonth() {
        var month = "abcdef";
        return new OwnerInfo(generateCardNumber(), month, generateYear(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getSymbolInFieldMonth() {
        return new OwnerInfo(generateCardNumber(), generateSymbol(), generateYear(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getSpaceInFieldMonth() {
        var month = " ";
        return new OwnerInfo(generateCardNumber(), month, generateYear(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getEmptyFieldMonth() {
        var month = "";
        return new OwnerInfo(generateCardNumber(), month, generateYear(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getExpiredMonth() {
        var month = LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
        var year = LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
        return new OwnerInfo(generateCardNumber(), month, year, generateOwner(), generateCvc());
    }

    public static OwnerInfo getEarlyYear() {
        var earlyYear = LocalDate.now().minusYears(2).format(DateTimeFormatter.ofPattern("yy"));
        return new OwnerInfo(generateCardNumber(), generateMonth(), earlyYear, generateOwner(), generateCvc());
    }

    public static OwnerInfo getLaterYear() {
        var laterYear = LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy"));
        return new OwnerInfo(generateCardNumber(), generateMonth(), laterYear, generateOwner(), generateCvc());
    }

    public static OwnerInfo getLatinaInFieldYear() {
        var year = "abcdef";
        return new OwnerInfo(generateCardNumber(), generateMonth(), year, generateOwner(), generateCvc());
    }

    public static OwnerInfo getSymbolInFieldYear() {
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateSymbol(), generateOwner(), generateCvc());
    }

    public static OwnerInfo getSpaceInFieldYear() {
        var year = " ";
        return new OwnerInfo(generateCardNumber(), generateMonth(), year, generateOwner(), generateCvc());
    }

    public static OwnerInfo getEmptyFieldYear() {
        var year = "";
        return new OwnerInfo(generateCardNumber(), generateMonth(), year, generateOwner(), generateCvc());
    }

    public static OwnerInfo getDoubleSecondName() {
        var owner = "SEMENOV-IVANOV OLEG";
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), owner, generateCvc());
    }

    public static OwnerInfo getLowerCaseName() {
        var owner = faker.name().fullName().toLowerCase();
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), owner, generateCvc());
    }

    public static OwnerInfo getNameConsistTwoLetter() {
        var owner = "SVIRIDOV EL";
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), owner, generateCvc());
    }

    public static OwnerInfo getCirilicNameWithUpperCase() {
        Faker faker = new Faker(new Locale("ru"));
        var owner = faker.name().fullName().toUpperCase();
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), owner, generateCvc());
    }

    public static OwnerInfo getCirilicNameWithLowerCase() {
        Faker faker = new Faker(new Locale("ru"));
        var owner = faker.name().fullName().toLowerCase();
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), owner, generateCvc());
    }

    public static OwnerInfo getNumbersInFieldOwner() {
        var owner = faker.number().digits(4);
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), owner, generateCvc());
    }

    public static OwnerInfo getSymbolInFieldOwner() {
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), generateSymbol(), generateCvc());
    }

    public static OwnerInfo getSpaceInFieldOwner() {
        var owner = " ";
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), owner, generateCvc());
    }

    public static OwnerInfo getEmptyFieldOwner() {
        var owner = "";
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), owner, generateCvc());
    }

    public static OwnerInfo getSymbolInFieldCvc() {
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), generateOwner(), generateSymbol());
    }

    public static OwnerInfo getLatinaInFieldCvc() {
        var cvc = "abcdef";
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), generateOwner(), cvc);
    }

    public static OwnerInfo getSpaceInFieldCvc() {
        var cvc = " ";
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), generateOwner(), cvc);
    }

    public static OwnerInfo getEmptyFieldCvc() {
        var cvc = "";
        return new OwnerInfo(generateCardNumber(), generateMonth(), generateYear(), generateOwner(), cvc);
    }

    public static OwnerInfo getEmptyFormFields() {
        var card = "";
        var month = "";
        var year = "";
        var owner = "";
        var cvc = "";
        return new OwnerInfo(card, month, year, owner, cvc);
    }

    private static Connection connection;

    public static Connection getConnection() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.postgresql.cj.jdbc.Driver"); Для использования драйвера postgresql
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/app", "app", "pass"
            ); // Соответственно используем этот "jdbc:postgresql://localhost:5432/app" url для использования postgresql БД
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @SneakyThrows
    public static Payment getStatusOperationBuyToCard() {
        var runner = new QueryRunner();
        var getStatus = "SELECT status, transaction_id  FROM payment_entity ORDER BY created DESC LIMIT 1";
        try (Connection connection = getConnection()) {
            val transactionId = runner.query(connection, getStatus, new BeanHandler<>(Payment.class));
            return transactionId;
        }
    }

    @SneakyThrows
    public static String getIdOperationBuyToCard() {
        var runner = new QueryRunner();
        val getId = "SELECT payment_id FROM order_entity ORDER BY created DESC LIMIT 1";
        try (Connection connection = getConnection()) {
            return runner.query(connection, getId, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static String getIdOperationBuyInCredit() {
        var runner = new QueryRunner();
        var getId = "SELECT credit_id FROM order_entity ORDER BY created DESC LIMIT 1";
        try (Connection connection = getConnection()) {
            return runner.query(connection, getId, new ScalarHandler<>());
        }
    }

    @SneakyThrows
    public static CreditRequest getStatusOperationBuyInCredit() {
        var runner = new QueryRunner();
        var getStatus = "SELECT status, bank_id  FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        try (Connection connection = getConnection()) {
            val bank_id = runner.query(connection, getStatus, new BeanHandler<>(CreditRequest.class));
            return bank_id;
        }
    }

    @SneakyThrows
    public static void cleanData() {
        val runner = new QueryRunner();
        val order = "DELETE FROM order_entity";
        val payment = "DELETE FROM payment_entity";
        val creditRequest = "DELETE FROM credit_request_entity";
        try (Connection connection = getConnection()) {
            runner.update(connection, order);
            runner.update(connection, payment);
            runner.update(connection, creditRequest);
        }
    }
}
