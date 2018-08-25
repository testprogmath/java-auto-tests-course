package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.ContactRequiredData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        List<ContactRequiredData> before = app.contact().list();
        ContactRequiredData contact = new ContactRequiredData("Anna", "Khvorostyanova", "a.vasileva@gmail.com", "1995", "+79992130923", "Группа1");
        app.contact().create(contact);
        List<ContactRequiredData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size()+1);
        //ставим свежесозданный id-шник, чтобы заменить дефолтный
        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

        before.add(contact);
        Comparator<? super ContactRequiredData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


}
