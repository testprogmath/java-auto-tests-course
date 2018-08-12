package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToContactsPage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactRequiredData("ChangedAnna", "ChangedKhvorostyanova", "Changed_a.vasileva@gmail.com", "1995", "+79992130900", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToContactsPage();
    }
}
