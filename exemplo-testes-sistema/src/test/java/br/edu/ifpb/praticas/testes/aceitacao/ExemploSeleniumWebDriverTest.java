package br.edu.ifpb.praticas.testes.aceitacao;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;


/**
 * Created by diogomoreira on 17/07/16.
 */
public class ExemploSeleniumWebDriverTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUpTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
    }

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/");
    }

    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }

    @Test
    public void testaTituloDaPagina(){
        assertEquals("Welcome to the Spring MVC Quickstart application! Get started quickly by signing up!", driver.getTitle());
    }

    @Test
    public void testaLogin() throws InterruptedException {
        WebElement element = driver.findElement(By.id("login"));
        element.click();

        assertEquals("http://localhost:8080/signin", driver.getCurrentUrl());

        Thread.sleep(2000L);
        element = driver.findElement(By.id("inputEmail"));
        element.sendKeys("admin");
        element = driver.findElement(By.id("inputPassword"));
        element.sendKeys("admin");
        element = driver.findElement(By.tagName("button"));
        Thread.sleep(2000L);
        element.click();
        assertEquals("http://localhost:8080/", driver.getCurrentUrl());
        element = driver.findElement(By.id("logout"));
        assertNotNull(element);
    }

}
