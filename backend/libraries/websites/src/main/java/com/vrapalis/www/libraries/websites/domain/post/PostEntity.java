package com.vrapalis.www.libraries.websites.domain.post;

import com.vrapalis.www.libraries.websites.domain.category.CategoryEntity;
import com.vrapalis.www.libraries.websites.domain.tag.TagEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "post")
public class PostEntity implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    private Integer id;
    private String text;


    @Builder.Default
    @JoinTable(name = "post_has_tag", joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<TagEntity> tags = new HashSet<>();

    @Builder.Default
    @JoinTable(name = "post_has_category", joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<CategoryEntity> categories = new HashSet<>();

    public void addTag(TagEntity tag) {
        tags.add(tag);
        tag.getPosts().add(this);
    }

    public void removeTag(TagEntity tag) {
        tags.remove(tag);
        tag.getPosts().remove(this);
    }

    public void addCategory(CategoryEntity category) {
        categories.add(category);
        category.getPosts().add(this);
    }

    public void removeCategory(CategoryEntity category) {
        categories.remove(category);
        category.getPosts().remove(this);
    }
}
