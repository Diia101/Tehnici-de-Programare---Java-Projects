package bll.validators;

import model.Client;

import javax.swing.*;

/**
 * @Author: Diia101
 * Aceasta clasa mosteneste interfata Validator si are ca scop validarea varstei unui client
 */
public class ClientAgeValidator implements Validator<Client> {

    private static final int MIN_AGE = 14;
    private static final int MAX_AGE = 100;

    /**
     *
     * @param t
     * @return -1 daca testul nu este trecut si 0 in caz contrat
     */
    public int validate(Client t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            JOptionPane.showMessageDialog(null,
                    "The client age is invalid!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return 0;

    }
}
