package bll.validators;

import model.Product;

import javax.swing.*;

/**
 * @Author: Diia101
 * Are ca scop validarea cantitatii introduse la crearea unui produs
 */
public class QuantityValidator implements Validator<Product> {
    /**
     *
     * @param product
     * @return -1 daca argumentul dat trece testul si 0 in caz contrar
     */
    @Override
    public int validate(Product product) {
        if (product.getQuantity() < 0) {
            JOptionPane.showMessageDialog(null,
                    "The product name is invalid!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return 0;
    }
}
