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
        Customer customer=null;
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        while (rst.next()) {
            customer=new Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4)
            );
            objectBuilder.add("id",customer.getId());
            objectBuilder.add("name",customer.getName());
            objectBuilder.add("address",customer.getAddress());
            objectBuilder.add("salery",customer.getSalery());
            arrayBuilder.add(objectBuilder.build());
        }
        return arrayBuilder.build();
    }

    @Override
    public boolean add(Customer customer) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
