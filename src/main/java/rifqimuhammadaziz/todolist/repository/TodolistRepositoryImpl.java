package rifqimuhammadaziz.todolist.repository;

import rifqimuhammadaziz.todolist.entity.Todolist;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodolistRepositoryImpl implements TodolistRepository {

    private DataSource dataSource;

    public TodolistRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Todolist[] getAll() {
        // get data from database
        String sql = "SELECT id, todo FROM todolist";
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){ // transform to result set

            // iterate result set & insert to ArrayList
            List<Todolist> list = new ArrayList<>();
            while (resultSet.next()) {
                Todolist todolist = new Todolist();
                todolist.setId(resultSet.getInt(" id"));
                todolist.setTodo(resultSet.getString("todo"));

                list.add(todolist);
            }

            // convert list toArray
            return list.toArray(new Todolist[]{});
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void add(Todolist todolist) {
        String sql = "INSERT INTO todolist(todo) VALUES(?)";

        // auto closed (with try resource)
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, todolist.getTodo());
            statement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    private boolean isDataExists(Integer number) {
        String sql = "SELECT id FROM todolist WHERE id = ?";
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, number);

            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer number) {
        // checking data
        if (isDataExists(number)) {
            // Delete data
            String sql = "DELETE FROM todolist WHERE id = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setInt(1, number);
                statement.executeUpdate();
                return true;
            } catch (SQLException exception) {
                throw new RuntimeException(exception);
            }
        } else {
            System.out.print("Data not found! ");
            return false;
        }
    }

}
