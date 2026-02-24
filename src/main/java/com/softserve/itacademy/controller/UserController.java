package com.softserve.itacademy.controller;

import com.softserve.itacademy.dto.userDto.CreateUserDto;
import com.softserve.itacademy.dto.userDto.UpdateUserDto;
import com.softserve.itacademy.dto.userDto.UserDto;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.model.UserRole;
import com.softserve.itacademy.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/create")
    public String create(Model model) {
        // TODO: Implement create User form
        return "redirect:/";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("user") CreateUserDto userDto,
                        BindingResult result) {
        // TODO: Implement create User
        return "redirect:/";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable("id") Long id, Model model) {
        // TODO: Implement read User
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, Model model) {
        // TODO: Implement update User form
        return "redirect:/";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id,
                        @Validated @ModelAttribute("user") UpdateUserDto userDto,
                        BindingResult result,
                        Model model) {
        // TODO: Implement update User
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        // TODO: Implement delete User
        return "redirect:/";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        // TODO: Implement get all Users
        return "redirect:/";
    }
}
