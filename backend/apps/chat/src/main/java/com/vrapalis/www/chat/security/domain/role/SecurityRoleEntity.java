package com.vrapalis.www.chat.security.domain.role;

import com.vrapalis.www.chat.security.domain.authority.SecurityAuthorityEntity;
import com.vrapalis.www.chat.security.domain.common.SecurityAbstractEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class SecurityRoleEntity extends SecurityAbstractEntity implements Serializable {
    @Id
    @SequenceGenerator(name = "role_id_seq", sequenceName = "role_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
    private Integer id;

    @NaturalId
    private String name;

    @Builder.Default
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "role_has_authority",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Set<SecurityAuthorityEntity> authorities = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityRoleEntity roleEntity = (SecurityRoleEntity) o;
        return Objects.equals(name, roleEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
