package mainTests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageProvider;

import java.time.Duration;

public class loginTest extends BaseTest {

    @Test
    public void validLogin() {

        pageProvider.loginPage().openLoginPage();
        pageProvider.loginPage().clickOnButtonSingIn();

    }

}
