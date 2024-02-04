package org.liafuture.testament.repository;

import org.liafuture.testament.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public UserEntity findByUserName(final String userName);
    public Optional<UserEntity> findByEmail(final String email);
}
