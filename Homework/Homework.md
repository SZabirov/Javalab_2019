# HW

## 06. Скачивание файлов

Приложение, которое на вход принимает набор ссылок на файлы в Интернете и скачивает каждый файл в отдельном потоке. Приложение должно представлять собой jar-архив. Аргументы (ссылки) передаются в командной строке при запуске jar'ника

## 07. Maven

Установить maven.
Перевести проект для скачивания файлов в maven-проект (структура папок + pom.xml конфигурация).  Установить в локальный maven-репозиторий
Создать второй mvn-проект, который будет использовать приложение для скачивания файлов в качестве зависимости. 
Почитать: maven lifecycle, знать фазы сборки и maven-плагины.
Ссылки с занятия: 
https://maven.apache.org/guides/introduction/introduction-to-the-pom.html
https://maven.apache.org/shared/maven-archiver/examples/classpath.html
https://stackoverflow.com/questions/574594/how-can-i-create-an-executable-jar-with-dependencies-using-maven

## 08. Servlets

Страница, которая принимает url'ы до файлов (через форму). Отправляем url'ы -> скачиваются файлы (на сервер). Скачивание выполняется с использванием библиотеки, которую реализовали ранее.
Фильтр, который логирует запросы: время, метод, адрес. (ip - опционально)