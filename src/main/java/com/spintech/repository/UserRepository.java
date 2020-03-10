package com.spintech.repository;

import com.spintech.entity.impl.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
