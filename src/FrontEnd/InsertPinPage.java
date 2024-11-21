package FrontEnd;

import BackEnd.Brieftasche;
import BackEnd.PinSecurity;
import BackEnd.User;

import javax.swing.*;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertPinPage extends JDialog {
    private Brieftasche brieftasche;
    private User user;
    private boolean isPinValid;
    private int attempts = 0;
    private static final int MAX_ATTEMPTS = 3;

    public InsertPinPage(Frame parent, User user, Brieftasche brieftasche) {
        super(parent, "Insert PIN", true);
        this.user = user;
        this.brieftasche = brieftasche;
        initComponents();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        pinLabel = new JLabel();
        pinField = new JPasswordField();
        submitButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        pinLabel.setText("Enter PIN:");
        pinLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        pinField.setFont(new Font("SansSerif", Font.PLAIN, 18));

        submitButton.setText("Submit");
        submitButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pinField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pinLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 100, Short.MAX_VALUE)
                        .addComponent(submitButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pinLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pinField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submitButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void submitActionPerformed(ActionEvent evt) {
        String pin = new String(pinField.getPassword()).trim();

        int validationCode = user.getAccount().getPin().validatePin(pin);
        if (validationCode != 0) {
            JOptionPane.showMessageDialog(this, PinSecurity.getErrorMessage(validationCode));
            return;
        }

        if (user.getAccount().getPin().checkAttribute(pin)) {
            isPinValid = true;
            dispose();
        } else {
            attempts++;
            if (attempts >= MAX_ATTEMPTS) {
                JOptionPane.showMessageDialog(this, "Anda telah salah memasukkan PIN sebanyak 3 kali. Kembali ke halaman login.");
                for (Window window : Window.getWindows()) {
                    window.dispose();
                }
                new LoginPage(brieftasche).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "PIN salah. Anda memiliki " + (MAX_ATTEMPTS - attempts) + " kesempatan lagi.");
            }
        }
    }

    public boolean isPinValid() {
        return isPinValid;
    }

    // Variables declaration - do not modify
    private JLabel pinLabel;
    private JPasswordField pinField;
    private JButton submitButton;
    // End of variables declaration
}