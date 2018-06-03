package com.ztw.pcadvisor;

import com.ztw.pcadvisor.repository.ConfigurationRepository;
import com.ztw.pcadvisor.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type P cadvisor integration tests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PCadvisorIntegrationTests {

    /**
     * The Web driver.
     */
    WebDriver webDriver;

    /**
     * The Configuration repository.
     */
    @Autowired
    ConfigurationRepository configurationRepository;

    /**
     * The User repository.
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Set up.
     */
    @Before
    public void setUp(){
        Path path = Paths.get("src\\main\\resources\\WebDriver\\chromedriver.exe");

        String absolutePath = path.toAbsolutePath().toString();

        System.setProperty("webdriver.chrome.driver", absolutePath);
        webDriver = new ChromeDriver();

    }


    /**
     * Check administrator panel.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void checkAdministratorPanel() throws InterruptedException {
        loginIntoWebsite("kane16", "guimis1");
        webDriver.findElement(By.linkText("Strona administratora")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Wyszukaj")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        Assert.assertEquals(webDriver.findElement(By.tagName("h2")).getText(),"Witaj, kane16, id: 3");
        webDriver.quit();
    }

    /**
     * Check casual user panel.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void checkCasualUserPanel() throws InterruptedException {
        loginIntoWebsite("adam2222", "kane");
        webDriver.findElement(By.linkText("Wyszukaj")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        Assert.assertEquals(webDriver.findElement(By.tagName("h2")).getText(),"Witaj, adam2222, id: 4");
        webDriver.quit();
    }

    /**
     * Check if user can be added and log in.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void checkUserCanBeAddedAndLogIn() throws InterruptedException {
        webDriver.get("http://localhost:8080/register");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("luki");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("gumi");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("lukiluki");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Gman12332!");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"repeatPassword\"]")).sendKeys("Gman12332!");
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("//*[@id=\"login\"]")).click();
        Thread.sleep(1000);
        loginIntoWebsite("lukiluki", "Gman12332!");
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Wyszukaj")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        userRepository.delete(userRepository.findByUserName("lukiluki"));
        webDriver.quit();
    }

    /**
     * Check casual user type configuration evaluation.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void checkCasualUserTypeConfigurationEvaluation() throws InterruptedException {
        loginIntoWebsite("kane16", "guimis1");
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[1]/td[2]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[4]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[2]/td[2]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[4]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[4]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        Assert.assertEquals(9.7, Double.parseDouble(webDriver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[4]/td[4]")).getText().replace(",",".")), 0.0);
        configurationRepository.delete(configurationRepository.findByUser(userRepository.findByUserName("kane16")));
        webDriver.quit();
    }

    /**
     * Check player user type configuration evaluation.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Test
    public void checkPlayerUserTypeConfigurationEvaluation() throws InterruptedException {
        loginIntoWebsite("adam2222", "kane");
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[1]/td[2]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[4]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[2]/td[2]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[4]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[3]/td[2]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.xpath("/html/body/div[1]/div[2]/table/tbody/tr/td[4]/span/a")).click();
        Thread.sleep(1000);
        webDriver.findElement(By.linkText("Zestaw komputerowy")).click();
        Thread.sleep(1000);
        Assert.assertEquals(9.4, Double.parseDouble(webDriver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr[4]/td[4]")).getText().replace(",",".")), 0.0);
        configurationRepository.delete(configurationRepository.findByUser(userRepository.findByUserName("adam2222")));
        webDriver.quit();
    }

    private void loginIntoWebsite(String login, String password) throws InterruptedException {
        webDriver.get("http://localhost:8080/login");
        Thread.sleep(1000);
        webDriver.findElement(By.id("username")).sendKeys(login);
        Thread.sleep(1000);
        webDriver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(1000);
        webDriver.findElement(By.id("login")).click();
        Thread.sleep(1000);
    }




}
