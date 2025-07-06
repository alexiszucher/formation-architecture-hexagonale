package com.azucher.user.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface HibernateUserManager extends JpaRepository<HibernateUser, Long> {
}
