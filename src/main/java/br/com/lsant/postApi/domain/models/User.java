package br.com.lsant.postApi.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import static br.com.lsant.postApi.domain.models.User.TABLE_NAME;

@Entity(name = TABLE_NAME)
public class User extends AbstractEntity {
    public static final String TABLE_NAME = "user";

    @Column(name = "username", nullable = false, unique = true, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = 60)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
