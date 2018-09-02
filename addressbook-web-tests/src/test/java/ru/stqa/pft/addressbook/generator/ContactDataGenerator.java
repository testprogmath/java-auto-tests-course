package ru.stqa.pft.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator ();
    JCommander jCommander = new JCommander(generator);
        try {
        jCommander.parse(args);
    } catch (ParameterException ex) {
        jCommander.usage();
        return;
    }
        generator.run();
}

    private void run() throws IOException {
        List<ContactRequiredData> contacts = generateContact(count);
        if (format.equals("xml")) {
            saveAsXml(contacts, new File(file));
        }
        else {
            System.out.println("Unrecognized format "+ format);
        }

    }

    private void saveAsXml(List<ContactRequiredData> contacts, File file) throws IOException {
        XStream xStream = new XStream();
        xStream.processAnnotations(ContactRequiredData.class);
        String xml = xStream.toXML(contacts);
        try(Writer writer = new FileWriter(file);) {
            writer.write(xml);
        }
    }

    private List<ContactRequiredData> generateContact(int count) {
        List<ContactRequiredData> groups = new ArrayList<ContactRequiredData>();
        for (int i=0; i<count; i++) {
            groups.add(new ContactRequiredData().withFirstName(String.format("test %s", i))
                    .withLastName(String.format("footer %s", i)).withMobilePhone(String.format("+7454334543%s", i))
            );
        }
        return groups;
    }
    }


