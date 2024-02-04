package org.liafuture.testament.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.liafuture.testament.enums.UserRole;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserRole name;


    public RoleEntity(final UserRole name) {
        this.name = name;
    }
}
