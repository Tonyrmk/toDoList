package com.todoList.controllers;

import com.todoList.bean.ToDo;
import com.todoList.services.ToDoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ToDoController {

    @Autowired
    ToDoServiceImpl service;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(format,false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String getToDoList( ModelMap map) {
        String user = retrieveUserName();
        map.addAttribute("todos",service.retrieveTodos(user));
        map.addAttribute("userName",retrieveUserName());
        return "toDoList";

    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showToDoForm(ModelMap model) {

        /* code for test purpose.commented.
        throw new RuntimeException("expection");*/

        model.put("todo", new ToDo());
        return "todo";

    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addToDo(ModelMap map, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";

        }
        service.addTodo(retrieveUserName(),todo.getDesc(),new Date(),false);
        map.clear();

        return "redirect:/list-todos";

    }

    private static String retrieveUserName() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteToDo(@RequestParam int id, ModelMap map) {
        map.clear();
        service.deleteTodo(id);
        return "redirect:/list";

    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateToDo(@RequestParam int id, ModelMap map) {
        ToDo todo = service.getTodo(id);
        map.addAttribute("todo",todo);
        return "todo";

    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateToDos(ModelMap map, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";

        }
        service.updateTodo(todo);
        return "redirect:/list-todos";
    }
}
