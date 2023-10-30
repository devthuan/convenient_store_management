package model;

import java.util.List;

public interface InterfaceCRUD<T> {

    void create(T entity);

    T read(int id);

    void update(int id, T entity);

    void delete(int id);

    T search(int id);
}
