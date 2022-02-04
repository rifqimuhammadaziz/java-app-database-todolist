package rifqimuhammadaziz.todolist.service;

import rifqimuhammadaziz.todolist.entity.Todolist;
import rifqimuhammadaziz.todolist.repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService {

    private TodolistRepository todolistRepository;

    public TodolistServiceImpl(TodolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }

    @Override
    public void showTodolist() {
        System.out.println("---------------");
        System.out.println("TODOLIST");
        System.out.println("---------------");

        Todolist[] model = todolistRepository.getAll();
        for (var todolist : model) {
            System.out.println(todolist.getId() + ". " + todolist.getTodo());
        }
    }

    @Override
    public void addTodolist(String todo) {
        Todolist todolist = new Todolist(todo);
        todolistRepository.add(todolist);
        System.out.println("Success Add Todo : " + todo);
    }

    @Override
    public void removeTodolist(Integer number) {
        boolean success = todolistRepository.remove(number);
        if (success) {
            System.out.println("Success Delete Todo : " + number);
        } else {
            System.out.println("Failed Delete Todo : " + number);
        }
    }
}
