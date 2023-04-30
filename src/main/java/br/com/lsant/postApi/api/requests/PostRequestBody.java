package br.com.lsant.postApi.api.requests;

import br.com.lsant.postApi.domain.models.AbstractEntity;
import br.com.lsant.postApi.domain.models.Comment;
import br.com.lsant.postApi.domain.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostRequestBody extends AbstractEntity {
    private String title;
    private String postContent;
    private User author;
    private List<Comment> comments;
}
