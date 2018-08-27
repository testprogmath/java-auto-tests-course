package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
@XStreamAlias("Contact")
public class ContactRequiredData {
    @XStreamOmitField
    private int id=Integer.MAX_VALUE;
    private String firstName;
    private  String lastName;
    private  String email;
    private  String birthYear;
    private  String mobilePhone;
    private String group;
    private String homePhone;
    private String workPhone;
    private String address;
    private String allEmails;
    private String allPhones;
    private String email2;
    private File photo;
    private String email3;

    public File getPhoto() {
        return photo;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }



    public String getAllPhones() {
        return allPhones;
    }

    public String getAddress() {
        return address;
    }

    public String getAllEmails() {
        return allEmails;
    }

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
    public ContactRequiredData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
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

    public ContactRequiredData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactRequiredData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }
    public ContactRequiredData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactRequiredData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }
}
