package org.mcralph.userdemothymeleaf.data;

import java.util.List;

public interface UserDataAccessInterface <UserModel> {
    public UserModel getById(long id);
    public List<UserModel> getUsers();
    public List<UserModel> searchUsers(String searchTerm);
    public Long addUser(UserModel newUser);
    public void deleteUser(long id);
    public UserModel updateUser(UserModel updateUser);
}
