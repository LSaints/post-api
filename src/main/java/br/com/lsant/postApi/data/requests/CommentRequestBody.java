package br.com.lsant.postApi.data.requests;

import br.com.lsant.postApi.domain.models.AbstractEntity;
import br.com.lsant.postApi.domain.models.Post;
import br.com.lsant.postApi.domain.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestBody extends AbstractEntity {
    private String content;
    private Post post;
    private User author;
}
