package pl.borowik.akademia.dao;

import pl.borowik.akademia.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);
}
