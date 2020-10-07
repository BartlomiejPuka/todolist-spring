package com.app.todolist.controller;

import com.app.todolist.model.ToDoItem;
import com.app.todolist.respository.ToDoRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping
    public List<ToDoItem> findAll(){
        return toDoRepository.findAll();
    }

    @PostMapping
    public ToDoItem save(@Valid @NotNull @RequestBody ToDoItem toDoItem){
        return toDoRepository.save(toDoItem);
    }

    @PutMapping
    public ToDoItem update(@Valid @NotNull @RequestBody ToDoItem toDoItem){
        return toDoRepository.save(toDoItem);
    }

    @DeleteMapping(value="/{id}")
    public void delete(@PathVariable long id){
        toDoRepository.deleteById(id);
    }
}

