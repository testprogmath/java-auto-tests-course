package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToContactsPage();
        app.getContactHelper().selectContact(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
        app.getContactHelper().submitContactDeletion();
        app.getContactHelper().submitDecision();
        app.getNavigationHelper().returnToContactsPage();

    }
}
