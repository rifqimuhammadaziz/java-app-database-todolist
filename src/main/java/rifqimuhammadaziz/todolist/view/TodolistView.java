package rifqimuhammadaziz.todolist.view;

import service.TodolistService;
import util.InputUtil;

public class TodolistView {

    private TodolistService todolistService;

    public TodolistView(TodolistService todolistService) {
        this.todolistService = todolistService;
    }

    // Main Menu
    public void showTodolist() {
        while (true) {
            todolistService.showTodolist();

            System.out.println("[Choose]");
            System.out.println("[1] Add Todo");
            System.out.println("[2] Remove Todo");
            System.out.println("[x] exit application.");

            var input = InputUtil.input("Choose Menu");

            if (input.equals("1")) {
                addTodolist();
            } else if (input.equals("2")) {
                removeTodolist();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Unknown Input!");
            }
        }
    }

    // View to add Todolist
    public void addTodolist() {
        System.out.println("---------------");
        System.out.println("ADD NEW TODOLIST");
        System.out.println("---------------");

        var todo = InputUtil.input("Todo Name (x to cancel)");

        if (todo.equals("x")) {
            System.exit(1);
        } else {
            todolistService.addTodolist(todo);
        }
    }

    // View to remove Todolist
    public void removeTodolist() {
        System.out.println("---------------");
        System.out.println("REMOVE TODOLIST");
        System.out.println("---------------");

        var number = InputUtil.input("Choose Number Todo (x to cancel)");

        if (number.equals("x")) {
            showTodolist();
        } else {
            // convert input number to integer
            todolistService.removeTodolist(Integer.valueOf(number));
        }
    }

}
