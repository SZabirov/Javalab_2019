package ru.javalab.jsonexample;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        AuthData data = new AuthData();
        data.setLogin("salavat");
        data.setPassword("abcdef");
        User u = new User();
        u.setAuthData(data);
        u.setName("Salavat Zabirov");
        List<Integer> marks = new ArrayList<Integer>();
        marks.add(100);
        marks.add(86);
        marks.add(85);
        u.setMarks(marks);
        u.setStatus("Online");
        ObjectMapper mapper = new ObjectMapper();
        String jsonValue = mapper.writeValueAsString(u);
        System.out.println("Json-значение:");
        System.out.println(jsonValue);


        User userFromJsonString = mapper.readValue(jsonValue, User.class);
        System.out.println("Список оценок пользователя, полученного из json-строки");
        System.out.println(userFromJsonString.getMarks());


        System.out.println("============================");

        String pass = "abcdef";
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        //получение хэша по алгоритму bcrypt
        //полученное значение мы сохраняем в базу при регистрации
        String hash = encoder.encode(pass);
        System.out.println(hash);

        //проверка на соответствие пароля, присланного при попытке логина
        //с хэшем, полученным из базы данных
        System.out.println(encoder.matches("abcdef", hash));
    }
}











