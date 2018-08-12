package ru.stqa.pft.addressbook.model;

public class ContactRequiredData {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String birthYear;
    private final String mobilePhone;
    private String group;

    public ContactRequiredData(String firstName, String lastName, String email, String birthYear, String mobilePhone, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthYear = birthYear;
        this.mobilePhone = mobilePhone;
        this.group = group;
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
}
