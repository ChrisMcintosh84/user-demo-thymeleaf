package org.mcralph.userdemothymeleaf.services;

import org.mcralph.userdemothymeleaf.data.UserDataAccessInterface;
import org.mcralph.userdemothymeleaf.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserBusinessService implements UserBusinessServiceInterface {
    @Autowired
    private UserDataAccessInterface<UserModel> userDAO;

    @Override
    public UserModel getById(long id) {
        return userDAO.getById(id);
    }

    @Override
    public List<UserModel> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm) {
        return userDAO.searchUsers(searchTerm);
    }

    @Override
    public long addUser(UserModel newUser) {
        return userDAO.addUser(newUser);
    }

    @Override
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public UserModel updateUser(UserModel updateUser) {
        return userDAO.updateUser(updateUser);
    }
}
