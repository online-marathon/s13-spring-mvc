package com.softserve.itacademy.service;

import com.softserve.itacademy.config.exception.NullEntityReferenceException;
import com.softserve.itacademy.model.ToDo;
import com.softserve.itacademy.repository.ToDoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository todoRepository;

    @Transactional
    public ToDo create(ToDo todo) {
        if (todo != null) {
            return todoRepository.save(todo);
        }
        throw new NullEntityReferenceException("ToDo cannot be 'null'");
    }

    @Transactional(readOnly = true)
    public ToDo readById(long id) {
        return todoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ToDo with id " + id + " not found"));
    }

    @Transactional
    public ToDo update(ToDo todo) {
        if (todo != null) {
            readById(todo.getId());
            return todoRepository.save(todo);
        }
        throw new NullEntityReferenceException("ToDo cannot be 'null'");
    }

    @Transactional
    public void delete(long id) {
        ToDo todo = readById(id);
        todoRepository.delete(todo);
    }

    @Transactional(readOnly = true)
    public List<ToDo> getAll() {
        return todoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ToDo> getByUserId(long userId) {
        return todoRepository.getByUserId(userId);
    }
}
