package com.tr.dynamic.datasource.service.impl;

import com.tr.dynamic.datasource.entity.User;
import com.tr.dynamic.datasource.jpa.UserJpa;
import com.tr.dynamic.datasource.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author taorun
 * @date 2022/12/16 15:58
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserJpa userJpa;

    @Override
    public User save(User user) {
        return userJpa.save(user);
    }

    @Override
    public User findById(Integer id) {
        return userJpa.findById(id).orElse(null);
    }
}
