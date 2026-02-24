package com.softserve.itacademy.service;

import com.softserve.itacademy.model.State;
import com.softserve.itacademy.config.exception.NullEntityReferenceException;
import com.softserve.itacademy.dto.StateDto;
import com.softserve.itacademy.repository.StateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StateService {

    private final StateRepository stateRepository;

    @Transactional
    public State create(State state) {
        if (state != null) {
            return stateRepository.save(state);
        }
        throw new NullEntityReferenceException("State cannot be 'null'");
    }

    @Transactional(readOnly = true)
    public State readById(long id) {
        return stateRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("State with id " + id + " not found"));
    }

    @Transactional
    public State update(State state) {
        if (state != null) {
            readById(state.getId());
            return stateRepository.save(state);
        }
        throw new NullEntityReferenceException("State cannot be 'null'");
    }

    @Transactional
    public void delete(long id) {
        State state = readById(id);
        stateRepository.delete(state);
    }

    @Transactional(readOnly = true)
    public List<State> getAll() {
        return stateRepository.findAllByOrderByIdAsc();
    }

    @Transactional(readOnly = true)
    public State getByName(String name) {
        return stateRepository.findByName(name)
                .orElseThrow(() -> new EntityNotFoundException("State with name '" + name + "' not found"));
    }

    @Transactional(readOnly = true)
    public List<StateDto> findAll() {
        return stateRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();
    }

    private StateDto toDto(State state) {
        return StateDto.builder()
                .name(state.getName())
                .build();
    }
}
