package bll;

import java.util.ArrayList;
import java.util.List;


import bll.validators.*;
import dao.ClientDAO;
import model.Client;

/**
 * @Author: Diia101
 *
 */
public class ClientBLL {
    /**
     * Clasa are ca variabile instanta o Lista de validatori care se vor apela pentru a valida noua inregistrare care se vrea
     * introdusa in baza de date,un IDValidator,un validator separat pentru ID,o instanta a clasei ClientDAO care va apela
     * metodele pentru a face legatura cu baza de date
     */
    private final List<Validator<Client>> validators;
    private final IDValidator idValidator;
    private ClientDAO clientDAO;


    public ClientBLL() {
        validators = new ArrayList<>();
        validators.add(new EmailValidator());
        validators.add(new ClientAgeValidator());
        validators.add(new ClientNameValidator());
        idValidator = new IDValidator();
        clientDAO = new ClientDAO();
    }

    /**
     *
     * @param client
     * Aceasta metoda valideaza clientul care se vrea inserat iar apoi apeleaza prin intermediul clientDAO metoda pentru inserare
     */
    public void insertClient(Client client) {
        for (Validator<Client> v : validators) {
            if (v.validate(client) != 0)
                return;
        }
        clientDAO.insert(client);
    }

    /**
     *
     * @param clientID
     * Aceasta metoda valideaza clientul care se vrea sters iar apoi apeleaza prin intermediul clientDAO metoda pentru
     * stergerea clientului.
     */
    public void deleteClient(int clientID) {
        if (idValidator.validate(clientID) != 0)
            return;
        clientDAO.deleteByID(clientID);
    }

    /**
     *
     * @param client
     * Aceasta metoda valideaza clientul ce se vrea editat iar apoi apeleaza metoda edit din ClientDAO pentru a modifica informatiile
     * referitoare la Client
     */
    public void editClient(Client client) {
        for (Validator<Client> v : validators) {
            if (v.validate(client) != 0)
                return;
        }
        if (idValidator.validate(client.getID()) != 0)
            return;
        clientDAO.edit("name",client.getName(),client.getID());
        clientDAO.edit("email", client.getEmail(),client.getID());
        clientDAO.edit("age",String.valueOf(client.getAge()), client.getID());
    }

    /**
     *
     * @return ArrayList<Client>
     *   Aceasta metoda apeleaza metoda showAll din clientDAO si returneaza o lista de clienti existenti in baza de date
     */
    public ArrayList<Client> printAllClients() {
        return (ArrayList<Client>) clientDAO.showAll();
    }

    /**
     *
     * @param id
     * @return Client
     * Aceasta metoda valideaza id-ul primit ca parametru si returneaza clientul gasit de metoda findById din clientDAO
     */
    public Client findByID(int id)
    {
        if(idValidator.validate(id)!=0)
            return null;

        return clientDAO.findById(id);
    }
}
