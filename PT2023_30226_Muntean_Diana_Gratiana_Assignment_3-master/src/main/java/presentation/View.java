package presentation;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View extends JFrame {

    private final JButton addClientBtn;
    private final JButton editClientBtn;
    private final JButton deleteClientBtn;
    private final JButton showClientsBtn;
    private final JButton addOrderBtn;
    private final JButton editOrderBtn;
    private final JButton deleteOrderBtn;
    private final JButton showOrdersBtn;
    private final JButton addProductBtn;
    private final JButton editProductBtn;
    private final JButton deleteProductBtn;
    private final JButton showProductsBtn;

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 460, 300);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addClientBtn = new JButton("AddClient");
        addClientBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        addClientBtn.setBounds(10, 75, 120, 20);
        contentPane.add(addClientBtn);

        editClientBtn = new JButton("EditClient");
        editClientBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        editClientBtn.setBounds(10, 125, 120, 20);
        contentPane.add(editClientBtn);

        deleteClientBtn = new JButton("DeleteClient");
        deleteClientBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        deleteClientBtn.setBounds(10, 175, 120, 20);
        contentPane.add(deleteClientBtn);

        showClientsBtn = new JButton("ShowClients");
        showClientsBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        showClientsBtn.setBounds(10, 225, 120, 20);
        contentPane.add(showClientsBtn);

        addOrderBtn = new JButton("AddOrder");
        addOrderBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        addOrderBtn.setBounds(315, 75, 120, 20);
        contentPane.add(addOrderBtn);

        editOrderBtn = new JButton("EditOrder");
        editOrderBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        editOrderBtn.setBounds(315, 125, 120, 20);
        contentPane.add(editOrderBtn);

        deleteOrderBtn = new JButton("DeleteOrder");
        deleteOrderBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        deleteOrderBtn.setBounds(315, 175, 120, 20);
        contentPane.add(deleteOrderBtn);

        showOrdersBtn = new JButton("ShowOrders");
        showOrdersBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        showOrdersBtn.setBounds(315, 225, 120, 20);
        contentPane.add(showOrdersBtn);

        addProductBtn = new JButton("AddProduct");
        addProductBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        addProductBtn.setBounds(162, 75, 120, 20);
        contentPane.add(addProductBtn);

        editProductBtn = new JButton("EditProduct");
        editProductBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        editProductBtn.setBounds(162, 126, 120, 20);
        contentPane.add(editProductBtn);

        deleteProductBtn = new JButton("DeleteProduct");
        deleteProductBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        deleteProductBtn.setBounds(162, 176, 120, 20);
        contentPane.add(deleteProductBtn);

        showProductsBtn = new JButton("ShowProducts");
        showProductsBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        showProductsBtn.setBounds(157, 226, 130, 20);
        contentPane.add(showProductsBtn);

        JLabel lblNewLabel = new JLabel("Warehouse");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(174, 10, 100, 20);
        contentPane.add(lblNewLabel);
    }

    public JButton getAddClientBtn() {
        return this.addClientBtn;
    }

    public JButton getEditClientBtn() {
        return this.editClientBtn;
    }

    public JButton getDeleteClientBtn() {
        return this.deleteClientBtn;
    }

    public JButton getShowClientsBtn() {
        return this.showClientsBtn;
    }

    public JButton getAddOrderBtn() {
        return this.addOrderBtn;
    }

    public JButton getEditOrderBtn() {
        return this.editOrderBtn;
    }

    public JButton getDeleteOrderBtn() {
        return this.deleteOrderBtn;
    }

    public JButton getShowOrdersBtn() {
        return this.showOrdersBtn;
    }

    public JButton getAddProductBtn() {
        return this.addProductBtn;
    }

    public JButton getEditProductBtn() {
        return this.editProductBtn;
    }

    public JButton getDeleteProductBtn() {
        return this.deleteProductBtn;
    }

    public JButton getShowProductsBtn() {
        return this.showProductsBtn;
    }
}
