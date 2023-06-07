package com.instagram.instagram;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/{username}/{password}") // @postMapping("")
    @CrossOrigin(origins = "http://localhost:4200")
    public int UserLogin(@PathVariable("username") String username1, @PathVariable("password") String password1) {

        int flag = userService.loginValidation(username1, password1);// regist
        if (flag == 0) {
            return 0;
        }
        return flag;
    }
}
