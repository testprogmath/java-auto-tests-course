package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationsTests extends TestBase{

    @Test
    public void testGroupCreations() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation("new");
        app.getGroupHelper().fillGroupForm(new GroupData("Группа1", "Тест2", "Тест3"));
        app.getGroupHelper().submitGroupCreation("submit");
        app.getGroupHelper().returnToGroupPage();

    }




}
