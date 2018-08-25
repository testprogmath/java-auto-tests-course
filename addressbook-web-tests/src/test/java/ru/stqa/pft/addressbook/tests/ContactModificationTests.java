package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.goTo().homePage();
        if (app.contact().list().size()==0) {
            app.contact().create(new ContactRequiredData("Anna", "Khvorostyanova", "a.vasileva@gmail.com", "1995", "+79992130923", "Группа1"));
        }
        List<ContactRequiredData> before = app.contact().list();
        app.contact().select(before.size()-1);
        app.contact().initModification();
        ContactRequiredData contact = new ContactRequiredData(before.get(before.size()-1).getId(),"Anna_changed", "Khvorostyanova_changed", "Changed_a.vasileva@gmail.com", "1995", "+79992130900", null);
        app.contact().fillContactForm(contact, false);
        app.contact().submitModification();
        app.contact().returnToContactsPage();

        List<ContactRequiredData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size()-1);
        before.add(contact);
        Comparator<? super ContactRequiredData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}
