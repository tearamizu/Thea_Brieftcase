package FrontEnd;

import BackEnd.Brieftasche;
import BackEnd.User;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserPage extends JFrame {
    private User user;
    private Brieftasche brieftasche;
    private boolean isPasswordVisible = false;
    private boolean isPinVisible = false;
    private boolean isVerified = false;

    public UserPage(User user, Brieftasche brieftasche) {
        this.user = user;
        this.brieftasche = brieftasche;
        initComponents();
        setLocationRelativeTo(null);
        setSize(400, 500);
        setResizable(false);
        setTitle("User Details - Thea's Brieftasche");
    }

    private void initComponents() {
        header = new JPanel();
        userLabel = new JLabel();
        body = new JPanel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        pinLabel = new JLabel();
        addressLabel = new JLabel();
        dobLabel = new JLabel();
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        pinField = new JPasswordField();
        addressField = new JTextField();
        dobField = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        userLabel.setText("User Details");
        userLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);

        usernameLabel.setText("Username:");
        usernameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        passwordLabel.setText("Password:");
        passwordLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        pinLabel.setText("PIN:");
        pinLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        addressLabel.setText("Address:");
        addressLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        dobLabel.setText("Date of Birth:");
        dobLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        usernameField.setText(user.getUsername().trim());
        usernameField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        usernameField.setEditable(false);

        passwordField.setText(new String(user.getPassword().getPassword()).trim());
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        passwordField.setEchoChar('*');
        passwordField.setEditable(false);
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isVerified) {
                    verifyPin();
                }
                togglePasswordVisibility();
            }
        });

        pinField.setText(new String(user.getAccount().getPin().getPin()).trim());
        pinField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        pinField.setEchoChar('*');
        pinField.setEditable(false);
        pinField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!isVerified) {
                    verifyPin();
                }
                togglePinVisibility();
            }
        });

        addressField.setText(user.getAddress().getProvince().trim() + ", " + user.getAddress().getCity().trim() + ", " + user.getAddress().getStreet().trim() + ", " + user.getAddress().getHouseNumber().trim());
        addressField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        addressField.setEditable(false);

        dobField.setText(user.getDateOfBirth().getDay().trim() + "-" + user.getDateOfBirth().getMonth().trim() + "-" + user.getDateOfBirth().getYear().trim());
        dobField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        dobField.setEditable(false);

        GroupLayout bodyLayout = new GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(userLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameField)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField)
                    .addComponent(pinLabel)
                    .addComponent(pinField)
                    .addComponent(addressLabel)
                    .addComponent(addressField)
                    .addComponent(dobLabel)
                    .addComponent(dobField))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pinLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pinField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dobLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dobField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout headerLayout = new GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel)
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

    private void togglePasswordVisibility() {
        if (isPasswordVisible) {
            passwordField.setEchoChar('*');
        } else {
            passwordField.setEchoChar((char) 0);
        }
        isPasswordVisible = !isPasswordVisible;
    }

    private void togglePinVisibility() {
        if (isPinVisible) {
            pinField.setEchoChar('*');
        } else {
            pinField.setEchoChar((char) 0);
        }
        isPinVisible = !isPinVisible;
    }

    private void verifyPin() {
        InsertPinPage pinPage = new InsertPinPage(this, user, brieftasche);
        pinPage.setVisible(true);

        if (pinPage.isPinValid()) {
            isVerified = true;
        }
    }

    // Variables declaration - do not modify
    private JPanel body;
    private JPanel header;
    private JLabel userLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel pinLabel;
    private JLabel addressLabel;
    private JLabel dobLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField pinField;
    private JTextField addressField;
    private JTextField dobField;
    // End of variables declaration
}