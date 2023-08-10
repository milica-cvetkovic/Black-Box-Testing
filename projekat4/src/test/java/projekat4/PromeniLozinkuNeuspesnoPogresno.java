/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package projekat4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static projekat4.PromeniLozinkuNeuspesnoNeslaganje.driver;
import static projekat4.PromeniLozinkuUspesno.baseUrl;
import static projekat4.PromeniLozinkuUspesno.driver;

/**
 *
 * @author korisnik
 */
public class PromeniLozinkuNeuspesnoPogresno {
    
    public static String baseUrl = "http://localhost/projekat4/ankete2/login.php";
    public static WebDriver driver;
    
    public PromeniLozinkuNeuspesnoPogresno() {
    }

    @Parameters({"username", "stara", "nova", "potvrdi"})
    @Test
    public void PromeniLozinkuNeuspesnoPogresnoChrome(@Optional("milica") String username,@Optional("milica123") String stara,@Optional("milica") String nova,@Optional("milica") String potvrdi){
        
        try{

            driver.findElement(By.xpath("//*[@id=\"log\"]/a")).click();
            driver.findElement(By.name("username3")).sendKeys(username);
            driver.findElement(By.name("password3")).sendKeys(stara);
            driver.findElement(By.name("newpass")).sendKeys(nova);
            driver.findElement(By.name("newpass1")).sendKeys(potvrdi);
            driver.findElement(By.name("novalozdugme")).click();

            //Lozinke se moraju slagati!
            String message = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            
            Assert.assertTrue(message.contains("Pogresan username ili lozinka!"));
         
        }catch(Throwable e){
            System.out.println("LOGIN ERROR" + e);
        }
         
        if(driver!=null) 
            driver.quit();
        
    }

    @Parameters({"username", "stara", "nova", "potvrdi"})
    @Test
    public void PromeniLozinkuNeuspesnoPogresnoFirefox(@Optional("milica") String username,@Optional("milica123") String stara,@Optional("milica") String nova,@Optional("milica") String potvrdi){
        
        try{
            
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\korisnik\\Desktop\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();

            driver.findElement(By.xpath("//*[@id=\"log\"]/a")).click();
            driver.findElement(By.name("username3")).sendKeys(username);
            driver.findElement(By.name("password3")).sendKeys(stara);
            driver.findElement(By.name("newpass")).sendKeys(nova);
            driver.findElement(By.name("newpass1")).sendKeys(potvrdi);
            driver.findElement(By.name("novalozdugme")).click();

            //Lozinke se moraju slagati!
            String message = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            
            Assert.assertTrue(message.contains("Pogresan username ili lozinka!"));
         
        }catch(Throwable e){
            System.out.println("LOGIN ERROR" + e);
        }
         
        if(driver!=null) 
            driver.quit();
        
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
