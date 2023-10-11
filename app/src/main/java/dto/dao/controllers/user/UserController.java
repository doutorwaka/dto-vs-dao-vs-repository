package dto.dao.controllers.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.dao.controllers.user.dto.CreateUserDto;
import dto.dao.controllers.user.dto.UpdateUserDto;
import dto.dao.repositories.daos.user.UserDao;
import dto.dao.repositories.user.UserRepository;
import dto.dao.services.UserService;
import dto.dao.services.dtos.inputs.ChangeNameServiceInputDto;
import dto.dao.services.dtos.inputs.CreateUserServiceInputDto;
import dto.dao.services.dtos.outputs.ChangeNameServiceOutputDto;
import dto.dao.services.dtos.outputs.CreateUserServiceOutputDto;
import dto.dao.services.dtos.outputs.ListUserServiceOutputDto;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserDao userDao = UserDao.build();

    @GetMapping
    public ListUserServiceOutputDto getUser() {
        final var aRepository = UserRepository.build(this.userDao);
        final var aService = UserService.build(aRepository);

        return aService.getUsers();
    }

    @PostMapping("/{id}")
    public ChangeNameServiceOutputDto updateUser(@PathVariable("id") final String id, @RequestBody final UpdateUserDto input) {
        final var aRepository = UserRepository.build(this.userDao);
        final var aService = UserService.build(aRepository);

        return aService.changeName(new ChangeNameServiceInputDto(id, input.name()));
    }

    @PostMapping
    public CreateUserServiceOutputDto createUser(@RequestBody final CreateUserDto input) {
        final var aRepository = UserRepository.build(this.userDao);
        final var aService = UserService.build(aRepository);

        return aService.createUser(new CreateUserServiceInputDto(input.name(), input.email()));
    }

}
