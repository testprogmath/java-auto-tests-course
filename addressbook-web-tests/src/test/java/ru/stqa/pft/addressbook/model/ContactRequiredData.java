package ru.stqa.pft.addressbook.model;

public class ContactRequiredData {
    private int id=Integer.MAX_VALUE;
    private String firstName;
    private  String lastName;
    private  String email;
    private  String birthYear;
    private  String mobilePhone;
    private String group;
    private String homePhone;
    private String workPhone;

    public String getAllPhones() {
        return allPhones;
    }


    private String allPhones;

    public ContactRequiredData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactRequiredData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public ContactRequiredData withBirthYear(String birthYear) {
        this.birthYear = birthYear;
        return this;
    }
    public ContactRequiredData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactRequiredData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }
    public ContactRequiredData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public ContactRequiredData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    public ContactRequiredData withGroup(String group) {
        this.group = group;
        return this;
    }

    public int getId() {
        return id;
    }

    public ContactRequiredData withId(int id) {

        this.id = id;
        return this;
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

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
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

    public ContactRequiredData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }
}
