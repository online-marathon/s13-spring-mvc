package com.softserve.itacademy.service;

import com.softserve.itacademy.dto.TaskTransformer;
import com.softserve.itacademy.dto.TaskDto;
import com.softserve.itacademy.model.Task;
import com.softserve.itacademy.repository.StateRepository;
import com.softserve.itacademy.repository.ToDoRepository;
import com.softserve.itacademy.config.exception.NullEntityReferenceException;
import com.softserve.itacademy.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskService {

    private final TaskRepository taskRepository;
    private final ToDoRepository toDoRepository;
    private final StateRepository stateRepository;
    private final TaskTransformer taskTransformer;

    @Transactional
    public TaskDto create(TaskDto taskDto) {
        Task task = taskTransformer.fillEntityFields(
                new Task(),
                taskDto,
                toDoRepository.findById(taskDto.getTodoId()).orElseThrow(),
                stateRepository.findByName("New")
                        .orElseThrow(() -> new EntityNotFoundException("State 'New' not found"))
        );

        if (task != null) {
            Task savedTask = taskRepository.save(task);
            return taskTransformer.convertToDto(savedTask);
        }
        throw new NullEntityReferenceException("Task cannot be 'null'");
    }

    @Transactional(readOnly = true)
    public Task readById(long id) {
        EntityNotFoundException exception = new EntityNotFoundException("Task with id " + id + " not found");
        log.error(exception.getMessage(), exception);

        return taskRepository.findById(id).orElseThrow(
                () -> exception);
    }

    @Transactional
    public Task update(Task task) {
        if (task != null) {
            readById(task.getId());
            return taskRepository.save(task);
        }
        throw new NullEntityReferenceException("Task cannot be 'null'");
    }

    @Transactional
    public void delete(long id) {
        Task task = readById(id);
        taskRepository.delete(task);
    }

    @Transactional(readOnly = true)
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Task> getByTodoId(long todoId) {
        return taskRepository.findByTodoId(todoId);
    }
}