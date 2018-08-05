package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.stqa.pft.addressbook.model.ContactRequiredData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager  {
    FirefoxDriver wd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;


    public void init() {
        wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:\\Program Files\\Mozilla FirefoxESR52/firefox.exe"));
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");
        contactHelper = new ContactHelper(wd);
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }


    public void stop() {
        wd.quit();
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public GroupHelper getGroupHelper() {

        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {

        return navigationHelper;
    }
}
