package com.azucher.user.domain.api.createuser;

import com.azucher.user.domain.User;
import com.azucher.user.domain.spi.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserCreatorUseCase implements CreateUserUseCase {
    private final UserRepository userRepository;

    public UserCreatorUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(String lastname, String firstname) {
        if (isLastNameOrFirstNameNotFilled(lastname, firstname))
            throw new IllegalArgumentException("lastname and firstname must not be null");
        User user = new User(lastname, firstname);
        this.userRepository.create(user);
    }

    private static boolean isLastNameOrFirstNameNotFilled(String lastname, String firstname) {
        return lastname == null || firstname == null || lastname.isBlank() || firstname.isBlank();
    }
}
