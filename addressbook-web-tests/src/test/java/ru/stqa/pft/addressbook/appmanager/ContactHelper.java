package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation(String s) {
        click(By.xpath(s));
    }

    public void fillContactForm(ContactRequiredData contactRequiredData, boolean creation) {
        type(By.name("firstname"), contactRequiredData.getFirstName());
        type(By.name("lastname"), contactRequiredData.getLastName());
        type(By.name("email"), contactRequiredData.getEmail());
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

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactRequiredData.getGroup());
        }
        else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }


    }

    public void initNewContact(By add_new) {
        click(add_new);
    }
    public void returnToContactsPage() {
        click(By.linkText("home page"));
    }


    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }


    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void submitContactDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void createAContact(ContactRequiredData contact) {
        initNewContact(By.linkText("add new"));
        fillContactForm(contact, true);
        submitContactCreation("//div[@id='content']/form/input[21]");
        returnToContactsPage();
    }

    public boolean isThereAnyContact() {
        return isElementPresent(By.name("entry"));
    }

    public List<ContactRequiredData> getContactList() {
        List<ContactRequiredData> contacts = new ArrayList<ContactRequiredData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element: elements){
            /* создаем список, элементы находятся в следующем порядке: чек-бокс(0), Фамилия(1), Имя(2), адрес(3), e-mail(4), телефон(5), прочие картинки */
            List<WebElement> td = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastName = td.get(1).getText();
            String name = td.get(2).getText();
            String address = td.get(3).getText();
            String email = td.get(4).getText();
            String phone = td.get(5).getText();
            ContactRequiredData contact = new ContactRequiredData(id, name, lastName,  email, null, phone, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
