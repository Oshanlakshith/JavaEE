package dao.custom.impl;

import dao.CrudDAO;
import dao.CrudUtil;
import entity.Item;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAOImpl implements CrudDAO<Item,String> {

    @Override
    public JsonArray getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT*FROM item");
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        while (rst.next()){
            Item item=new Item(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
            objectBuilder.add("icode",item.getIcode());
            objectBuilder.add("iname",item.getIname());
            objectBuilder.add("iuprise",item.getIprice());
            objectBuilder.add("qty",item.getQty());
            arrayBuilder.add(objectBuilder.build());
        }
        return arrayBuilder.build();
    }

    @Override
    public boolean add(Item item) throws SQLException, ClassNotFoundException {
     return CrudUtil.executeUpdate("INSERT INTO item VALUES(?,?,?,?)",item.getIcode(),item.getIname(),item.getIprice(),item.getQty());
    }

    @Override
    public boolean update(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE `item` SET `iName`=?,`uPrice`=?,`qty`=? WHERE code=?", item.getIname(), item.getIprice(), item.getQty(), item.getIcode());

    }

    @Override
    public boolean delete(String itemId) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM `item` WHERE code=?", itemId);

    }
}
