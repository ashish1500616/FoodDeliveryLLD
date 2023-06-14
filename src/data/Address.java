package data;

public class Address {
    private final String addressLine1;
    private final String addressLine2;
    private final String addressLine3;

    private final String state;

    private final int pinCode;

    private final String Country;


    public Address(int pinCode, String addressLine1, String addressLine2, String addressLine3, String state, String country) {
        this.pinCode = pinCode;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.addressLine3 = addressLine3;
        this.state = state;
        Country = country;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getAddressLine3() {
        return addressLine3;
    }

    public String getState() {
        return state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getCountry() {
        return Country;
    }
}
