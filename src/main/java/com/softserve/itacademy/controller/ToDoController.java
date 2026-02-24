package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.service.ToDoService;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.model.User;
import com.softserve.itacademy.service.TaskService;
import com.softserve.itacademy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService todoService;
    private final TaskService taskService;
    private final UserService userService;

    @GetMapping("/create/users/{owner_id}")
    public String createToDoForm(@PathVariable("owner_id") Long ownerId, Model model) {
        // TODO: Implement create ToDo form
        return "redirect:/";
    }

    @PostMapping("/create/users/{owner_id}")
    public String createToDo(@PathVariable("owner_id") Long ownerId,
                            @Validated @ModelAttribute("todo") ToDo todo,
                            BindingResult result,
                            Model model) {
        // TODO: Implement create ToDo
        return "redirect:/";
    }

    @GetMapping("/{todo_id}/update/users/{owner_id}")
    public String updateToDoForm(@PathVariable("todo_id") Long todoId,
                                 @PathVariable("owner_id") Long ownerId,
                                 Model model) {
        // TODO: Implement update ToDo form
        return "redirect:/";
    }

    @PostMapping("/{todo_id}/update/users/{owner_id}")
    public String updateToDo(@PathVariable("todo_id") Long todoId,
                            @PathVariable("owner_id") Long ownerId,
                            @Validated @ModelAttribute("todo") ToDo todo,
                            BindingResult result,
                            Model model) {
        // TODO: Implement update ToDo
        return "redirect:/";
    }

    @GetMapping("/{todo_id}/delete/users/{owner_id}")
    public String delete(@PathVariable("todo_id") Long todoId,
                        @PathVariable("owner_id") Long ownerId) {
        // TODO: Implement delete ToDo
        return "redirect:/";
    }

    @GetMapping("/all/users/{user_id}")
    public String getAll(@PathVariable("user_id") Long userId, Model model) {
        // TODO: Implement get all ToDos for user
        return "redirect:/";
    }

    @GetMapping("/{id}/add")
    public String addCollaborator(@PathVariable("id") Long todoId,
                                 @RequestParam("user_id") Long userId) {
        // TODO: Implement add collaborator
        return "redirect:/";
    }

    @GetMapping("/{id}/remove")
    public String removeCollaborator(@PathVariable("id") Long todoId,
                                    @RequestParam("user_id") Long userId) {
        // TODO: Implement remove collaborator
        return "redirect:/";
    }
}
