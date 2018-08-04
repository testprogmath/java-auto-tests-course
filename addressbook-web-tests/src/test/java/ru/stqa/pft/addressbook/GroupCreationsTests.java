package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;



public class GroupCreationsTests extends TestBase{

    @Test
    public void testGroupCreations() {
        goToGroupPage("groups");
        initGroupCreation("new");
        fillGroupForm(new GroupData("Группа1", "Тест2", "Тест3"));
        submitGroupCreation("submit");
        returnToGroupPage("group page");

    }

}
