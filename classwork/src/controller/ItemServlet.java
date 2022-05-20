package controller;

import dao.CrudDAO;
import dao.DAOFactory;
import dto.ItemDTO;
import entity.Customer;
import entity.Item;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/item")
public class ItemServlet extends HttpServlet {
    CrudDAO<ItemDTO, String> itemDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            resp.getWriter().print(itemDAO.getAll());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ItemDTO item = new ItemDTO(req.getParameter("itemcode"), req.getParameter("itemname"), req.getParameter("unitprice"), req.getParameter("quantity"));
            try {
                if (itemDAO.add(item)) {
                            resp.getWriter().print(itemDAO.add(item));
                    System.out.println("Item");
                } else {

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            JsonObject itemJson = Json.createReader(req.getReader()).readObject();
            ItemDTO item = new ItemDTO(itemJson.getString("itemcode"), itemJson.getString("itemname"), itemJson.getString("unitprice"), itemJson.getString("quantity"));

            if (itemDAO.update(item)) {
                System.out.println("Update");
            } else {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            if (itemDAO.delete(req.getParameter("itemCode"))) {

            } else {

            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
}
