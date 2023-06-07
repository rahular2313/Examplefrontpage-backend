package com.instagram.instagram;

import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    public int loginValidation(String username, String password);
}
