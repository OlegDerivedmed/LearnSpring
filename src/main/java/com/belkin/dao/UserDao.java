package com.belkin.dao;

import com.belkin.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
