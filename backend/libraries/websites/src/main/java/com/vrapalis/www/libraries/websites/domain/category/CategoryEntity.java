package com.vrapalis.www.libraries.websites.domain.category;

import com.vrapalis.www.libraries.websites.domain.post.PostEntity;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(name = "category")
public class CategoryEntity implements Serializable {
    @Id
    private Integer id;

    @NaturalId
    @EqualsAndHashCode.Include
    private String name;

    @Builder.Default
    @ManyToMany(mappedBy = "categories")
    private Set<PostEntity> posts = new HashSet<>();
}

