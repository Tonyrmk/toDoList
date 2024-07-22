package com.todoList.controllers.restController;

import com.todoList.entity.mok.ToDo;
import com.todoList.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class todoRestController {

    @Autowired
    ToDoService service;

    @RequestMapping(value = "/todos/{name}")
    public List<ToDo> getAllTodos(@PathVariable String name){

        return service.retrieveTodos(name);
    }

    @RequestMapping(value = "/todo/{id}")
    public ToDo getAllTodos(@PathVariable int id){
        service.

        return service.getTodo(id);
    }
}
