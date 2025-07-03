package com.azucher.user.domain.api.findallusers;

import com.azucher.user.domain.User;

import java.util.List;

public interface FindAllUsersUseCase {
    List<User> findAll();
}
