package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.goTo().homePage();
        if (app.contact().list().size()==0) {
            ContactRequiredData contact = new ContactRequiredData()
                    .withFirstName("Anna").withLastName("Khvorostyanova").withEmail("a.vasileva@gmail.com").withBirthYear("1995").withMobilePhone("+79992130923").withGroup("Группа1");
        }
        List<ContactRequiredData> before = app.contact().list();
        app.contact().select(before.size() - 1);
        app.contact().submitDeletion();
        app.contact().submitDecision();
        app.goTo().homePage();
        List<ContactRequiredData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }
}
