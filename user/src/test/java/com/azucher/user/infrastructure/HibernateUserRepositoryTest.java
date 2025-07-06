package com.azucher.user.infrastructure;

import com.azucher.user.domain.User;
import com.azucher.user.domain.spi.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class HibernateUserRepositoryTest {
    private final static User ALEXIS_USER = new User("Zucher", "Alexis");
    private final static User ROMAIN_USER = new User("Dupont", "Romain");

    @Autowired
    private UserRepository repository;

    @Autowired
    private HibernateUserManager hibernateUserManager;

    @BeforeEach
    public void setUp() {
        hibernateUserManager.deleteAll();
    }

    @Test
    void shouldCreateUser() {
        Assertions.assertEquals(0, repository.findAll().size());

        repository.create(ALEXIS_USER);

        List<User> users = repository.findAll();
        Assertions.assertEquals(1, users.size());
        User userCreated = users.get(0);
        Assertions.assertEquals(ALEXIS_USER.lastname(), userCreated.lastname());
        Assertions.assertEquals(ALEXIS_USER.firstname(), userCreated.firstname());
    }

    @Test
    void shouldRetrieveUsers() {
        givenExistingUser(ALEXIS_USER);
        givenExistingUser(ROMAIN_USER);
        Assertions.assertEquals(2, repository.findAll().size());
    }

    private void givenExistingUser(User user) {
        repository.create(user);
    }
}
