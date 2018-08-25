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
            app.contact().create(new ContactRequiredData("Anna", "Khvorostyanova", "a.vasileva@gmail.com", "1995", "+79992130923", "Группа1"));
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
