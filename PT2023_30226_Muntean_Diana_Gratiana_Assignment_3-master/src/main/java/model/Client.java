package model;
/**
 * @Author: Diia101
 *
 */
public class Client {
    private int ID;
    private String name;
    private String email;
    private int age;

    public Client()
    {

    }

    public Client(String name, String email, int age) {
        super();
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Client(int ID, String name, String email, int age) {
        super();
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.age = age;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String a) {
        this.email = a;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){
        return ID + ", " + "'" + this.name + "'" + ", "+ "'" + this.email + "'" + ","  + this.age;
    }

}
