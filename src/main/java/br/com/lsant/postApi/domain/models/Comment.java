package br.com.lsant.postApi.domain.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import static br.com.lsant.postApi.domain.models.Comment.TABLE_NAME;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = TABLE_NAME)
@Data
public class Comment extends AbstractEntity {
    public static final String TABLE_NAME = "comment";

    @Column(name = "content", length = 255)
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
}