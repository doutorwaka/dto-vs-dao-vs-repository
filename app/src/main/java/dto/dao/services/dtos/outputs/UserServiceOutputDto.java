package dto.dao.services.dtos.outputs;

import dto.dao.entities.User;

public record UserServiceOutputDto(
        String id,
        String name,
        String email) {

    public static UserServiceOutputDto build(final User anUser) {
        return new UserServiceOutputDto(anUser.getId(), anUser.getName(), anUser.getEmail());
    }
}
