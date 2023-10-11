package dto.dao.repositories.daos.user.mapper;

import java.util.function.Function;

import dto.dao.entities.User;
import dto.dao.repositories.daos.user.model.UserModel;

public class UserToUserModel implements Function<User, UserModel> {

    @Override
    public UserModel apply(final User input) {
        final var anId = input.getId();
        final var aName = input.getName();
        final var anEmail = input.getEmail();

        return UserModel.build(anId, aName, anEmail);
    }

    public static UserModel convert(final User input) {
        return new UserToUserModel().apply(input);
    }

}
