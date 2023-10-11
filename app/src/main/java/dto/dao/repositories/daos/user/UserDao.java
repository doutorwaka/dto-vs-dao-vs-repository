package dto.dao.repositories.daos.user;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import dto.dao.repositories.daos.DaoInterface;
import dto.dao.repositories.daos.user.model.UserModel;

public class UserDao implements DaoInterface<UserModel> {

    private HashMap<String, UserModel> users;

    private UserDao() {
        this.users = new HashMap<String, UserModel>();
    }

    public static UserDao build() {
        return new UserDao();
    }

    @Override
    public UserModel getById(String id) {
        // Select * from TABLE where id=id
        return this.users.get(id);
    }

    @Override
    public List<UserModel> getAll() {
        // Select * from TABLE
        final List<UserModel> aList = this.users.values()
                .stream()
                .collect(Collectors.toList());

        return aList;
    }

    @Override
    public UserModel create(UserModel anEntity) {
        // INSERT INTO TABLE ...
        if (this.users.get(anEntity.id()) == null) {
            this.users.put(anEntity.id(), anEntity);

            return anEntity;
        }

        return null;
    }

    @Override
    public UserModel update(UserModel anEntity) {
        // UPDATE TABLE SET ...
        if (this.users.get(anEntity.id()) != null) {

            this.users.put(anEntity.id(), anEntity);

            return anEntity;
        }

        return null;
    }

    @Override
    public void delete(String id) {
        this.users.remove(id);
    }
}
