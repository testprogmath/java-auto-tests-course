package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contacts().size()==0) {
            if (app.db().groups().size() == 0) {
                app.goTo().groupPage();
                app.group().create(new GroupData().withName("name1").withHeader("header1").withFooter("footer1"));
            }
            Groups groups = app.db().groups();
            ContactRequiredData contact = new ContactRequiredData()
                    .withFirstName("Anna")
                    .withLastName("Khvorostyanova")
                    .withEmail("a.vasileva@gmail.com")
                    .withBirthYear("1995")
                    .withMobilePhone("+79992130923")
                    .inGroup(groups.iterator().next());
            app.goTo().homePage();
            app.contact().create(contact);
        }
    }

    @Test
    public void testContactDeletion() {

        Contacts before = app.db().contacts();
        ContactRequiredData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size()-1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));


    }
}
