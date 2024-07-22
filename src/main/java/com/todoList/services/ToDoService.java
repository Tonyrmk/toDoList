package com.todoList.services;

import com.todoList.entity.mok.ToDo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<ToDo>();
    private static int todoCount = 3;

    static {
        todos.add(new ToDo(1, "Tony", "Learn Spring MVC", new Date(),
                false));
        todos.add(new ToDo(2, "Jonny", "Learn Struts", new Date(), false));
        todos.add(new ToDo(3, "Josue", "Learn Hibernate", new Date(),
                false));
    }

    public List<ToDo> retrieveTodos(String user) {
        List<ToDo> filteredTodos = new ArrayList<ToDo>();
        for (ToDo todo : todos) {
            if (todo.getUser().equals(user))
                filteredTodos.add(todo);
        }
        return filteredTodos;
    }

    public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
        todos.add(new ToDo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<ToDo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            ToDo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }

    public ToDo getTodo(int id) {
        for (ToDo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    public void updateTodo(ToDo todo) {
        for (ToDo todoIs : todos) {
            if (todoIs.getId() == todo.getId()) {
                todoIs.setDesc(todo.getDesc());
                todoIs.setTargetDate(new Date());
                todoIs.setDone(todo.isDone());
            }
        }
    }
}



