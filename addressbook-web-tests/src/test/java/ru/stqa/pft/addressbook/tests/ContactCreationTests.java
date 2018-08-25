package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToHomePage();
        List<ContactRequiredData> before = app.getContactHelper().getContactList();
        ContactRequiredData contact = new ContactRequiredData("Anna", "Khvorostyanova", "a.vasileva@gmail.com", "1995", "+79992130923", "Группа1");
        app.getContactHelper().createAContact(contact);
        List<ContactRequiredData> after = app.getContactHelper().getContactList();
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
