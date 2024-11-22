package FrontEnd;

import BackEnd.Brieftasche;
import BackEnd.User;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends javax.swing.JFrame {
    private Brieftasche brieftasche;

    public LoginPage(Brieftasche brieftasche) {
        this.brieftasche = brieftasche;
        initComponents();
        setLocationRelativeTo(null);
        setSize(400, 300);
        setResizable(false);
        setTitle("Login - Thea's Brieftasche");
    }

    private void initComponents() {
        header = new JPanel();
        loginLabel = new JLabel();
        body = new JPanel();
        usernameLabel = new JLabel();
        username = new JTextField();
        passwordLabel = new JLabel();
        password = new JPasswordField();
        login = new JButton();
        register = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loginLabel.setText("LOGIN");
        loginLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        usernameLabel.setText("Username");
        usernameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        passwordLabel.setText("Password");
        passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        username.setFont(new Font("SansSerif", Font.PLAIN, 18));

        password.setFont(new Font("SansSerif", Font.PLAIN, 18));

        login.setText("Login");
        login.setFont(new Font("SansSerif", Font.PLAIN, 18));
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        register.setText("Register");
        register.setFont(new Font("SansSerif", Font.PLAIN, 18));
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        GroupLayout bodyLayout = new GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(username)
                    .addComponent(password)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel)
                            .addComponent(passwordLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addComponent(register)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login)))
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernameLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(register)
                    .addComponent(login))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout headerLayout = new GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(header, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(body, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void loginActionPerformed(ActionEvent evt) {
        String usernameText = username.getText().trim();
        String passwordText = new String(password.getPassword()).trim();

        int validationCode = brieftasche.validateLogin(usernameText, passwordText);
        if (validationCode != 0) {
            JOptionPane.showMessageDialog(this, Brieftasche.getErrorMessage(validationCode));
            return;
        }

        User foundUser = brieftasche.getUserByUsername(usernameText);
        new DashboardPage(foundUser, brieftasche).setVisible(true);
        this.dispose();
    }

    private void registerActionPerformed(ActionEvent evt) {
        new RegisterPage(brieftasche).setVisible(true);
        this.dispose();
    }

    // Variables declaration - do not modify
    private JPanel body;
    private JPanel header;
    private JButton login;
    private JLabel loginLabel;
    private JPasswordField password;
    private JLabel passwordLabel;
    private JButton register;
    private JTextField username;
    private JLabel usernameLabel;
    // End of variables declaration
}