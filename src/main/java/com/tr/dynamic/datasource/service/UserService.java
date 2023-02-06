package com.tr.dynamic.datasource.service;

import com.tr.dynamic.datasource.entity.User;

public interface UserService {

    User save(User user);

    User findById(Integer id);

}
