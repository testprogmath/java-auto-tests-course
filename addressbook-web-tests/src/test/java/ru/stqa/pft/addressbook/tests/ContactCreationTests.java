package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

public class ContactCreationTests extends TestBase{


    @Test
    public void testContactCreation() {
        app.getContactHelper().initNewContact(By.linkText("add new"));
        app.getContactHelper().fillContactForm(new ContactRequiredData("Anna", "Khvorostyanova", "a.vasileva@gmail.com", "1995", "+79992130923"));
        app.getContactHelper().submitContactCreation("//div[@id='content']/form/input[21]");
        //через 10-15 секунд сервер переведет на форму просмотра контактов
    }


}
