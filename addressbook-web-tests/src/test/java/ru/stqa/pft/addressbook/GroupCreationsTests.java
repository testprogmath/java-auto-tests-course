package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;

public class GroupCreationsTests extends TestBase{

    @Test
    public void testGroupCreations() {
        app.goToGroupPage();
        app.initGroupCreation("new");
        app.fillGroupForm(new GroupData("Группа1", "Тест2", "Тест3"));
        app.submitGroupCreation("submit");
        app.returnToGroupPage();

    }




}
