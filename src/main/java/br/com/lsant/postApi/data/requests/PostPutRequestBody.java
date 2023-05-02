package br.com.lsant.postApi.data.requests;

import br.com.lsant.postApi.domain.models.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPutRequestBody extends AbstractEntity {
    private String title;
    private String content;
}
