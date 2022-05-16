package dao;


import Dao.Custom.Impl.CustomerDaoImpl;
import Dao.Custom.Impl.ItemDaoImpl;
import Dao.Custom.Impl.OrderDaoImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return  new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER
    }
}

