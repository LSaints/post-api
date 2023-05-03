package br.com.lsant.postApi.data.mappers;

import br.com.lsant.postApi.data.requests.CommentPostRequestBody;
import br.com.lsant.postApi.data.requests.CommentPutRequestBody;
import br.com.lsant.postApi.domain.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentPostRequestBody toCommentBodyRequst(Comment comment);
    List<CommentPostRequestBody> toCommentRequestBodyList(List<Comment> comments);
    Comment toComment(CommentPostRequestBody commentPostRequestBody);
    Comment toComment(CommentPutRequestBody commentPutRequestBody);
}
