package BackEnd;

import java.io.Serializable;

public class PinSecurity implements Security, Serializable {
    private char[] pin;

    public PinSecurity(char... pin) {
        this.pin = pin;
    }

    @Override
    public boolean checkAttribute(String x) {
        return x.equals(new String(pin));
    }

    public char[] getPin() {
        return pin;
    }

    public int validatePin(String pin) {
        if (pin.length() != 4) {
            return 1;
        }
        if (!pin.matches("\\d{4}")) {
            return 2;
        }
        return 0;
    }

    public static String getErrorMessage(int errorCode) {
        switch (errorCode) {
            case 1:
                return "PIN harus memiliki 4 digit";
            case 2:
                return "PIN harus hanya terdiri dari angka";
            default:
                return "PIN tidak valid";
        }
    }
}