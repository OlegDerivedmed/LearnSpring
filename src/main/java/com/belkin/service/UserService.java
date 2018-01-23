package com.belkin.service;

import com.belkin.dao.UserDao;
import com.belkin.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
