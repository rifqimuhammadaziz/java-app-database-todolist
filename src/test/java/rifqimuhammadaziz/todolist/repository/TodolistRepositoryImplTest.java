package rifqimuhammadaziz.todolist.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rifqimuhammadaziz.todolist.entity.Todolist;
import rifqimuhammadaziz.todolist.util.DatabaseUtil;

import javax.sql.DataSource;

public class TodolistRepositoryImplTest {

    private HikariDataSource dataSource;
    private TodolistRepository todolistRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getDataSource();
        todolistRepository = new TodolistRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        Todolist todolist = new Todolist();
        todolist.setTodo("Second Todo");

        todolistRepository.add(todolist);
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
