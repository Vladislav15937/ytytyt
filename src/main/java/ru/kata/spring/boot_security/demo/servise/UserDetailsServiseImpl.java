package ru.kata.spring.boot_security.demo.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiseImpl implements UserDetailsService {

    private final UserDAO userDAO;

    @Autowired
    public UserDetailsServiseImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getUserByLogin(username);
        if (user == null){
            throw new UsernameNotFoundException("неверный юзер");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getRole());
    }
}
