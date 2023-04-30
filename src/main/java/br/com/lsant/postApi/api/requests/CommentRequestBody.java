package br.com.lsant.postApi.api.requests;

import br.com.lsant.postApi.domain.models.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestBody extends AbstractEntity {
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
