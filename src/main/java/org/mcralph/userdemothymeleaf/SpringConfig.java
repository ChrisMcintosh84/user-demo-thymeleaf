package org.mcralph.userdemothymeleaf;

import org.mcralph.userdemothymeleaf.data.UserDataAccessInterface;
import org.mcralph.userdemothymeleaf.data.UserDataService;
import org.mcralph.userdemothymeleaf.models.UserModel;
import org.mcralph.userdemothymeleaf.services.UserBusinessService;
import org.mcralph.userdemothymeleaf.services.UserBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class SpringConfig {
    @Bean(name = "userBusinessService")
    @RequestScope
    public UserBusinessServiceInterface getUserBusiness() {
        return new UserBusinessService();
    }

    @Bean(name = "userDao")
    @RequestScope
    public UserDataAccessInterface<UserModel> getDataService() {
        return new UserDataService();
    }
}