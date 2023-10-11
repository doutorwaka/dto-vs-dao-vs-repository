package dto.dao.repositories.daos.user.mapper;

import com.google.common.base.Function;

import dto.dao.entities.User;
import dto.dao.repositories.daos.user.model.UserModel;

public class UserModelToUser implements Function<UserModel, User> {

    @Override
    public User apply(UserModel input) {

        final var anId = input.id();
        final var aName = input.name();
        final var anEmail = input.email();

        return User.with(anId, aName, anEmail);
    }

    public static User convert(final UserModel input) {
        return new UserModelToUser().apply(input);
    }
}
