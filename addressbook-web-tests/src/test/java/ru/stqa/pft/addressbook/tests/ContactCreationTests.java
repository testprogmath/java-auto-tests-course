package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

public class ContactCreationTests extends TestBase{


    @Test
    public void testContactCreation() {
        app.getContactHelper().createAContact(new ContactRequiredData("Anna", "Khvorostyanova", "a.vasileva@gmail.com", "1995", "+79992130923", "Группа1"));
    }


}
