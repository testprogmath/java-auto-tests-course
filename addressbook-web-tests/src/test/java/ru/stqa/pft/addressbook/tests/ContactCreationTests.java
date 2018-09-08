package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactCreationTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("Group1111").withHeader("header1111").withFooter("footer11111"));
        }
    }
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/contacts.xml"))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();

            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactRequiredData.class);
            List<ContactRequiredData> contacts = (List<ContactRequiredData>) xstream.fromXML(xml);
            return contacts.stream().map(g -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test (dataProvider = "validContacts")
    public void testContactCreation(ContactRequiredData contact) {
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/pict.png");
        Contacts before = app.db().contacts();
        ContactRequiredData newContact = contact.withPhoto(photo).inGroup(groups.iterator().next());
        app.goTo().homePage();
        app.contact().create(newContact);
        Assert.assertEquals(app.contact().count(), before.size()+1);
        Contacts after = app.db().contacts();
        //ставим свежесозданный id-шник, чтобы заменить дефолтный
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withAdded(
                contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()))));
    }


}
