package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        if (!app.getGroupHelper().isThereAnyGroup()) {
            app.getGroupHelper().createGroup(new GroupData("Группа1", null, "Тест3"));
        }
        app.getGroupHelper().selectGroup(By.xpath("//div[@id='content']/form/span[1]/input"));
        app.getGroupHelper().deleteSelectedGroups(By.name("delete"));
        app.getGroupHelper().returnToGroupPage();
    }


}
