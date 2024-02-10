package org.mcralph.userdemothymeleaf.data;

import org.mcralph.userdemothymeleaf.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserDataService implements UserDataAccessInterface<UserModel> {
    @Autowired
    private UserRepositoryInterface userRepository;

    @Override
    public UserModel getById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<UserModel> getUsers() {
        List<UserModel> userModelList = new ArrayList<>();
        userRepository.findAll().forEach(userModelList::add);
        return userModelList;
    }

    @Override
    public List<UserModel> searchUsers(String searchTerm) {
        return new ArrayList<>(userRepository.findByNameContainingIgnoreCase(searchTerm));
    }

    @Override
    public Long addUser(UserModel newUser) {
        return userRepository.save(newUser).getId();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserModel updateUser(UserModel updateUser) {
        return userRepository.save(updateUser);
    }
}
