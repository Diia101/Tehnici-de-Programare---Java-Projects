package presentation;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DeleteProductView extends JFrame {

    private final JTextField idField;
    private final JButton deleteBtn;
    private final JButton backBtn;


    public DeleteProductView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 244, 215);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Delete Product");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(57, 10, 120, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ID:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(81, 60, 30, 20);
        contentPane.add(lblNewLabel_1);

        idField = new JTextField();
        idField.setBounds(108, 60, 40, 20);
        contentPane.add(idField);
        idField.setColumns(10);

        deleteBtn = new JButton("Delete");
        deleteBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        deleteBtn.setBounds(74, 90, 85, 21);
        contentPane.add(deleteBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(135, 147, 85, 21);
        contentPane.add(backBtn);
    }

    public JButton getDeleteBtn() {
        return this.deleteBtn;
    }

    public JButton getBackBtn() {
        return this.backBtn;
    }

    public String getID() {
        return this.idField.getText();
    }

    public void repaint() {
        this.idField.setText("");
    }
}
