package FrontEnd;

import BackEnd.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class RegisterPage extends JFrame {
    private Brieftasche brieftasche;
    private boolean isPasswordVisible = false;
    private boolean isConfirmPasswordVisible = false;
    private boolean isPinVisible = false;

    public RegisterPage(Brieftasche brieftasche) {
        this.brieftasche = brieftasche;
        initComponents();
        setLocationRelativeTo(null);
        setSize(550, 775);
        setResizable(false);
        setTitle("Register - Thea's Brieftasche");
    }

    private void initComponents() {
        header = new JPanel();
        registerLabel = new JLabel();
        body = new JPanel();
        usernameLabel = new JLabel();
        usernameField = new JTextField();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        confirmPasswordLabel = new JLabel();
        confirmPasswordField = new JPasswordField();
        addressLabel = new JLabel();
        provinceLabel = new JLabel();
        provinceField = new JTextField();
        cityLabel = new JLabel();
        cityField = new JTextField();
        streetLabel = new JLabel();
        streetField = new JTextField();
        houseNumberLabel = new JLabel();
        houseNumberField = new JTextField();
        dobLabel = new JLabel();
        dobField = new JTextField();
        pinLabel = new JLabel();
        pinField = new JPasswordField();
        registerButton = new JButton();
        backButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        registerLabel.setText("Register");
        registerLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Font labelFont = new Font("SansSerif", Font.BOLD, 18);
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 18);

        usernameLabel.setText("Username:");
        usernameLabel.setFont(labelFont);

        passwordLabel.setText("Password:");
        passwordLabel.setFont(labelFont);

        confirmPasswordLabel.setText("Confirm Password:");
        confirmPasswordLabel.setFont(labelFont);

        addressLabel.setText("Address:");
        addressLabel.setFont(labelFont);

        provinceLabel.setText("Province:");
        provinceLabel.setFont(fieldFont);

        cityLabel.setText("City:");
        cityLabel.setFont(fieldFont);

        streetLabel.setText("Street:");
        streetLabel.setFont(fieldFont);

        houseNumberLabel.setText("House Number:");
        houseNumberLabel.setFont(fieldFont);

        dobLabel.setText("Date of Birth (dd-mm-yyyy):");
        dobLabel.setFont(labelFont);

        pinLabel.setText("PIN:");
        pinLabel.setFont(labelFont);

        usernameField.setFont(fieldFont);
        passwordField.setFont(fieldFont);
        passwordField.setEchoChar('*');
        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    togglePasswordVisibility();
                }
            }
        });

        confirmPasswordField.setFont(fieldFont);
        confirmPasswordField.setEchoChar('*');
        confirmPasswordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    toggleConfirmPasswordVisibility();
                }
            }
        });

        pinField.setFont(fieldFont);
        pinField.setEchoChar('*');
        pinField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    togglePinVisibility();
                }
            }
        });

        provinceField.setFont(fieldFont);
        cityField.setFont(fieldFont);
        streetField.setFont(fieldFont);
        houseNumberField.setFont(fieldFont);
        dobField.setFont(fieldFont);
        pinField.setFont(fieldFont);

        registerButton.setText("Register");
        registerButton.setFont(fieldFont);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.setFont(fieldFont);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        GroupLayout bodyLayout = new GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(usernameField)
                    .addComponent(passwordField)
                    .addComponent(confirmPasswordField)
                    .addComponent(provinceField)
                    .addComponent(cityField)
                    .addComponent(streetField)
                    .addComponent(houseNumberField)
                    .addComponent(dobField)
                    .addComponent(pinField)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(usernameLabel)
                            .addComponent(passwordLabel)
                            .addComponent(confirmPasswordLabel)
                            .addComponent(addressLabel)
                            .addComponent(provinceLabel)
                            .addComponent(cityLabel)
                            .addComponent(streetLabel)
                            .addComponent(houseNumberLabel)
                            .addComponent(dobLabel)
                            .addComponent(pinLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, bodyLayout.createSequentialGroup()
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registerButton)))
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernameLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPasswordLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(provinceLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(provinceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cityLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(streetLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(streetField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(houseNumberLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(houseNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dobLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dobField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pinLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pinField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(registerButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout headerLayout = new GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(registerLabel)
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

    private void toggleConfirmPasswordVisibility() {
        if (isConfirmPasswordVisible) {
            confirmPasswordField.setEchoChar('*');
        } else {
            confirmPasswordField.setEchoChar((char) 0);
        }
        isConfirmPasswordVisible = !isConfirmPasswordVisible;
    }

    private void togglePinVisibility() {
        if (isPinVisible) {
            pinField.setEchoChar('*');
        } else {
            pinField.setEchoChar((char) 0);
        }
        isPinVisible = !isPinVisible;
    }

    private void registerActionPerformed(ActionEvent evt) {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();
        String confirmPassword = new String(confirmPasswordField.getPassword()).trim();
        String province = provinceField.getText().trim();
        String city = cityField.getText().trim();
        String street = streetField.getText().trim();
        String houseNumber = houseNumberField.getText().trim();
        String dob = dobField.getText().trim();
        String pin = new String(pinField.getPassword()).trim();

        // Validate inputs
        int validationCode = brieftasche.validateRegistration(username, password, confirmPassword, province, city, street, houseNumber, dob, pin);
        if (validationCode != 0) {
            JOptionPane.showMessageDialog(this, Brieftasche.getErrorMessage(validationCode));
            return;
        }

        // Create new user
        Address address = new Address(province, city, street, houseNumber);
        Date dateOfBirth = new Date(dob.split("-")[0], dob.split("-")[1], dob.split("-")[2]);
        PasswordSecurity passwordSecurity = new PasswordSecurity(password);
        PinSecurity pinSecurity = new PinSecurity(pin.charAt(0), pin.charAt(1), pin.charAt(2), pin.charAt(3));

        brieftasche.addNewUser(username, passwordSecurity, address, dateOfBirth, pinSecurity);
        User newUser = brieftasche.getUsers().get(brieftasche.getUsers().size() - 1);
        new DashboardPage(newUser, brieftasche).setVisible(true);
        this.dispose();
    }

    private void backActionPerformed(ActionEvent evt) {
        new LoginPage(brieftasche).setVisible(true);
        this.dispose();
    }

    // Variables declaration - do not modify
    private JPanel body;
    private JPanel header;
    private JLabel registerLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel confirmPasswordLabel;
    private JPasswordField confirmPasswordField;
    private JLabel addressLabel;
    private JLabel provinceLabel;
    private JTextField provinceField;
    private JLabel cityLabel;
    private JTextField cityField;
    private JLabel streetLabel;
    private JTextField streetField;
    private JLabel houseNumberLabel;
    private JTextField houseNumberField;
    private JLabel dobLabel;
    private JTextField dobField;
    private JLabel pinLabel;
    private JPasswordField pinField;
    private JButton registerButton;
    private JButton backButton;
    // End of variables declaration
}