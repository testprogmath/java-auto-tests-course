package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.goToGroupPage();
        app.selectGroup(By.xpath("//div[@id='content']/form/span[1]/input"));
        app.deleteSelectedGroups(By.name("delete"));
        app.returnToGroupPage();
    }


}
