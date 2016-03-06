package shop.service;

import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
/**
 * Created by oleg on 05.03.16.
 */
@Transactional
public interface Service<T> {
    List<T> getAll() throws SQLException;

    T getById(Integer id) throws SQLException;

    void delete(T o) throws SQLException;

    T insert(T o) throws SQLException;

    T update(T o) throws SQLException;
}
