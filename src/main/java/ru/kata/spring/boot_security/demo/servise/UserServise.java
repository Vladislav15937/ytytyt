package ru.kata.spring.boot_security.demo.servise;



import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserServise {


    List<User> getAllPeople();


    User personById(Long id);


    User save(User user);

    User update(User user);

    void delete(Long id);
}
