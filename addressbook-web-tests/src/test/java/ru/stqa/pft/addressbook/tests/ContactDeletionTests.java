package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size()==0) {
            ContactRequiredData contact = new ContactRequiredData()
                    .withFirstName("Anna").withLastName("Khvorostyanova").withEmail("a.vasileva@gmail.com").withBirthYear("1995").withMobilePhone("+79992130923").withGroup("Группа1");
        }
    }

    @Test
    public void testContactDeletion() {

        Contacts before = app.contact().all();
        ContactRequiredData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()-1));
        assertThat(after, equalTo(before.without(deletedContact)));


    }
}
