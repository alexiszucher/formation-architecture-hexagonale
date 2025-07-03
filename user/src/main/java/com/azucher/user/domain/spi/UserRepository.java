package com.azucher.user.domain.spi;

import com.azucher.user.domain.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    void create(User user);
}
