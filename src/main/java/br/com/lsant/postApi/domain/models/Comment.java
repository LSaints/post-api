package br.com.lsant.postApi.domain.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static br.com.lsant.postApi.domain.models.Comment.TABLE_NAME;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_NAME)
@Data
public class Comment extends AbstractEntity {
    public static final String TABLE_NAME = "comment";

    @Column(name = "content", length = 255, nullable = false)
    @NotNull(message = "Field cannot be null")
    @NotEmpty(message = "Field cannot be Empty")
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @NotNull(message = "Field cannot be null")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "Field cannot be null")
    private User author;
}