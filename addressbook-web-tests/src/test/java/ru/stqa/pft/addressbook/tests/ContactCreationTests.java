package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

import java.util.Set;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Set<ContactRequiredData> before = app.contact().all();
        ContactRequiredData contact = new ContactRequiredData()
                .withFirstName("Anna").withLastName("Khvorostyanova").withEmail("a.vasileva@gmail.com").withBirthYear("1995").withMobilePhone("+79992130923").withGroup("Группа1");
        app.contact().create(contact);
        Set<ContactRequiredData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size()+1);
        //ставим свежесозданный id-шник, чтобы заменить дефолтный
        contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

        before.add(contact);
        Assert.assertEquals(before, after);
    }


}
