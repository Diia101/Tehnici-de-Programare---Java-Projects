package bll;

import bll.validators.*;
import dao.ProductDAO;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @Author: Diia101
 *
 */
public class ProductBLL {
    /**
     * Clasa are ca variabile instanta o Lista de validatori care se vor apela pentru a valida noua inregistrare care se vrea
     * introdusa in baza de date,un IDValidator,un validator separat pentru ID,o instanta a clasei ProductDAO care va apela
     * metodele pentru a face legatura cu baza de date
     */
    private final List<Validator<Product>> validators;
    private final IDValidator idValidator;
    private ProductDAO productDAO;

    public ProductBLL() {
        validators = new ArrayList<>();
        validators.add(new PriceValidator());
        validators.add(new ProductNameValidator());
        validators.add(new QuantityValidator());
        idValidator = new IDValidator();
        productDAO = new ProductDAO();
    }
    /**
     *
     * @param product
     * Aceasta metoda valideaza produsul care se vrea inserat iar apoi apeleaza prin intermediul productDAO metoda pentru inserare
     */
    public void insertProduct(Product product) {
        for (Validator<Product> v : validators) {
            if (v.validate(product) != 0)
                return;
        }
       productDAO.insert(product);
    }

    public float findPriceByID(int id) throws SQLException {
        if (idValidator.validate(id) != 0)
            return -1;

        return ProductDAO.findPriceByID(id);
    }
    /**
     *
     * @param id
     * @return Product
     * Aceasta metoda valideaza id-ul primit ca parametru si returneaza produsul gasit de metoda findById din productDAO
     */
    public Product findByID(int id) throws SQLException {
        if (idValidator.validate(id) != 0)
            return null;

        return productDAO.findById(id);
    }
    /**
     *
     * @param productID
     * Aceasta metoda valideaza produsul care se vrea sters iar apoi apeleaza prin intermediul productDAO metoda pentru
     * stergerea produsului.
     */
    public void deleteProduct(int productID) {
        if (idValidator.validate(productID) != 0)
            return;

      productDAO.deleteByID(productID);
    }

    /**
     *
     * @param product
     * Aceasta metoda valideaza produsul ce se vrea sters iar apoi apeleaza metoda edit din productDAO pentru a modifica informatiile
     * referitoare la produs
     */
    public void editProduct(Product product) {
        for (Validator<Product> v : validators) {
            if (v.validate(product) != 0)
                return;
        }
        if (idValidator.validate(product.getID()) != 0)
            return;

       productDAO.edit("name",product.getName(),product.getID());
       productDAO.edit("quantity",String.valueOf(product.getQuantity()),product.getID());
       productDAO.edit("price",String.valueOf(product.getPrice()), product.getID());

    }
    /**
     *
     * @return ArrayList<Product>
     *   Aceasta metoda apeleaza metoda showAll din productDAO si returneaza o lista de produse existente in baza de date
     */
    public ArrayList<Product> printAllProducts() {
        return (ArrayList<Product>) productDAO.showAll();
    }

}
