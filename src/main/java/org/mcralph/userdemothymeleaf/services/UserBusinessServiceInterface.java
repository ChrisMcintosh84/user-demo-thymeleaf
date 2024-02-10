package org.mcralph.userdemothymeleaf.services;

import org.mcralph.userdemothymeleaf.models.UserModel;

import java.util.List;

public interface UserBusinessServiceInterface {
    UserModel getById(long id);
    List<UserModel> getUsers();
    List<UserModel> searchUsers(String searchTerm);
    long addUser(UserModel newUser);
    void deleteUser(long id);
    UserModel updateUser(UserModel updateUser);
}
