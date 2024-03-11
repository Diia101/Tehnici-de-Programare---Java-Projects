package bll.validators;

import javax.swing.*;

/**
 * @Author: Diia101
 * are ca scop validarea ID-ului
 */
public class IDValidator implements Validator<Integer> {
    /**
     *
     * @param integer
     * @return -1 daca parametru trimis cade testul si 0 in caz contrar
     */
    @Override
    public int validate(Integer integer) {
        if (integer <= 0) {
            JOptionPane.showMessageDialog(null,
                    "The ID is invalid!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return 0;
    }
}
