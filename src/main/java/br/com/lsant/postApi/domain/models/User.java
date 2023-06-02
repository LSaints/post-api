package br.com.lsant.postApi.domain.models;

import br.com.lsant.postApi.domain.enums.ProfilesEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.lsant.postApi.domain.models.User.TABLE_NAME;

@EqualsAndHashCode(callSuper = true)
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
    @NotNull(message = "Field cannot be null")
    @NotEmpty(message = "Field cannot be Empty")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "profile", nullable = false)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_profile")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Integer> profiles = new HashSet<>();

    public Set<ProfilesEnum> getProfiles() {
        return this.profiles.stream().map(x -> ProfilesEnum.toEnum(x)).collect(Collectors.toSet());
    }

    public void addProfile(ProfilesEnum profilesEnum) {
        this.profiles.add(profilesEnum.getCode());
    }

}
