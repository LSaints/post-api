package br.com.lsant.postApi.data.mappers;

import br.com.lsant.postApi.data.requests.PostRequestBody;
import br.com.lsant.postApi.domain.models.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    PostRequestBody toPostRequestBody(Post post);
    List<PostRequestBody> toPostRequestBodyList(List<Post> posts);

    Post toPost(PostRequestBody postRequestBody);
}
