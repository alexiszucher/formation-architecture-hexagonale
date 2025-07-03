package com.azucher.user.domain.api;

import com.azucher.user.domain.User;
import com.azucher.user.domain.api.findallusers.FindAllUsersUseCase;
import com.azucher.user.domain.api.findallusers.UserFinderUseCase;
import com.azucher.user.domain.spi.InMemoryUserRepository;
import com.azucher.user.domain.spi.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FindAllUsersTest {
    private final static User ALEXIS_USER = new User("Zucher", "Alexis");
    private final static User ROMAIN_USER = new User("Dupont", "Romain");

    private final UserRepository repository = new InMemoryUserRepository();
    private final FindAllUsersUseCase useCase = new UserFinderUseCase(repository);

    @Test
    void shouldRetrieveAllUsers() {
        givenExistingUser(ALEXIS_USER);
        givenExistingUser(ROMAIN_USER);
        List<User> users = useCase.findAll();
        Assertions.assertEquals(2, users.size());
    }

    private void givenExistingUser(User user) {
        repository.create(user);
    }
}
