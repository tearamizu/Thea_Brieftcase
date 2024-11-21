package BackEnd;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private PasswordSecurity password;
    private Address address;
    private Date dateOfBirth;
    private Account account;

    public User(String username, PasswordSecurity password, Address address, Date dateOfBirth, PinSecurity pin) {
        setUsername(username);
        setPassword(password);
        setAddress(address);
        setDateOfBirth(dateOfBirth);
        setAccount(new Account(pin));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PasswordSecurity getPassword() {
        return password;
    }

    public void setPassword(PasswordSecurity password) {
        this.password = password;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}