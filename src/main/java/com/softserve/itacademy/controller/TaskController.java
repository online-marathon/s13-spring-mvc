package com.softserve.itacademy.controller;

import com.softserve.itacademy.dto.TaskDto;
import com.softserve.itacademy.model.TaskPriority;
import com.softserve.itacademy.service.TaskService;
import com.softserve.itacademy.dto.TaskTransformer;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.service.StateService;
import com.softserve.itacademy.service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final ToDoService todoService;
    private final StateService stateService;
    private final TaskTransformer taskTransformer;

    @GetMapping("/create/todos/{todo_id}")
    public String create(@PathVariable("todo_id") Long todoId, Model model) {
        TaskDto taskDto = TaskDto.builder()
                .todoId(todoId)
                .build();

        model.addAttribute("task", taskDto);
        model.addAttribute("todo", todoService.readById(todoId));
        model.addAttribute("priorities", TaskPriority.values());

        return "create-task";
    }

    @PostMapping("/create/todos/{todo_id}")
    public String create(@PathVariable("todo_id") Long todoId,
                        @Valid @ModelAttribute("task") TaskDto taskDto,
                        BindingResult bindingResult,
                        Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("todo", todoService.readById(todoId));
            model.addAttribute("priorities", TaskPriority.values());
            return "create-task";
        }

        taskDto.setTodoId(todoId);
        taskService.create(taskDto);

        return "redirect:/todos/" + todoId + "/tasks";
    }

    @GetMapping("/{task_id}/update/todos/{todo_id}")
    public String taskUpdateForm(@PathVariable("task_id") Long taskId,
                                 @PathVariable("todo_id") Long todoId,
                                 Model model) {
        Task task = taskService.readById(taskId);
        TaskDto taskDto = taskTransformer.convertToDto(task);

        model.addAttribute("task", taskDto);
        model.addAttribute("todo", todoService.readById(todoId));
        model.addAttribute("priorities", TaskPriority.values());
        model.addAttribute("states", stateService.getAll());

        return "update-task";
    }

    @PostMapping("/{task_id}/update/todos/{todo_id}")
    public String update(@PathVariable("task_id") Long taskId,
                        @PathVariable("todo_id") Long todoId,
                        @Valid @ModelAttribute("task") TaskDto taskDto,
                        BindingResult bindingResult,
                        Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("todo", todoService.readById(todoId));
            model.addAttribute("priorities", TaskPriority.values());
            model.addAttribute("states", stateService.getAll());
            return "update-task";
        }

        Task task = taskService.readById(taskId);
        Task updatedTask = taskTransformer.fillEntityFields(
                task,
                taskDto,
                todoService.readById(todoId),
                stateService.readById(taskDto.getStateId())
        );

        taskService.update(updatedTask);

        return "redirect:/todos/" + todoId + "/tasks";
    }

    @GetMapping("/{task_id}/delete/todos/{todo_id}")
    public String delete(@PathVariable("task_id") Long taskId,
                        @PathVariable("todo_id") Long todoId) {
        taskService.delete(taskId);

        return "redirect:/todos/" + todoId + "/tasks";
    }

}
