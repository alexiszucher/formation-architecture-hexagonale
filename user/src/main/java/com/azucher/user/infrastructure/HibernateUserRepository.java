package com.azucher.user.infrastructure;

import com.azucher.user.domain.User;
import com.azucher.user.domain.spi.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateUserRepository implements UserRepository {
    private final HibernateUserManager hibernateUserManager;

    public HibernateUserRepository(HibernateUserManager hibernateUserManager) {
        this.hibernateUserManager = hibernateUserManager;
    }

    @Override
    public List<User> findAll() {
        return hibernateUserManager.findAll().stream().map(hibernateUser ->
                new User(hibernateUser.getLastname(), hibernateUser.getFirstname())).toList();
    }

    @Override
    public void create(User user) {
        HibernateUser hibernateUser = new HibernateUser(user.lastname(), user.firstname());
        hibernateUserManager.save(hibernateUser);
    }
}
