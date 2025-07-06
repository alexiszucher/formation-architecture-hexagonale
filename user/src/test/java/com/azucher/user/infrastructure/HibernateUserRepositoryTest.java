package com.azucher.user.infrastructure;

import com.azucher.user.domain.User;
import com.azucher.user.domain.spi.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        Assertions.assertEquals(1, repository.findAll().size());
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
