package com.softserve.itacademy.controller;

import com.softserve.itacademy.model.State;
import com.softserve.itacademy.service.StateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/states")
@RequiredArgsConstructor
public class StateController {

    private final StateService stateService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("states", stateService.getAll());

        return "state/state-list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("state", new State());

        return "state/create-state";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("state") State state,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "state/create-state";
        }

        stateService.create(state);

        return "redirect:/states";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, Model model) {
        State state = stateService.readById(id);
        model.addAttribute("state", state);

        return "state/update-state";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") Long id,
                        @Valid @ModelAttribute("state") State state,
                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "state/update-state";
        }

        state.setId(id);
        stateService.update(state);

        return "redirect:/states";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        stateService.delete(id);

        return "redirect:/states";
    }
}
