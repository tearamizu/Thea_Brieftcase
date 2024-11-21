package FrontEnd;

import BackEnd.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DashboardPage extends JFrame {
    private Brieftasche brieftasche;
    private User user;
    private UserPage userPage;
    private NewTransactionPage newTransactionPage;

    public DashboardPage(User user, Brieftasche brieftasche) {
        this.user = user;
        this.brieftasche = brieftasche;
        initComponents();
        setLocationRelativeTo(null);
        setSize(800, 600);
        setResizable(false);
        setTitle("Dashboard - Thea's Brieftasche");
    }

    private void initComponents() {
        header = new JPanel();
        userLabel = new JLabel();
        balanceLabel = new JLabel();
        body = new JPanel();
        transactionList = new JList<>();
        transactionScrollPane = new JScrollPane(transactionList);
        addTransactionButton = new JButton();
        logoutButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        userLabel.setText("Logged in: " + user.getUsername());
        userLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        userLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        userLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openUserPage();
            }
        });

        balanceLabel.setText("Balance: Rp " + user.getAccount().getBalance());
        balanceLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        balanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        updateTransactionList();

        addTransactionButton.setText("Add Transaction");
        addTransactionButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        addTransactionButton.setPreferredSize(new Dimension(200, 40));
        addTransactionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                openNewTransactionPage();
            }
        });

        logoutButton.setText("Logout");
        logoutButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        logoutButton.setPreferredSize(new Dimension(200, 40));
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        GroupLayout headerLayout = new GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(balanceLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balanceLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout bodyLayout = new GroupLayout(body);
        body.setLayout(bodyLayout);
        bodyLayout.setHorizontalGroup(
            bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(transactionScrollPane)
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(addTransactionButton))
                    .addGroup(bodyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        bodyLayout.setVerticalGroup(
            bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(bodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(transactionScrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(addTransactionButton))
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

    public void updateTransactionList() {
        ArrayList<Transaction> transactions = user.getAccount().getTransactionList();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Transaction transaction : transactions) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            listModel.addElement(dateFormat.format(transaction.getDate().toDate()) + ": " + transaction.getType() + " - Rp " + transaction.getAmount() + " (" + transaction.getNote() + ")");
        }
        transactionList.setModel(listModel);
        transactionList.setCellRenderer(new DefaultListCellRenderer() {
            private final Color expenseColor = new Color(166, 13, 13);
            private final Color revenueColor = new Color(33, 182, 22);
            private final Color selectedExpenseColor = new Color(158, 15, 15);
            private final Color selectedRevenueColor = new Color(21, 169, 21);

            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                String transaction = (String) value;
                if (transaction.contains("EXPENSE")) {
                    component.setForeground(expenseColor);
                    if (isSelected) {
                        component.setForeground(selectedExpenseColor);
                    }
                } else if (transaction.contains("REVENUE")) {
                    component.setForeground(revenueColor);
                    if (isSelected) {
                        component.setForeground(selectedRevenueColor);
                    }
                }
                if (isSelected) {
                    component.setBackground(list.getSelectionBackground());
                } else {
                    component.setBackground(list.getBackground());
                }
                return component;
            }
        });
        balanceLabel.setText("Balance: Rp " + user.getAccount().getBalance());
        if (!listModel.isEmpty()) {
            transactionList.ensureIndexIsVisible(listModel.getSize() - 1);
        }
    }

    private void openUserPage() {
        if (userPage != null) {
            userPage.dispose();
        }
        userPage = new UserPage(user, brieftasche);
        userPage.setVisible(true);
    }

    private void openNewTransactionPage() {
        if (newTransactionPage != null) {
            newTransactionPage.dispose();
        }
        newTransactionPage = new NewTransactionPage(user, brieftasche, this);
        newTransactionPage.setVisible(true);
    }

    private void logoutActionPerformed(ActionEvent evt) {
        for (Window window : Window.getWindows()) {
            if (!(window instanceof LoginPage)) {
                window.dispose();
            }
        }
        new LoginPage(brieftasche).setVisible(true);
    }

    // Variables declaration - do not modify
    private JPanel body;
    private JPanel header;
    private JLabel userLabel;
    private JLabel balanceLabel;
    private JList<String> transactionList;
    private JScrollPane transactionScrollPane;
    private JButton addTransactionButton;
    private JButton logoutButton;
    // End of variables declaration
}