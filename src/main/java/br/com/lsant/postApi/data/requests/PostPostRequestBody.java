package br.com.lsant.postApi.data.requests;

import br.com.lsant.postApi.domain.models.AbstractEntity;
import br.com.lsant.postApi.domain.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPostRequestBody extends AbstractEntity {
    private String title;
    private String content;
    private User author;
}
