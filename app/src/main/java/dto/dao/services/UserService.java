package dto.dao.services;

import java.util.stream.Collectors;

import dto.dao.entities.User;
import dto.dao.repositories.RepositoryInterface;
import dto.dao.services.dtos.inputs.ChangeNameServiceInputDto;
import dto.dao.services.dtos.inputs.CreateUserServiceInputDto;
import dto.dao.services.dtos.outputs.CreateUserServiceOutputDto;
import dto.dao.services.dtos.outputs.ListUserServiceOutputDto;
import dto.dao.services.dtos.outputs.ChangeNameServiceOutputDto;
import dto.dao.services.dtos.outputs.UserServiceOutputDto;

public class UserService {

    private RepositoryInterface<User> userRepository;

    private UserService(final RepositoryInterface<User> aRepository) {
        this.userRepository = aRepository;
    }

    public static UserService build(final RepositoryInterface<User> aRepository) {
        return new UserService(aRepository);
    }

    public CreateUserServiceOutputDto createUser(final CreateUserServiceInputDto input) {
        final var anUser = User.build(input.name(), input.email());

        this.userRepository.create(anUser);

        return new CreateUserServiceOutputDto(anUser.getId());
    }

    public ChangeNameServiceOutputDto changeName(final ChangeNameServiceInputDto input) {
        final var anUser = this.userRepository.getById(input.id());

        if (anUser == null) {
            throw new RuntimeException("User " + input.name() + " not found");
        }

        anUser.changeName(input.name());

        this.userRepository.update(anUser);

        return new ChangeNameServiceOutputDto(anUser.getId());
    }

    public ListUserServiceOutputDto getUsers() {
        final var anUsers = this.userRepository.getAll();

        final var aReturn = anUsers.stream()
                .map(UserServiceOutputDto::build)
                .collect(Collectors.toList());

        return new ListUserServiceOutputDto(aReturn);
    }

}
