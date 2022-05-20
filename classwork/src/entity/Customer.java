package entity;

public class Customer {
    private String Id;
    private String Name;
    private String Address;
    private  String Contact;
    private String Salery;

    public Customer() {
    }

    public Customer(String Id, String name, String address, String contact, String salery) {
        this.Id = Id;
        Name = name;
        Address = address;
        Contact = contact;
        Salery = salery;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getSalery() {
        return Salery;
    }

    public void setSalery(String salery) {
        Salery = salery;
    }
}
