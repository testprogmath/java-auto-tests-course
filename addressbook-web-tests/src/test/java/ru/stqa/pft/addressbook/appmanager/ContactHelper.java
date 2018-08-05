package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

public class ContactHelper extends HelperBase {

    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void submitContactCreation(String s) {
        click(By.xpath(s));
    }

    public void fillContactForm(ContactRequiredData contactRequiredData) {
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
    }

    public void initNewContact(By add_new) {
        click(add_new);
    }

    public void returnToContactsPage() {
        click(By.linkText("home page"));
    }

    public void goToContactsPage() {
        click(By.linkText("home"));
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void selectContact(By xpath) {
        click(xpath);
    }

    public void submitContactDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }
}
