# DiplomMara

## Начало работы:

- В терминале прописываем команду docker-compose up -d;

1. Для запуска MySQL:


- Для запуска SUT выполнить команду: java -jar artifacts/aqa-shop.jar -P:jdbc.url=jdbc:mysql://192.168.99.100:3306/app -P:jdbc.user=app -P:jdbc.password=pass
- Для запуска тестов на исполнение в терминале выполнить команду: gradlew test


2. Для запуска Postgres:

- Для запуска SUT выполнить команду: java -Dspring.datasource.url=jdbc:postgresql://192.168.99.100:5432/app -jar artifacts/aqa-shop.jar
- Для запуска тестов на исполнение в терминале выполнить команду:gradlew -Ddb.url=jdbc:postgresql://192.168.99.100:5432/app test
