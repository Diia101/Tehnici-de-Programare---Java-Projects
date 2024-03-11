package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EditClientView extends JFrame {

    private final JTextField clientIDtext;
    private final JTextField newNameText;
    private final JTextField newEmailText;
    private final JButton backBtn;
    private final JButton editBtn;
    private final JTextField newAgeText;


    public EditClientView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 260, 329);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Edit Client");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(82, 10, 120, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ID:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 60, 70, 20);
        contentPane.add(lblNewLabel_1);

        clientIDtext = new JTextField();
        clientIDtext.setBounds(85, 60, 150, 20);
        contentPane.add(clientIDtext);
        clientIDtext.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("New Name:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(10, 100, 75, 20);
        contentPane.add(lblNewLabel_1_1);

        newNameText = new JTextField();
        newNameText.setColumns(10);
        newNameText.setBounds(85, 100, 150, 20);
        contentPane.add(newNameText);

        JLabel lblNewLabel_1_1_1 = new JLabel("New Email:");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(10, 140, 75, 20);
        contentPane.add(lblNewLabel_1_1_1);

        newEmailText = new JTextField();
        newEmailText.setColumns(10);
        newEmailText.setBounds(85, 140, 150, 20);
        contentPane.add(newEmailText);

        editBtn = new JButton("Edit");
        editBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        editBtn.setBounds(84, 220, 85, 21);
        contentPane.add(editBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        backBtn.setBounds(145, 258, 85, 21);
        contentPane.add(backBtn);

        JLabel lblNewLabel_1_1_2 = new JLabel("New Age:");
        lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_2.setBounds(10, 180, 75, 20);
        contentPane.add(lblNewLabel_1_1_2);

        newAgeText = new JTextField();
        newAgeText.setColumns(10);
        newAgeText.setBounds(85, 180, 150, 20);
        contentPane.add(newAgeText);
    }

    public JButton getBackBtn() {
        return this.backBtn;
    }

    public JButton getEditBtn() {
        return this.editBtn;
    }

    public String getID() {
        return this.clientIDtext.getText();
    }

    public String getNewName() {
        return this.newNameText.getText();
    }

    public String getNewEmail() {
        return this.newEmailText.getText();
    }

    public String getNewAge() {
        return this.newAgeText.getText();
    }

    public void repaint() {
        this.clientIDtext.setText("");
        this.newAgeText.setText("");
        this.newNameText.setText("");
        this.newEmailText.setText("");
    }

}