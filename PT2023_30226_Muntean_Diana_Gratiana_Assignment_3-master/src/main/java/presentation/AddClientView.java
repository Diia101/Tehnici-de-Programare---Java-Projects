package presentation;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddClientView extends JFrame {

    private final JTextField nameText;
    private final JTextField emailText;
    private final JTextField ageText;
    private final JTextField idText;
    private final JButton backBtn;
    private final JButton addBtn;


    public AddClientView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 329);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Add Client");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblNewLabel.setBounds(75, 05, 100, 20);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("ID:");
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(10, 30, 50, 20);
        contentPane.add(lblNewLabel_2);

        idText = new JTextField();
        idText.setBounds(54, 30, 150, 20);
        contentPane.add(idText);
        idText.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Name:");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 60, 50, 20);
        contentPane.add(lblNewLabel_1);

        nameText = new JTextField();
        nameText.setBounds(54, 60, 150, 20);
        contentPane.add(nameText);
        nameText.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Email:");
        lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(10, 100, 50, 20);
        contentPane.add(lblNewLabel_1_1);

        emailText = new JTextField();
        emailText.setColumns(10);
        emailText.setBounds(54, 100, 150, 20);
        contentPane.add(emailText);

        JLabel lblNewLabel_1_1_1 = new JLabel("Age:");
        lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(10, 140, 50, 20);
        contentPane.add(lblNewLabel_1_1_1);

        ageText = new JTextField();
        ageText.setColumns(10);
        ageText.setBounds(54, 140, 150, 20);
        contentPane.add(ageText);

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

    public String getName() {
        return this.nameText.getText();
    }

    public String getId() {
        return this.idText.getText();
    }

    public String getEmail() {
        return this.emailText.getText();
    }

    public String getAge() {
        return this.ageText.getText();
    }

    public void repaint() {
        this.nameText.setText("");
        this.emailText.setText("");
        this.ageText.setText("");
        this.idText.setText("");
    }

}

