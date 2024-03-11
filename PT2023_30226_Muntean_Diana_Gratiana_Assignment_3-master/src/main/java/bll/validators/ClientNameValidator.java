package bll.validators;

import model.Client;

import javax.swing.*;
import java.util.regex.Pattern;

/**
 * @Author: Diia101
 * Are ca scop validarea numelui unui client
 */
public class ClientNameValidator implements Validator<Client> {
    /**
     *
     * @param client
     * @return -1 daca parametrul trimis cade testul si 0 in caz contrar
     */
    @Override
    public int validate(Client client) {
        if (!Pattern.matches("[a-zA-Z]+", client.getName())) {
            JOptionPane.showMessageDialog(null,
                    "The client name is invalid!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        if (client.getName().equals("") || client.getName().equals(" ")) {
            JOptionPane.showMessageDialog(null,
                    "The client name is invalid!",
                    "Error!",
                    JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return 0;
    }
}
