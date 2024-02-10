package org.mcralph.userdemothymeleaf.controllers;

import org.mcralph.userdemothymeleaf.models.UserModel;
import org.mcralph.userdemothymeleaf.services.UserBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    UserBusinessServiceInterface service;

    @Autowired
    public UserController(UserBusinessServiceInterface service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<UserModel> userModelList = service.getUsers();

        model.addAttribute("title", "Users");
        model.addAttribute("users", userModelList);

        return "users.html";
    }

    @GetMapping("/newUser")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new UserModel());
        return "newUserForm.html";
    }

    @PostMapping("/addUser")
    public String addUser(UserModel userModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "newUserForm.html";
        }
        service.addUser(userModel);
        return "redirect:/users/";
    }

    @PostMapping("/editForm")
    public String showEditForm(UserModel userModel, Model model) {
        model.addAttribute("user", userModel);

        return "editUserForm.html";
    }

    @PostMapping("/doUpdate")
    public String updateUser(UserModel userModel, BindingResult bindingResult, Model model) {
        service.updateUser(userModel);

        return "redirect:/users/";
    }

    @PostMapping("/delete")
    public String deleteUser(UserModel userModel) {
        service.deleteUser(userModel.getId());

        return "redirect:/users/";
    }
}
