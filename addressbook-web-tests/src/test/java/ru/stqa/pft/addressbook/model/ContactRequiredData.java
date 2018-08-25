package ru.stqa.pft.addressbook.model;

public class ContactRequiredData {
    private int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String birthYear;
    private final String mobilePhone;
    private String group;

    public ContactRequiredData(int id, String firstName, String lastName, String email, String birthYear, String mobilePhone, String group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthYear = birthYear;
        this.mobilePhone = mobilePhone;
        this.group = group;
    }
    public ContactRequiredData(String firstName, String lastName, String email, String birthYear, String mobilePhone, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthYear = birthYear;
        this.mobilePhone = mobilePhone;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactRequiredData that = (ContactRequiredData) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "ContactRequiredData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
