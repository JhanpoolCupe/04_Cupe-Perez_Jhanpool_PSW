package Selenium.prueba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class prueba {

    private static WebDriver driver;

    public WebElement name;
    public WebElement contact;
    public WebElement ruc;
    public WebElement direction_legal;
    public WebElement cajaText;
    public WebElement Guardar;


    public static void setUpDriver(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\cupej\\Downloads\\Nueva carpeta (6)\\chromedriver-win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-minimized");
        driver = new ChromeDriver(options);
        driver.get("http://localhost:4200/entidades");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUpClass(){
        setUpDriver();
    }


    @Test()
    public void PrimerTest() throws InterruptedException{

        Guardar = driver.findElement(By.id("inicio"));
        Guardar.click();
        Thread.sleep(1000);

        name = driver.findElement(By.id("name"));
        name.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("name"));
        cajaText.click();
        cajaText.sendKeys("Policia");
        Thread.sleep(1000);

        contact = driver.findElement(By.id("contact"));
        contact.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("contact"));
        cajaText.click();
        cajaText.sendKeys("923456456");
        Thread.sleep(1000);

        ruc = driver.findElement(By.id("ruc"));
        ruc.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("ruc"));
        cajaText.click();
        cajaText.sendKeys("78435465430");
        Thread.sleep(1000);

        direction_legal = driver.findElement(By.id("direction_legal"));
        direction_legal.click();
        Thread.sleep(1000);
        cajaText = driver.findElement(By.id("direction_legal"));
        cajaText.sendKeys("San Vicente");
        Thread.sleep(1000);


        Guardar = driver.findElement(By.id("Guardar"));
        Guardar.click();
        Thread.sleep(1000);
    }
}
