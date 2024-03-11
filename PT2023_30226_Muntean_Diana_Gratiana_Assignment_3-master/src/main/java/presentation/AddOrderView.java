package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddOrderView extends JFrame {

    private final JTextField clientIDtext;
    private final JTextField productIDtext;
    private final JTextField quantityText;
    private final JTextField idText;
    private final JButton backBtn;
    private final JButton addBtn;


    public AddOrderView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 260, 329);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Order");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(80, 05, 120, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Order ID:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(10, 30, 70, 20);
        contentPane.add(lblNewLabel_2);

        idText = new JTextField();
        idText.setBounds(85, 30, 150, 20);
        contentPane.add(idText);
        idText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Client ID:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 60, 70, 20);
        contentPane.add(lblNewLabel_1);

        clientIDtext = new JTextField();
        clientIDtext.setBounds(85, 60, 150, 20);
        contentPane.add(clientIDtext);
        clientIDtext.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Product ID:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(10, 100, 75, 20);
        contentPane.add(lblNewLabel_1_1);

        productIDtext = new JTextField();
        productIDtext.setColumns(10);
        productIDtext.setBounds(85, 100, 150, 20);
        contentPane.add(productIDtext);

        JLabel lblNewLabel_1_1_1 = new JLabel("Quantity:");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(10, 140, 75, 20);
        contentPane.add(lblNewLabel_1_1_1);

        quantityText = new JTextField();
        quantityText.setColumns(10);
        quantityText.setBounds(85, 140, 150, 20);
        contentPane.add(quantityText);

        addBtn = new JButton("Add");
        addBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        addBtn.setBounds(82, 194, 85, 21);
        contentPane.add(addBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(145, 258, 85, 21);
        contentPane.add(backBtn);
    }

    public JButton getBackBtn() {
        return this.backBtn;
    }

    public JButton getAddBtn() {
        return this.addBtn;
    }

    public String getId() {
        return this.idText.getText();
    }
    public String getClientID() {
        return this.clientIDtext.getText();
    }

    public String getProductID() {
        return this.productIDtext.getText();
    }

    public String getQuantity() {
        return this.quantityText.getText();
    }

    public void repaint() {
        this.clientIDtext.setText("");
        this.productIDtext.setText("");
        this.quantityText.setText("");
        this.idText.setText("");
    }
}