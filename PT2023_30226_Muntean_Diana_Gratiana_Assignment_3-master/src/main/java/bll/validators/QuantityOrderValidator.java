package bll.validators;


import model.Orders;

import javax.swing.*;

/**
 * @Author: Diia101
 * Are ca scop validarea cantitatii date la momentul crearii unei comenzi
 */
    public class QuantityOrderValidator implements Validator<Orders> {
    /**
     *
     * @param order
     * @return -1 daca argumentul dat nu trece testul si 0 in caz contrar
     */
    @Override
    public int validate(Orders order) {
        if (order.getQuantity() < 0) {
            JOptionPane.showMessageDialog(null,
                    "The quantity is invalid!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return 0;
    }
}
