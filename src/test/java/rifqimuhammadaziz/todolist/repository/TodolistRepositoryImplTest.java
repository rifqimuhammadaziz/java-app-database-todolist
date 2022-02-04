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

    @Test
    void testRemove() {
        System.out.println(todolistRepository.remove(1));
        System.out.println(todolistRepository.remove(2));
        System.out.println(todolistRepository.remove(3));
    }

    @Test
    void testGetAll() {
        todolistRepository.add(new Todolist("Xenosty"));
        todolistRepository.add(new Todolist("Rifqi"));
        todolistRepository.add(new Todolist("Bagas"));
        todolistRepository.add(new Todolist("Dimas"));

        Todolist[] todolists = todolistRepository.getAll();
        for (var todo : todolists) {
            System.out.println(todo.getId() + " : " + todo.getTodo());
        }
    }


    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
