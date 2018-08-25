package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {
/*
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        ContactRequiredData contact = new ContactRequiredData()
                .withFirstName("Anna").withLastName("Khvorostyanova")
                .withEmail("a.vasileva@gmail.com").withBirthYear("1995").withMobilePhone("+79992130923")
                .withGroup("Группа1").withWorkPhone("8945334532").withHomePhone("56434354");
        app.contact().create(contact);
        //int id = app.contact().all().stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        /*
        Contacts before = app.contact().all();
        ContactRequiredData contact = before.iterator().next(); //выбрали случайный элемент
        if (contact.getHomePhone()==null) {//если у него нет домашнего телефона
            contact = new ContactRequiredData().withId(contact.getId())
                    .withHomePhone("43545");
            app.contact().modify(contact);
        }
        if (contact.getWorkPhone()==null) {
            contact = new ContactRequiredData().withId(contact.getId())
                    .withWorkPhone("1231454");
            app.contact().modify(contact);
        }
        if (contact.getMobilePhone()==null) {
            contact = new ContactRequiredData().withId(contact.getId())
                    .withMobilePhone("+767575673453");
            app.contact().modify(contact);
        }

    }
*/
    @Test
    public void contactTestPhones() {
        app.goTo().homePage();
        ContactRequiredData contact = app.contact().all().iterator().next();
        ContactRequiredData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
        assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
        assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
    }

    public String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }
}
