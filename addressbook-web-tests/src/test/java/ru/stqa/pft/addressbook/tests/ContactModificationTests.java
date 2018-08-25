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
            ContactRequiredData contact = new ContactRequiredData()
                    .withFirstName("Anna").withLastName("Khvorostyanova").withEmail("a.vasileva@gmail.com").withBirthYear("1995").withMobilePhone("+79992130923").withGroup("Группа1");}
        List<ContactRequiredData> before = app.contact().list();
        int index = before.size()-1;
        ContactRequiredData contact = new ContactRequiredData()
                .withId(before.get(index).getId()).withFirstName("Anna_changed").withLastName("Khvorostyanova_changed").withEmail("Changed_a.vasileva@gmail.com").withBirthYear("1995").withMobilePhone("+79992130900");
        app.contact().modify(index, contact);

        List<ContactRequiredData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(contact);
        Comparator<? super ContactRequiredData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
