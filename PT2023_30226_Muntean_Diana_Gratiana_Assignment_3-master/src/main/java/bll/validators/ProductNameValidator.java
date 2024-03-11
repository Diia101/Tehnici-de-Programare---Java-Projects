package bll.validators;

import model.Product;

import javax.swing.*;
import java.util.regex.Pattern;

/**
 * @Author: Diia101
 * Are ca scop validarea numelui unui produs
 */
public class ProductNameValidator implements Validator<Product> {
    /**
     *
     * @param product
     * @return -1 daca argumentul nu trece testul si 0 in caz contrat
     */
    @Override
    public int validate(Product product) {
        if (!Pattern.matches("[a-zA-Z]+", product.getName())) {
            JOptionPane.showMessageDialog(null,
                    "The product name is invalid!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        if (product.getName().equals("") || product.getName().equals(" ")) {
            JOptionPane.showMessageDialog(null,
                    "The product name is invalid!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return 0;
    }
}
