package BackEnd;

import java.io.Serializable;

public class PasswordSecurity implements Security, Serializable {
    private String password;

    public PasswordSecurity(String password) {
        if (isValidPassword(password) != 0)
            return;
        else
            this.password = password;
    }

    @Override
    public boolean checkAttribute(String x) {
        return x.equals(password);
    }

    public String getPassword() {
        return password;
    }

    private int isValidPassword(String password) {
        boolean hasLetter = false;
        boolean hasDigit = false;

        if (password.length() < 8)
            return 1;

        for (char c : password.toCharArray()) {
            if (Character.isLetter(c))
                hasLetter = true;
            else if (Character.isDigit(c))
                hasDigit = true;
        }

        if (hasDigit && hasLetter) {
            return 0;
        } else {
            return 2;
        }
    }
}