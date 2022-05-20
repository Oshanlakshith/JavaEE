package dao;

import javax.json.JsonArray;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T,ID>{
JsonArray getAll() throws SQLException, ClassNotFoundException;
boolean add(T t);
boolean update(T t);
boolean delete(ID id);
}