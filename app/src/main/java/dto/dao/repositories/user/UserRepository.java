package dto.dao.repositories.user;

import java.util.List;
import java.util.stream.Collectors;

import dto.dao.entities.User;
import dto.dao.repositories.RepositoryInterface;
import dto.dao.repositories.daos.DaoInterface;
import dto.dao.repositories.daos.user.UserDao;
import dto.dao.repositories.daos.user.mapper.UserModelToUser;
import dto.dao.repositories.daos.user.mapper.UserToUserModel;
import dto.dao.repositories.daos.user.model.UserModel;

public class UserRepository implements RepositoryInterface<User> {

    private DaoInterface<UserModel> userDao;

    private UserRepository(final DaoInterface<UserModel> aDao) {
        this.userDao = aDao;
    }

    public static UserRepository build(final UserDao aDao) {
        return new UserRepository(aDao);
    }

    @Override
    public User getById(final String id) {

        final var aModel = this.userDao.getById(id);

        final var anUser = UserModelToUser.convert(aModel);

        return anUser;
    }

    @Override
    public List<User> getAll() {

        final var aModelList = this.userDao.getAll();

        final var anUserList = aModelList.stream()
                .map(UserModelToUser::convert)
                .collect(Collectors.toList());

        return anUserList;
    }

    @Override
    public User create(final User anEntity) {
        final var aModel = UserToUserModel.convert(anEntity);

        this.userDao.create(aModel);

        return anEntity;
    }

    @Override
    public User update(final User anEntity) {
        final var aModelToUpdate = this.userDao.getById(anEntity.getId());

        if (aModelToUpdate != null) {
            final var aNewModel = UserModel.with(anEntity.getId(), anEntity.getName(), anEntity.getEmail(),
                    aModelToUpdate.createdAt());

            this.userDao.update(aNewModel);

            return anEntity;
        }

        throw new RuntimeException("User " + anEntity.getName() + " not found to update");
    }

    @Override
    public void delete(final String id) {
        this.userDao.delete(id);
    }

}
