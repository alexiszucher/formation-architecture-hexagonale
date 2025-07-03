package com.azucher.user.domain.api;

import com.azucher.user.domain.api.createuser.CreateUserUseCase;
import com.azucher.user.domain.api.createuser.UserCreatorUseCase;
import com.azucher.user.domain.spi.InMemoryUserRepository;
import com.azucher.user.domain.spi.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateUserTest {
    private UserRepository repository = new InMemoryUserRepository();
    private CreateUserUseCase useCase = new UserCreatorUseCase(repository);

    @Test
    void shouldCreateUser() {
        Assertions.assertEquals(0, repository.findAll().size());
        useCase.create("Zucher", "Alexis");
        Assertions.assertEquals(1, repository.findAll().size());
    }
}
