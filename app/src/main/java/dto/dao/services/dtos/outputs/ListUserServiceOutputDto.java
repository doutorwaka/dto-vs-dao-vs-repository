package dto.dao.services.dtos.outputs;

import java.util.List;

public record ListUserServiceOutputDto(
        List<UserServiceOutputDto> users) {

}
