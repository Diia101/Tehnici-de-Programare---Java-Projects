package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditOrderView extends JFrame {

    private final JTextField orderID;
    private final JTextField newClientIDText;
    private final JTextField newProductIDText;
    private final JButton backBtn;
    private final JButton editBtn;
    private final JTextField newQuantityText;


    public EditOrderView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 295, 329);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Edit Order");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(100, 10, 120, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ID:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 60, 70, 20);
        contentPane.add(lblNewLabel_1);

        orderID = new JTextField();
        orderID.setBounds(120, 60, 150, 20);
        contentPane.add(orderID);
        orderID.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("New Client ID:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(10, 100, 90, 20);
        contentPane.add(lblNewLabel_1_1);

        newClientIDText = new JTextField();
        newClientIDText.setColumns(10);
        newClientIDText.setBounds(120, 100, 150, 20);
        contentPane.add(newClientIDText);

        JLabel lblNewLabel_1_1_1 = new JLabel("New Product ID:");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(10, 140, 110, 20);
        contentPane.add(lblNewLabel_1_1_1);

        newProductIDText = new JTextField();
        newProductIDText.setColumns(10);
        newProductIDText.setBounds(120, 140, 150, 20);
        contentPane.add(newProductIDText);

        editBtn = new JButton("Edit");
        editBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        editBtn.setBounds(105, 220, 85, 21);
        contentPane.add(editBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(180, 261, 85, 21);
        contentPane.add(backBtn);

        JLabel lblNewLabel_1_1_2 = new JLabel("New Quantity:");
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(10, 180, 90, 20);
        contentPane.add(lblNewLabel_1_1_2);

        newQuantityText = new JTextField();
        newQuantityText.setColumns(10);
        newQuantityText.setBounds(120, 180, 150, 20);
        contentPane.add(newQuantityText);
    }

    public JButton getBackBtn() {
        return this.backBtn;
    }

    public JButton getEditBtn() {
        return this.editBtn;
    }

    public String getID() {
        return this.orderID.getText();
    }

    public String getNewClientID() {
        return this.newClientIDText.getText();
    }

    public String getNewProductID() {
        return this.newProductIDText.getText();
    }

    public String getNewQuantity() {
        return this.newQuantityText.getText();
    }

    public void repaint() {
        this.newClientIDText.setText("");
        this.newProductIDText.setText("");
        this.newQuantityText.setText("");
        this.orderID.setText("");
    }
}
