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

## 09. Sockets

Первое приложение (сервер):
`java -jar chat-server.jar --port=6000 --db-properties-path=C:/myJava/db.properties`

Второе приложение (клиент):
`java -jar chat-client.jar --server-ip=127.0.0.1 --server-port=6000`

Файл `db.properties` хранит информацию для подключения к бд
Содержимое файла:
```
user: postgres
password: postgres
port: 5432
url: jdbc://
```

В бд есть таблица, в которую должны записываться
1) Логин пользователя и пароль
2) В отдельную таблицу записываем id того, кто
прислал сообщение, дата+время, текст сообщения

## 10. JSON

1) Реализовать взаимодействие по следующему протоколу + шифрование паролей

```JSON
{
	"header" : "ЗАГОЛОВОК",
	"payload": {
		...
	}
}

header - "Login", "Logout", "Message", "Command"

message:

{
	"header": "Login",
	"payload": {
		"email" : "sidikov.marsel@gmail.com",
		"password": "qwerty007"
	}
}
```

2) Реализовать функцию пагинации по сообщениям (использовать limit-offset в SQL)

```JSON
{
	"header": "Command",
	"payload": {
		"command" : "get messages",
		"page" : 3,
		"size" : 5
	}
}
```

Ответом на данную команду станет сообщение от сервера:

```JSON
{
	"data": [{
		{
			"id" : ...,
			"text": ...,
			...
		}]
	}
}
```

## 11. JWT

1. Изучить [base64](https://ru.wikipedia.org/wiki/Base64), [JWT](https://jwt.io/) 
2. Токен должен хранить id и роль пользователя
3. В чате пользователь может покупать товары и смотреть список, администратор 
может добавлять и удалять товары
4. ClientHandler должен в запросе получать токен, проверять его валидность и роль, 
далее передавать в соответствующий сервис.
5. Для работы с JWT можно использовать соответствующие классы 






















