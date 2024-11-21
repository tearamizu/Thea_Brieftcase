package FrontEnd;

import BackEnd.*;

import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewTransactionPage extends JFrame {
    private Brieftasche brieftasche;
    private User user;
    private DashboardPage dashboardPage;

    public NewTransactionPage(User user, Brieftasche brieftasche, DashboardPage dashboardPage) {
        this.user = user;
        this.brieftasche = brieftasche;
        this.dashboardPage = dashboardPage;
        initComponents();
        setLocationRelativeTo(null);
        setSize(600, 400);
        setResizable(false);
        setTitle("New Transaction - Thea's Brieftasche");
    }

    private void initComponents() {
        header = new JPanel();
        newTransactionLabel = new JLabel();
        body = new JPanel();
        amountLabel = new JLabel();
        amountField = new JTextField();
        typeLabel = new JLabel();
        typeField = new JComboBox<>(new String[]{"Pemasukkan", "Pengeluaran"});
        noteLabel = new JLabel();
        noteField = new JTextField();
        addButton = new JButton();
        backButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        newTransactionLabel.setText("New Transaction");
        newTransactionLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        newTransactionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        amountLabel.setText("Amount");
        amountLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        typeLabel.setText("Type");
        typeLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        noteLabel.setText("Note");
        noteLabel.setFont(new Font("SansSerif", Font.BOLD, 18));

        amountField.setFont(new Font("SansSerif", Font.PLAIN, 18));

        typeField.setFont(new Font("SansSerif", Font.PLAIN, 18));

        noteField.setFont(new Font("SansSerif", Font.PLAIN, 18));

        addButton.setText("Add");
        addButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        addButton.setPreferredSize(new Dimension(120, 40));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        backButton.setPreferredSize(new Dimension(120, 40));
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
                    .addComponent(amountField)
                    .addComponent(typeField)
                    .addComponent(noteField)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(amountLabel)
                            .addComponent(typeLabel)
                            .addComponent(noteLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(amountLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(amountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noteField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(addButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout headerLayout = new GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newTransactionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newTransactionLabel)
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

    private void addActionPerformed(ActionEvent evt) {
        String amountText = amountField.getText().trim();
        String type = (String) typeField.getSelectedItem();
        String note = noteField.getText().trim();

        if (amountText.isEmpty() || note.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi");
            return;
        }

        try {
            int amount = Integer.parseInt(amountText);
            int validationCode = user.getAccount().validateTransaction(amount, type, note);
            if (validationCode != 0) {
                JOptionPane.showMessageDialog(this, Account.getErrorMessage(validationCode));
                return;
            }

            InsertPinPage pinPage = new InsertPinPage(this, user, brieftasche);
            pinPage.setVisible(true);

            if (pinPage.isPinValid()) {
                Transaction transaction = new Transaction(amount, note, type.equals("Pemasukkan") ? TransactionType.REVENUE : TransactionType.EXPENSE);
                user.getAccount().addTransaction(transaction);
                dashboardPage.updateTransactionList();
                this.dispose();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Jumlah harus berupa angka");
        }
    }

    private void backActionPerformed(ActionEvent evt) {
        this.dispose();
    }

    // Variables declaration - do not modify
    private JPanel body;
    private JPanel header;
    private JLabel newTransactionLabel;
    private JLabel amountLabel;
    private JTextField amountField;
    private JLabel typeLabel;
    private JComboBox<String> typeField;
    private JLabel noteLabel;
    private JTextField noteField;
    private JButton addButton;
    private JButton backButton;
    // End of variables declaration
}