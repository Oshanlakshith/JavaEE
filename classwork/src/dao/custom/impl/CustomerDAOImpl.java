package dao.custom.impl;

import dao.CrudDAO;
import dao.CrudUtil;
import entity.Customer;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAOImpl implements CrudDAO<Customer,String> {
    @Override
    public JsonArray getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM Customer");
        Customer customer;
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        while (rst.next()) {
            customer=new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5)
            );
            objectBuilder.add("id",customer.getId());
            objectBuilder.add("name",customer.getName());
            objectBuilder.add("address",customer.getAddress());
            objectBuilder.add("contact",customer.getContact());
            objectBuilder.add("salery",customer.getSalery());
            arrayBuilder.add(objectBuilder.build());
        }
        return arrayBuilder.build();
    }

    @Override
    public boolean add(Customer customer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

  /*  @Override
    public boolean add(Customer customer) throws SQLException, ClassNotFoundException {
  *//*     return CrudUtil.executeUpdate("INSERT INTO Customer VALUES(?,?,?,?)",
               customer.getId(),
               customer.getName(),
               customer.getAddress(),
               customer.getContact(),
               customer.getSalery());*//*
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
       return CrudUtil.executeUpdate("UPDATE customer SET name=?,address=?,salery=? WHERE id=?",
               customer.getName(),
               customer.getAddress(),
               customer.getContact(),
               customer.getSalery(),
               customer.getId()
       );
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM customer WHERE id=?",id);
    }*/
}
