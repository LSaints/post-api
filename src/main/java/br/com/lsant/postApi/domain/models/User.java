package br.com.lsant.postApi.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import static br.com.lsant.postApi.domain.models.User.TABLE_NAME;

@Table(name = TABLE_NAME)
@Entity
@Data
public class User extends AbstractEntity {
    public static final String TABLE_NAME = "user";

    @Column(name = "username", unique = true, length = 100, nullable = false)
    @NotNull(message = "Field cannot be null")
    @NotEmpty(message = "Field cannot be Empty")
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Field cannot be null")
    @NotEmpty(message = "Field cannot be Empty")
    private String password;
}
