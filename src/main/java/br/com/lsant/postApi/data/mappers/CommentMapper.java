package br.com.lsant.postApi.data.mappers;

import br.com.lsant.postApi.data.requests.CommentRequestBody;
import br.com.lsant.postApi.domain.models.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentRequestBody toCommentBodyRequst(Comment comment);
    List<CommentRequestBody> toCommentRequestBodyList(List<Comment> comments);
    Comment toComment(CommentRequestBody commentRequestBody);
}
