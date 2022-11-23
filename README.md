# Country web service

Данный проект - это веб-сервис, который раз в полчаса выгружает данные с публичного 
SOAP API(https://documenter.getpostman.com/view/8854915/Szf26WHn#96a53688-6305-45be-ab8b-ca1d1c88f830), и записывает в базу данных.

# Используемые технологии

* Spring Boot
* PostgreSQL
* Gradle

Для запуска необходимо в корневой папке выполнить команду ```gradle build```, и по появившемуся пути 'build/libs/' будет создан исполняемый .jar файл.
