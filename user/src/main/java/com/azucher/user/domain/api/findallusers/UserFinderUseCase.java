package com.azucher.user.domain.api.findallusers;

import com.azucher.user.domain.User;
import com.azucher.user.domain.spi.UserRepository;

import java.util.List;

public class UserFinderUseCase implements FindAllUsersUseCase {
    private final UserRepository userRepository;

    public UserFinderUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
