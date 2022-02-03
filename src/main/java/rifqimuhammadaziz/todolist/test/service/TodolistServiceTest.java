package rifqimuhammadaziz.todolist.test.service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;

public class TodolistServiceTest {

    public static void main(String[] args) {
        testRemoveTodolist();
    }

    public static void testShowTodolist() {
        TodolistRepositoryImpl todolistRepository = new TodolistRepositoryImpl();
        todolistRepository.data[0] = new Todolist("Todolist pertama");
        todolistRepository.data[1] = new Todolist("Todolist kedua");
        todolistRepository.data[2] = new Todolist("Todolist ketiga");

        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.showTodolist();
    }

    public static void testAddTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.addTodolist("Todolist Test 1");
        todolistService.addTodolist("Todolist Test 2");
        todolistService.addTodolist("Todolist Test 3");
        todolistService.addTodolist("Todolist Test 4");

        todolistService.showTodolist();
    }

    public static void testRemoveTodolist() {
        TodolistRepository todolistRepository = new TodolistRepositoryImpl();
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);

        todolistService.addTodolist("Todolist Test 1");
        todolistService.addTodolist("Todolist Test 2");
        todolistService.addTodolist("Todolist Test 3");
        todolistService.addTodolist("Todolist Test 4");

        todolistService.showTodolist();

        todolistService.removeTodolist(3);
        todolistService.showTodolist();
        todolistService.removeTodolist(3);
        todolistService.showTodolist();
        todolistService.removeTodolist(3);
        todolistService.showTodolist();
    }
}
