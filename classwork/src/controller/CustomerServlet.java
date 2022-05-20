package controller;

import dao.CrudDAO;
import dao.DAOFactory;
import entity.Customer;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CrudDAO<Customer, String> customerDAO = DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            resp.getWriter().print(customerDAO.getAll());

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Customer customer = new Customer(req.getParameter("txtCustomerId"), req.getParameter("txtCustomerName"), req.getParameter("txtCustomerAddress"), req.getParameter("txtCustomerContact"), req.getParameter("txtCustomerSalary"));
            customerDAO.add(customer);
            System.out.println(customer);

            PrintWriter writer = resp.getWriter();
            writer.print(resp);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JsonObject customerJson = Json.createReader(req.getReader()).readObject();
            Customer customer = new Customer(customerJson.getString("Id"), customerJson.getString("Name"), customerJson.getString("Address"), customerJson.getString("Contact"), customerJson.getString("Salery"));

            if (customerDAO.update(customer)) {
                System.out.println(customer);

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

            if (customerDAO.delete(req.getParameter("customerId"))) {
                PrintWriter writer = resp.getWriter();
                writer.print(resp);
            } else {

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}