package org.mcralph.userdemothymeleaf.data;

import org.mcralph.userdemothymeleaf.models.UserModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepositoryInterface extends CrudRepository<UserModel, Long> {
    UserModel findById(long id);
    List<UserModel> findByNameContainingIgnoreCase(String searchTerm);
}
