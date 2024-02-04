package org.liafuture.testament.repository;

import org.liafuture.testament.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(final String userName);
    public Optional<User> findByEmail(final String email);
}
