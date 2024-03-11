package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;


import connection.ConnectionFactory;
import model.Product;
/**
 * @Author: Diia101
 *
 */
public class ProductDAO extends AbstractDAO<Product> {

   public ProductDAO()
   {
       super();
   }

    private static final String findPriceByIDString = "SELECT price FROM product WHERE ID = ?";

    /**
     *
     * @param id
     * @return float
     * Returneaza pretul unui produs in functie de id
     */
    public static float findPriceByID(int id) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findPriceByIDStatement = null;
        ResultSet rs;
        float price = 0;

        try {
            findPriceByIDStatement = dbConnection.prepareStatement(findPriceByIDString);
            findPriceByIDStatement.setInt(1, id);
            rs = findPriceByIDStatement.executeQuery();
            rs.next();
            price = rs.getFloat("price");

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ProductDAO:findPriceByID " + e.getMessage());
        } finally {
            ConnectionFactory.close(findPriceByIDStatement);
            ConnectionFactory.close(dbConnection);
        }
        return price;
    }



}
