package org.liafuture.testament.repository;

import org.liafuture.testament.entity.RoleEntity;
import org.liafuture.testament.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(UserRole name);
}

