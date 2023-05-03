package br.com.lsant.postApi.data.mappers;

import br.com.lsant.postApi.data.requests.PostPostRequestBody;
import br.com.lsant.postApi.data.requests.PostPutRequestBody;
import br.com.lsant.postApi.domain.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostPostRequestBody toPostRequestBody(Post post);
    List<PostPostRequestBody> toPostRequestBodyList(List<Post> posts);
    Post toPost(PostPostRequestBody postPostRequestBody);
    Post toPost(PostPutRequestBody postPutRequestBody);
}
