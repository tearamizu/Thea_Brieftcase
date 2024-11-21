package BackEnd;

import java.io.*;
import java.util.ArrayList;

public class Brieftasche {
    private int userCount;
    private ArrayList<User> users;

    public Brieftasche() {
        this.userCount = 0;
        this.users = new ArrayList<>();
    }

    public void addNewUser(String username, PasswordSecurity password, Address address, Date dateOfBirth, PinSecurity pin) {
        User newUser = new User(username, password, address, dateOfBirth, pin);
        users.add(newUser);
        userCount++;
    }

    public int getUserCount() {
        return userCount;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public int validateLogin(String username, String password) {
        User user = getUserByUsername(username);
        if (user == null) {
            return 1; // Username tidak ditemukan
        }
        if (!user.getPassword().checkAttribute(password)) {
            return 2; // Password salah
        }
        return 0; // Login berhasil
    }

    public int validateRegistration(String username, String password, String confirmPassword, String province, String city, String street, String houseNumber, String dob, String pin) {
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || province.isEmpty() || city.isEmpty() || street.isEmpty() || houseNumber.isEmpty() || dob.isEmpty() || pin.isEmpty()) {
            return 1; // Semua field harus diisi
        }
        if (getUserByUsername(username) != null) {
            return 9; // Username sudah ada
        }
        if (!password.equals(confirmPassword)) {
            return 2; // Password dan konfirmasi password tidak cocok
        }
        if (password.length() < 8) {
            return 3; // Password harus lebih dari 8 karakter
        }
        if (!password.matches(".*[a-zA-Z].*") || !password.matches(".*\\d.*")) {
            return 4; // Password harus memiliki karakter dan angka
        }
        if (!houseNumber.matches("\\d+")) {
            return 5; // Nomor rumah harus hanya terdiri dari angka
        }
        if (pin.length() != 4 || !pin.matches("\\d{4}")) {
            return 6; // PIN harus memiliki 4 digit dan hanya terdiri dari angka
        }
        String[] dobParts = dob.split("-");
        if (dobParts.length != 3 || dobParts[0].equals("00") || dobParts[1].equals("00") || dobParts[2].equals("0000")) {
            return 7; // Format tanggal lahir tidak valid
        }
        int day = Integer.parseInt(dobParts[0]);
        int month = Integer.parseInt(dobParts[1]);
        int year = Integer.parseInt(dobParts[2]);
        if (month < 1 || month > 12 || day < 1 || day > Date.daysInMonth(month, year)) {
            return 8;
        }
        return 0;
    }

    public static String getErrorMessage(int errorCode) {
        switch (errorCode) {
            case 1:
                return "Username tidak ditemukan";
            case 2:
                return "Password salah";
            case 3:
                return "Password harus lebih dari 8 karakter";
            case 4:
                return "Password harus memiliki karakter dan angka";
            case 5:
                return "Nomor rumah harus hanya terdiri dari angka";
            case 6:
                return "PIN harus memiliki 4 digit dan hanya terdiri dari angka";
            case 7:
                return "Format tanggal lahir tidak valid";
            case 8:
                return "Tanggal tidak valid untuk bulan dan tahun yang diberikan";
            case 9:
                return "Username sudah ada";
            default:
                return "Registrasi tidak valid";
        }
    }

    public void saveTransactionsToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadTransactionsFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            users = (ArrayList<User>) ois.readObject();
            userCount = users.size();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}