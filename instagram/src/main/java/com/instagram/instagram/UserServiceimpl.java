package com.instagram.instagram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    Connection connection;
    int flag = 0;

    public UserServiceimpl() throws SQLException {

        connection = dbutil.getConnection();
    }

    @Override
    public int loginValidation(String username, String password) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("SELECT * FROM users WHERE username = '" + username + "'");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                if (rs.getString(5).equals(username) && rs.getString(6).equals(password)) {
                    flag = 1;
                } else {
                    System.out.println("invalid username/password");
                    flag = 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        return flag;
    }

}
