package controller;

import dao.CrudDAO;
import dao.DAOFactory;
import entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    CrudDAO<Customer,String>customerDAO= DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* try {
            Customer customer=new Customer(req.getParameter("txtCustomerId"),req.getParameter("txtCustomerName"), req.getParameter("txtCustomerAddress"), req.getParameter("txtCustomerContact"),req.getParameter("txtCustomerSalary"));
            customerDAO.add(customer);
            System.out.println(customer);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}
