/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package projekat4;

import static com.mycompany.projekat4.Projekat4.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import static projekat4.LoginUspesan.baseUrl;
import static projekat4.LoginUspesan.driver;

/**
 *
 * @author korisnik
 */
public class LoginNeuspesan {
        
    public static String baseUrl = "http://localhost/projekat4/ankete2/login.php";
    public static WebDriver driver;
    
    public LoginNeuspesan() {
    }

    @Parameters({"username", "lozinka"})
    @Test
    public void LoginNeuspesanChrome(@Optional("admin") String username,@Optional("Admin123") String lozinka){
        
        try{
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\korisnik\\Desktop\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(LoginUspesan.baseUrl);
            driver.manage().window().maximize();
            
             driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/ul/li[1]/a")).click();

             driver.findElement(By.name("username1")).sendKeys(username);
             driver.findElement(By.name("password1")).sendKeys(lozinka);
             driver.findElement(By.name("logindugme")).click();

             String message = driver.switchTo().alert().getText();
             driver.switchTo().alert().accept();
             
             Assert.assertTrue(message.contains("Pogresan username ili password"));
         
        }catch(Throwable e){
            System.out.println("LOGIN ERROR" + e);
        }
         
        if(driver!=null) 
            driver.quit();
        
    }
    
    @Parameters({"username", "lozinka"})
    @Test
    public void LoginNeuspesanFirefox(@Optional("admin") String username,@Optional("Admin123") String lozinka){
        
        try{
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\korisnik\\Desktop\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(LoginUspesan.baseUrl);
            driver.manage().window().maximize();
            
             driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/ul/li[1]/a")).click();

             driver.findElement(By.name("username1")).sendKeys(username);
             driver.findElement(By.name("password1")).sendKeys(lozinka);
             driver.findElement(By.name("logindugme")).click();

             String message = driver.switchTo().alert().getText();
             driver.switchTo().alert().accept();
             
             Assert.assertTrue(message.contains("Pogresan username ili password"));
         
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
