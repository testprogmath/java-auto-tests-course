package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size()==0) {
            ContactRequiredData contact = new ContactRequiredData()
                    .withFirstName("Anna").withLastName("Khvorostyanova").withEmail("a.vasileva@gmail.com").withBirthYear("1995").withMobilePhone("+79992130923").withGroup("Группа1");
        }
    }
    @Test
    public void testContactModification() {
        Contacts before = app.contact().all();
        ContactRequiredData modifiedContact = before.iterator().next();
        ContactRequiredData contact = new ContactRequiredData()
                .withId(modifiedContact.getId()).withFirstName("Anna_changed").withLastName("Khvorostyanova_changed").withEmail("Changed_a.vasileva@gmail.com").withBirthYear("1995").withMobilePhone("+79992130900");
        app.contact().modify(contact);

        Set<ContactRequiredData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }


}
