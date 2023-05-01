package br.com.lsant.postApi.data.mappers;

import br.com.lsant.postApi.data.requests.UserRequestBody;
import br.com.lsant.postApi.domain.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserRequestBody toUserRequestBody(User user);
    List<UserRequestBody> toUserRequestBodyList(List<User> users);

    User toUser(UserRequestBody userRequestBody);
}
