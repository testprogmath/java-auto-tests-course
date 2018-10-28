package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class AddContactToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(app.db().contacts().size() == 0) {
            if (app.db().groups().size() == 0) {
                app.goTo().groupPage();
                app.group().create(new GroupData()
                        .withName("name1")
                        .withHeader("header1")
                        .withFooter("footer1"));
            }
            File photo = new File("src/test/resources/pict.jpg");
            Groups groups = app.db().groups();
            ContactRequiredData contact = new ContactRequiredData()
                    .withFirstName("Katerina1")
                    .withLastName("Vasileva2")
                    .withAddress("address1")
                    .withEmail("email1")
                    .withEmail2("email2")
                    .withEmail3("email3")
                    .withHomePhone("876")
                    .withMobilePhone("564")
                    .withWorkPhone("345")
                    .withPhoto(photo)
                    .inGroup(groups.iterator().next());
            app.goTo().homePage();
            app.contact().create(contact);
        }
    }

    @Test
    public void testAddContactToGroup() {
        Contacts contacts = app.db().contacts();
        ContactRequiredData contact = contacts.iterator().next();
        Groups groups = app.db().groups();
        GroupData group = groups.iterator().next();
        int before = contact.getGroups().size();
        if(groups.size() == contact.getGroups().size()){
            app.contact().removeGroup(contact, group);
            app.contact().addContactToGroup(contact, group);
        } else {
        app.goTo().homePage();
            app.contact().addContactToGroup(contact, group);
       }
        int after = contact.getGroups().size();
        assertThat(after, equalTo(before));
    }
}
