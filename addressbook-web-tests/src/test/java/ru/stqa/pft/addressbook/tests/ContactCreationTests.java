package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.ContactRequiredData;

public class ContactCreationTests extends TestBase{


    @Test
    public void testContactCreation() {
        app.initNewContact(By.linkText("add new"));
        app.fillContactForm(new ContactRequiredData("Anna", "Vasileva", "a.vasileva@gmail.com", "1995", "+79992130923"));
        app.submitContactCreation("//div[@id='content']/form/input[21]");
        //через 10-15 секунд сервер переведет на форму просмотра контактов
    }


}
