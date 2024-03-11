package start;

import java.io.IOException;
import java.util.logging.Logger;

import presentation.Controller;
import presentation.View;

/**
 * @Author: Diia101
 */
public class Start {
    protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

    public static void main(String[] args) throws IOException {

        View view = new View();
        new Controller(view);

    }

}
