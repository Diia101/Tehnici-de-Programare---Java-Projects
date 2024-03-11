package bll;

import bll.validators.*;
import dao.OrderDAO;
import model.Orders;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Diia101
 *
 */
public class OrderBLL {
    /**
     * Clasa are ca variabile instanta o Lista de validatori care se vor apela pentru a valida noua inregistrare care se vrea
     * introdusa in baza de date,un IDValidator,un validator separat pentru ID,o instanta a clasei OrderDAO care va apela
     * metodele pentru a face legatura cu baza de date
     */
    private final List<Validator<Orders>> validators;
    private final IDValidator idValidator;
    private OrderDAO orderDAO;

    public OrderBLL() {
        validators = new ArrayList<>();
        validators.add(new QuantityOrderValidator());
        idValidator = new IDValidator();
        orderDAO = new OrderDAO();
    }
    /**
     *
     * @param order
     * Aceasta metoda valideaza comanda care se vrea inserata iar apoi apeleaza prin intermediul orderDAO metoda pentru inserare
     */
    public void insertOrder(Orders order) {
        for (Validator<Orders> v : validators) {
            if (v.validate(order) != 0)
                return;
        }
        if (idValidator.validate(order.getClientID()) != 0)
            return;
        if (idValidator.validate(order.getProductID()) != 0)
            return;

        orderDAO.insert(order);
    }
    /**
     *
     * @param orderID
     * Aceasta metoda valideaza comanda care se vrea stersa iar apoi apeleaza prin intermediul orderDAO metoda pentru
     * stergerea comenzii.
     */
    public void deleteOrder(int orderID) {
        if (idValidator.validate(orderID) != 0)
            return;

      orderDAO.deleteByID(orderID);
    }
    /**
     *
     * @param order
     * Aceasta metoda valideaza comanda ce se vrea editata iar apoi apeleaza metoda edit din orderDAO pentru a modifica informatiile
     * referitoare la comanda
     */
    public void editOrder(Orders order) {
        for (Validator<Orders> v : validators) {
            if (v.validate(order) != 0)
                return;
        }
        if (idValidator.validate(order.getID()) != 0)
            return;
        if (idValidator.validate(order.getClientID()) != 0)
            return;
        if (idValidator.validate(order.getProductID()) != 0)
            return;


       orderDAO.edit("clientID",String.valueOf(order.getClientID()),order.getID());
       orderDAO.edit("productID",String.valueOf(order.getProductID()),order.getID());
       orderDAO.edit("quantity",String.valueOf(order.getQuantity()),order.getID());
       orderDAO.edit("price",String.valueOf(order.getPrice()),order.getID());

    }
    /**
     *
     * @param id
     * @return Orders
     * Aceasta metoda valideaza id-ul primit ca parametru si returneaza comanda gasita de metoda findById din orderDAO
     */
    public Orders findByID(int id) throws SQLException {
        if (idValidator.validate(id) != 0)
            return null;

       return orderDAO.findById(id);
    }   /**
     *
     * @return ArrayList<Orders>
     *   Aceasta metoda apeleaza metoda showAll din orderDAO si returneaza o lista de comenzi existente in baza de date
     */

    public ArrayList<Orders> printAllOrders() {
        return (ArrayList<Orders>) orderDAO.showAll();
    }
}
