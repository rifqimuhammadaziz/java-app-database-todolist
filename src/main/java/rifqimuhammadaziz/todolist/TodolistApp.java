package rifqimuhammadaziz.todolist;


import rifqimuhammadaziz.todolist.repository.TodolistRepository;
import rifqimuhammadaziz.todolist.repository.TodolistRepositoryImpl;
import rifqimuhammadaziz.todolist.service.TodolistService;
import rifqimuhammadaziz.todolist.service.TodolistServiceImpl;
import rifqimuhammadaziz.todolist.util.DatabaseUtil;
import rifqimuhammadaziz.todolist.view.TodolistView;

import javax.sql.DataSource;

public class TodolistApp {
    public static void main(String[] args) {
        DataSource dataSource = DatabaseUtil.getDataSource();
        TodolistRepository todolistRepository = new TodolistRepositoryImpl(dataSource);
        TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
        TodolistView todolistView = new TodolistView(todolistService);

        todolistView.showTodolist();
    }
}
