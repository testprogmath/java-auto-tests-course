package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup(By.xpath("//div[@id='content']/form/span[1]/input"));
        app.getGroupHelper().deleteSelectedGroups(By.name("delete"));
        app.getGroupHelper().returnToGroupPage();
    }


}
