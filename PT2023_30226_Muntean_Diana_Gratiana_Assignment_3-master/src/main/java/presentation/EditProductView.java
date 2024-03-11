package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditProductView extends JFrame {

    private final JTextField productIDtext;
    private final JTextField newNameText;
    private final JTextField newQuantityText;
    private final JButton backBtn;
    private final JButton editBtn;
    private final JTextField newPriceText;


    public EditProductView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 275, 329);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Edit Product");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(79, 10, 120, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ID:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 60, 70, 20);
        contentPane.add(lblNewLabel_1);

        productIDtext = new JTextField();
        productIDtext.setBounds(100, 60, 150, 20);
        contentPane.add(productIDtext);
        productIDtext.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("New Name:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(10, 100, 75, 20);
        contentPane.add(lblNewLabel_1_1);

        newNameText = new JTextField();
        newNameText.setColumns(10);
        newNameText.setBounds(100, 100, 150, 20);
        contentPane.add(newNameText);

        JLabel lblNewLabel_1_1_1 = new JLabel("New Quantity:");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(10, 140, 85, 20);
        contentPane.add(lblNewLabel_1_1_1);

        newQuantityText = new JTextField();
        newQuantityText.setColumns(10);
        newQuantityText.setBounds(100, 140, 150, 20);
        contentPane.add(newQuantityText);

        editBtn = new JButton("Edit");
        editBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        editBtn.setBounds(93, 220, 85, 21);
        contentPane.add(editBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(165, 261, 85, 21);
        contentPane.add(backBtn);

        JLabel lblNewLabel_1_1_2 = new JLabel("New Price:");
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(10, 180, 75, 20);
        contentPane.add(lblNewLabel_1_1_2);

        newPriceText = new JTextField();
        newPriceText.setColumns(10);
        newPriceText.setBounds(100, 180, 150, 20);
        contentPane.add(newPriceText);
    }

    public JButton getBackBtn() {
        return this.backBtn;
    }

    public JButton getEditBtn() {
        return this.editBtn;
    }

    public String getID() {
        return this.productIDtext.getText();
    }

    public String getNewName() {
        return this.newNameText.getText();
    }

    public String getNewQuantity() {
        return this.newQuantityText.getText();
    }

    public String getNewPrice() {
        return this.newPriceText.getText();
    }

    public void repaint() {
        this.productIDtext.setText("");
        this.newNameText.setText("");
        this.newQuantityText.setText("");
        this.newPriceText.setText("");
    }

}
