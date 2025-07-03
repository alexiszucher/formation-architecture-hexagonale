package com.azucher.user.domain.api.createuser;

import com.azucher.user.domain.User;
import com.azucher.user.domain.spi.UserRepository;

public class UserCreatorUseCase implements CreateUserUseCase {
    private final UserRepository userRepository;

    public UserCreatorUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(String lastname, String firstname) {
        User user = new User(lastname, firstname);
        this.userRepository.create(user);
    }
}
