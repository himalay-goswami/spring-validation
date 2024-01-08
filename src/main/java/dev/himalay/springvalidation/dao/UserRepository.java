package dev.himalay.recalgo.dao;

import dev.himalay.recalgo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(int id);
}
