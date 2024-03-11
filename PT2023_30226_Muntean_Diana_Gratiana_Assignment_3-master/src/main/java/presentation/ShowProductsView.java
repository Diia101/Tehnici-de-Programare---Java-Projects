package presentation;

import model.Product;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

    public class ShowProductsView extends JFrame {

    private final JButton backBtn;


    public ShowProductsView(JTable jTable) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 500);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Products");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(130, 10, 90, 20);
        contentPane.add(lblNewLabel);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(225, 432, 85, 21);
        contentPane.add(backBtn);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 320, 350);
        contentPane.add(scrollPane);

        JTable table = jTable;
        scrollPane.setViewportView(table);
    }

    public JButton getBackBtn() {
        return this.backBtn;
    }
}
