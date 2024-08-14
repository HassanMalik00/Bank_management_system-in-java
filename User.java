
package mypackage.Bank_management_system;


public class User {
    private final String userId;
    private String name;
    private String address;
    private String contact;
    private String password;

    public User(String userId, String name, String address, String contact, String password) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + "\nName: " + name + "\nAddress: " + address + "\nContact: " + contact;
    }

    void addAccount(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

