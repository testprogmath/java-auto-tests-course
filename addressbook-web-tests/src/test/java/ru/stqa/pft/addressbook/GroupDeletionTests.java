package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        goToGroupPage();
        selectGroup(By.xpath("//div[@id='content']/form/span[1]/input"));
        deleteSelectedGroups(By.name("delete"));
        returnToGroupPage();
    }


}
