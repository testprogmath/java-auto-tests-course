package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactRequiredData> {

    private Set<ContactRequiredData> delegate;
    public Contacts() {
        this.delegate = new HashSet<ContactRequiredData>();
    }
    public Contacts(Contacts contacts) {

        this.delegate = new HashSet<ContactRequiredData>(contacts.delegate);
    }
    public Contacts(Collection<ContactRequiredData> contacts) {
        this.delegate = new HashSet<ContactRequiredData>(contacts);
    }

    @Override
    protected Set<ContactRequiredData> delegate() {

        return delegate;
    }

    public Contacts withAdded(ContactRequiredData contact){
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }
    public Contacts without(ContactRequiredData contact){
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }

}
