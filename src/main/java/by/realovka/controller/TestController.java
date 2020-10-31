package by.realovka.controller;

import by.realovka.dao.UserDao;
import by.realovka.entity.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    private UserDao userDao;

    @PostMapping(path = "/createUser")
    public String createUser(User user){
        System.out.println(user);
        userDao.save(user);
        return "test";
    }

    @GetMapping(path = "/findByLogin")
    public void findByLogin(@RequestParam String login){
        User byLogin = userDao.findByLogin(login);
        System.out.println(byLogin);
    }
}
