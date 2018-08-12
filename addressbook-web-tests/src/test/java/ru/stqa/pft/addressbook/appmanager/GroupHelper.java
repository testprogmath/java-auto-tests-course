package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation(String submit) {
        click(By.name(submit));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation(String s) {
        click(By.name(s));
    }

    public void deleteSelectedGroups(By delete) {
        click(delete);
    }

    public void selectGroup(By xpath) {
        click(xpath);
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void createGroup(GroupData group) {
        initGroupCreation("new");
        fillGroupForm(group); //null - оставляем то значение, которое уже было введено в header и footer
        submitGroupCreation("submit");
        returnToGroupPage();
    }

    public boolean isThereAnyGroup() {
        return isElementPresent(By.name("selected[]"));
    }
}
