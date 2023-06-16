package data;

public class User {
    private final int id;
    private final String name;
    private final Address address;
    private final String phoneNumber;
    private final String email;


    public User(int id, String name, Address addres, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.address = addres;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }
}
