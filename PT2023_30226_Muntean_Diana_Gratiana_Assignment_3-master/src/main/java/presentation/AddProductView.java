package presentation;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddProductView extends JFrame {

    private final JTextField nameText;
    private final JTextField quantityText;
    private final JTextField priceText;
    private final JTextField idText;
    private final JButton backBtn;
    private final JButton addBtn;


    public AddProductView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 329);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Product");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(70, 05, 120, 20);
        contentPane.add(lblNewLabel);


        JLabel lblNewLabel_2 = new JLabel("ID:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(10, 30, 50, 20);
        contentPane.add(lblNewLabel_2);

        idText = new JTextField();
        idText.setBounds(70, 30, 150, 20);
        contentPane.add(idText);
        idText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 60, 50, 20);
        contentPane.add(lblNewLabel_1);

        nameText = new JTextField();
        nameText.setBounds(70, 60, 150, 20);
        contentPane.add(nameText);
        nameText.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Quantity:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(10, 100, 60, 20);
        contentPane.add(lblNewLabel_1_1);

        quantityText = new JTextField();
        quantityText.setColumns(10);
        quantityText.setBounds(70, 100, 150, 20);
        contentPane.add(quantityText);

        JLabel lblNewLabel_1_1_1 = new JLabel("Price:");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(10, 140, 50, 20);
        contentPane.add(lblNewLabel_1_1_1);

        priceText = new JTextField();
        priceText.setColumns(10);
        priceText.setBounds(70, 140, 150, 20);
        contentPane.add(priceText);

        addBtn = new JButton("Add");
        addBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        addBtn.setBounds(78, 194, 85, 21);
        contentPane.add(addBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(141, 258, 85, 21);
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

    public String getName() {
        return this.nameText.getText();
    }

    public String getPrice() {
        return this.priceText.getText();
    }

    public String getQuantity() {
        return this.quantityText.getText();
    }

    public void repaint() {
        this.nameText.setText("");
        this.priceText.setText("");
        this.quantityText.setText("");
        this.idText.setText("");
    }

}