package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;
import ru.stqa.pft.addressbook.model.Contacts;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactRequiredData contact = new ContactRequiredData()
                .withFirstName("Anna").withLastName("Khvorostyanova").withEmail("a.vasileva@gmail.com").withBirthYear("1995").withMobilePhone("+79992130923").withGroup("Группа1");
        app.contact().create(contact);
        Assert.assertEquals(app.contact().count(), before.size()+1);
        Contacts after = app.contact().all();
        //ставим свежесозданный id-шник, чтобы заменить дефолтный
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withAdded(
                contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()))));
    }


}
