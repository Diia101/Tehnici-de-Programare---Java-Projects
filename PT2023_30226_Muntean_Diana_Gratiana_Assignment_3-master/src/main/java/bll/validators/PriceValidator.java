package bll.validators;

import model.Product;

import javax.swing.*;

/**
 * @Author: Diia101
 * Are ca scop validarea pretului unui produs
 */
public class PriceValidator implements Validator<Product> {
    /**
     *
     * @param product
     * @return -1 daca parametrul trece testul si 0 in caz contrat
     */
    @Override
    public int validate(Product product) {
        if (product.getPrice() <= 0) {
            JOptionPane.showMessageDialog(null,
                    "The price is invalid!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return 0;
    }
}
