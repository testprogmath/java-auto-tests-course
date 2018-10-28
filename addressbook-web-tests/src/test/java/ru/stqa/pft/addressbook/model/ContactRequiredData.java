package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("Contact")
@Entity
@Table(name = "addressbook")
public class ContactRequiredData {
    @XStreamOmitField
    @Id
    private int id=Integer.MAX_VALUE;
    @Column
    @Expose
    private String firstName;
    @Column
    @Expose
    private  String lastName;
    @Column(name = "email")
    @Type(type = "text")
    private  String email;
    @Column(name = "byear")
    private  String birthYear;
    @Column(name = "mobile")
    @Type(type = "text")
    private  String mobilePhone;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "address_in_groups",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<GroupData>();
    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;
    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;
    @Transient
    private String address;
    @Transient
    private String allEmails;
    @Transient
    private String allPhones;
    @Column
    @Type(type = "text")
    private String email2;
    @Column(name = "photo")
    @Type(type = "text")
    private String photo;
    @Column
    @Type(type = "text")
    private String email3;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactRequiredData that = (ContactRequiredData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    public File getPhoto() {
        return new File(photo);
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

    public String getHomePhone() {
        return homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public Groups getGroups() {
        return new Groups(groups);
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
        this.photo = photo.getPath();
        return this;
    }

    public ContactRequiredData inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}
