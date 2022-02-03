package rifqimuhammadaziz.todolist.repository;

import rifqimuhammadaziz.todolist.entity.Todolist;

public interface TodolistRepository {

    Todolist[] getAll();

    void add(Todolist todolist);
    boolean remove(Integer number);

}
