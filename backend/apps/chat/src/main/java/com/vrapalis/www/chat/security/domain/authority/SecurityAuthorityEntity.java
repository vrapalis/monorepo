package com.vrapalis.www.chat.security.domain.authority;

import com.vrapalis.www.chat.security.domain.common.SecurityAbstractEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name = "authority")
public class SecurityAuthorityEntity extends SecurityAbstractEntity implements Serializable {

    @Id
    @SequenceGenerator(name = "authority_id_seq", sequenceName = "authority_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_id_seq")
    private Integer id;

    @NaturalId
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecurityAuthorityEntity authorityEntity = (SecurityAuthorityEntity) o;
        return Objects.equals(name, authorityEntity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
