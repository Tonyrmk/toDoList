package com.todoList.services;

import com.todoList.bean.ToDo;
import java.util.Date;
import java.util.List;

public interface ToDoService {

    public List<ToDo> retrieveTodos(String user) ;

    public void addTodo(String name, String desc, Date targetDate, boolean isDone) ;

    public void deleteTodo(int id) ;

    public ToDo getTodo(int id) ;

    public void updateTodo(ToDo todo) ;

}
