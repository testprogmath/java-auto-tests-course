package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactRequiredData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactCreationTests extends TestBase{

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
        app.goTo().homePage();
        Contacts before = app.db().contacts();
        //File photo = new File("src/test/resources/pict.png");
        app.contact().create(contact);
        Assert.assertEquals(app.contact().count(), before.size()+1);
        Contacts after = app.db().contacts();
        //ставим свежесозданный id-шник, чтобы заменить дефолтный
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.withAdded(
                contact.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()))));
    }


}
