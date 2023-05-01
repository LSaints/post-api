package br.com.lsant.postApi.domain.models;

import jakarta.persistence.*;
import lombok.Data;

import static br.com.lsant.postApi.domain.models.Post.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@Data
public class Post extends AbstractEntity {
    public static final String TABLE_NAME = "post";

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "content", length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;
}