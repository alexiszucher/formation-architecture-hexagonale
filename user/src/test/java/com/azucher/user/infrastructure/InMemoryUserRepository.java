package com.azucher.user.infrastructure;

import com.azucher.user.domain.User;
import com.azucher.user.domain.spi.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserRepository implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void create(User user) {
        users.add(user);
    }
}
