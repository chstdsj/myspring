package com.jar.wh.services;

import com.jar.wh.mapper.UserDAO;
import com.jar.wh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public String addUser(User user){
        int i = userDAO.addUser(user.getName(), user.getAge(), user.getBirthday());
        if (i==1){
            return "200";
        }
        return "500";
    }

}
