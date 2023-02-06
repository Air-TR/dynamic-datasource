package com.tr.dynamic.datasource.jpa;

import com.tr.dynamic.datasource.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<User, Integer> {
}
