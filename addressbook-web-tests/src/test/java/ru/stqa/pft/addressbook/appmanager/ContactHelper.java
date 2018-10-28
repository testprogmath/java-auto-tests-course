package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactRequiredData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitCreation(String s) {
        click(By.xpath(s));
    }

    public void fillContactForm(ContactRequiredData contactRequiredData, boolean creation) {
        type(By.name("firstname"), contactRequiredData.getFirstName());
        type(By.name("lastname"), contactRequiredData.getLastName());
        type(By.name("email"), contactRequiredData.getEmail());
        attach(By.name("photo"), contactRequiredData.getPhoto());
        /*
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[20]")).isSelected()) {
            //выбираем день из выпадающего списка для дня рождения
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[20]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[4]")).isSelected()) {
            //выбираем месяц из выпадающего списка для месяца рождения
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[4]")).click();
        }
        type(By.name("byear"), contactRequiredData.getBirthYear());
        */
        type(By.name("mobile"), contactRequiredData.getMobilePhone());
        type(By.name("home"), contactRequiredData.getHomePhone());
        type(By.name("work"), contactRequiredData.getWorkPhone());

        if (creation) {
            if(contactRequiredData.getGroups().size() > 0)
                Assert.assertTrue(contactRequiredData.getGroups().size() == 1);
            new Select(wd.findElement(By.name("new_group")))
                    .selectByVisibleText(contactRequiredData.getGroups().iterator().next().getName());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }


    }


    public void initNewContact(By add_new) {
        click(add_new);
    }
    public void returnToContactsPage() {
        click(By.linkText("home page"));
    }


    public void initModification(int id) {
        click(By.xpath("//tr/td[input[@value='"+id+"']]/../td[8]/a"));
    }

    public void submitModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }



    public void submitDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void create(ContactRequiredData contact) {
        initNewContact(By.linkText("add new"));
        fillContactForm(contact, true);
        submitCreation("//div[@id='content']/form/input[21]");
        contactCache = null;
        returnToContactsPage();
    }

    public Contacts all() {
        if (contactCache!=null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element: elements){
            /* создаем список, элементы находятся в следующем порядке: чек-бокс(0), Фамилия(1), Имя(2), адрес(3), e-mail(4), телефон(5), прочие картинки */
            List<WebElement> td = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastName = td.get(1).getText();
            String name = td.get(2).getText();
            String address = td.get(3).getText();
            String allEmails = td.get(4).getText();
            //String[] phones = td.get(5).getText().split("\n");
            String allPhones = td.get(5).getText();
            ContactRequiredData contact = new ContactRequiredData()
                    .withId(id).withFirstName(name).withLastName(lastName)
                    .withAddress(address).withAllEmails(allEmails).withAllPhones(allPhones);
            contactCache.add(contact);
        }
        return contactCache;
    }
    public void modify(ContactRequiredData contact) {
        //selectContactById(contact.getId());
        initModification(contact.getId());
        fillContactForm(contact, false);
        submitModification();
        contactCache = null;
        returnToContactsPage();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
    }

    public void delete(ContactRequiredData contact) {
        selectContactById(contact.getId());
        submitDeletion();
        submitDecision();
        contactCache = null;

    }
    private Contacts contactCache = null;
    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public ContactRequiredData infoFromEditForm(ContactRequiredData contact) {
        initContactModificationById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String homePhone = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhone = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactRequiredData().withId(contact.getId()).withFirstName(firstName).withLastName(lastName)
                .withAddress(address).withEmail(email).withEmail2(email2).withEmail3(email3)
                .withMobilePhone(mobilePhone).withHomePhone(homePhone).withWorkPhone(workPhone);

    }

    private void initContactModificationById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void addContactToGroup(ContactRequiredData contact, GroupData group) {
        selectContactById(contact.getId());
        addContactToGroup(group);
        clickToAddGroup();
        contactCache = null;
        returnToGroupPage(group.getId());
    }
    private void addContactToGroup(GroupData group) {
        new Select(wd.findElement(By.name("to_group")))
                .selectByVisibleText(group.getName());
    }
    private void clickToAddGroup() {
        click(By.name("add"));
    }
    private void returnToGroupPage(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='./?group=%s']", id))).click();
    }

    public void removeGroup(ContactRequiredData contact, GroupData group) {
        selectGroup(group);
        selectContactById(contact.getId());
        removeGroupFromContact();
        contactCache = null;
        returnToGroupPage(group.getId());
        returnToGroupListPage();
    }
    private void selectGroup(GroupData group) {
        new Select(wd.findElement(By.name("group")))
                .selectByVisibleText(group.getName());
    }
    private void removeGroupFromContact() {
        click(By.name("remove"));
    }
    private void returnToGroupListPage() {
        new Select(wd.findElement(By.name("group")))
                .selectByVisibleText("[all]");
    }
}
