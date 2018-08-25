package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

import java.util.Set;

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

        Set<ContactRequiredData> before = app.contact().all();
        ContactRequiredData deletedContact = before.iterator().next();
        app.contact().submitDeletion();
        app.contact().submitDecision();
        app.goTo().homePage();
        Set<ContactRequiredData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(deletedContact);
        Assert.assertEquals(before, after);
    }
}
