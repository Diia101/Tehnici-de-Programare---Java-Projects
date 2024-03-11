package model;
/**
 * @Author : Diia101
 *
 */
public class Orders {
    private int ID;
    private int clientID;
    private int productID;
    private int quantity;
    private float price;

    public Orders()
    {}

    public Orders(int clientID, int productID, int quantity, float price) {
        super();
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;

    }

    public Orders(int ID, int clientID, int productID, int quantity, float price) {
        super();
        this.ID = ID;
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }


    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getClientID() {
        return this.clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getProductID() {
        return this.productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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

    public void setPrice(float price)
    {
        this.price=price;
    }


    public String toString(){
        return ID + ", " + this.clientID + ", " + this.productID + ", " + this.quantity + ", " + this.price;
    }

}
