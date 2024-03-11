package model;
/**
 * @Author: Diia101
 *
 */
public class Product {
    private int ID;
    private String name;
    private int quantity;
    private float price;

    public Product()
    {

    }
    public Product(String name, int quantity, float price) {
        super();
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(int ID, String name, int quantity, float price) {

        super();
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;

    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String a) {
        this.name = a;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

        public String toString(){
        return ID + ", " + "'" + this.name + "'" + ", " + this.quantity +"," + this.price;
    }


}
