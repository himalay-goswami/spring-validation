package dev.himalay.springvalidation.dao;

import dev.himalay.springvalidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(int id);
}
