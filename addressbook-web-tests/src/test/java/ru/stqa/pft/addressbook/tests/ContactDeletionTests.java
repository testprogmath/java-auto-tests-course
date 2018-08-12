package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAnyContact()) {
            app.getContactHelper().createAContact(new ContactRequiredData("Anna", "Khvorostyanova", "a.vasileva@gmail.com", "1995", "+79992130923", "Группа1"));
        }
        app.getContactHelper().selectContact(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().submitDecision();
        app.getNavigationHelper().goToHomePage();

    }
}
