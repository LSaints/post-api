package br.com.lsant.postApi.data.requests;

import br.com.lsant.postApi.domain.models.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentPutRequestBody extends AbstractEntity {
    private String content;
}
