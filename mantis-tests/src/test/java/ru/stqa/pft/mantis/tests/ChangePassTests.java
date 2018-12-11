package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.DbHelper;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import javax.xml.rpc.ServiceException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class ChangePassTests extends TestBase {
    @Test
    public void changePassword() throws IOException, MessagingException, ClassNotFoundException, ServiceException {
        skipIfNotFixed (0000001);
        List<UserData> users = new DbHelper().users();
        int index = 0;
        do{
            index = (int) new Random().nextInt(users.size());
        } while (users.get(index).getUser().equals("administrator"));
        String email = users.get(index).getEmail();
        String username = users.get(index).getUser();
        String password = "password";
        List<MailMessage> mailMessagesBefore = app.james().waitForMail(username,password,60000);

        app.changePass().start("administrator","root");
        app.changePass().clickUsersManage();
        app.changePass().clickUser(username);
        app.changePass().resetPassword();
        List<MailMessage> mailMessagesAfter;
        do {
            mailMessagesAfter = app.james().waitForMail(username, password, 60000);
        } while (mailMessagesBefore.size()==mailMessagesAfter.size());
        String passwordChangeLink = app.changePass().findChangePasswordLink(mailMessagesAfter, email);
        String newPassword = "password1";
        app.changePass().finish(passwordChangeLink, newPassword);

        HttpSession session = app.newSession();

        assertTrue(session.login(username, newPassword));
        assertTrue(session.isLoggedInAs(username));
    }
}
