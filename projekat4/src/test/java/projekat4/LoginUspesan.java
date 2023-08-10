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
import org.testng.annotations.Parameters;
import org.testng.annotations.*;
import static projekat4.RegistracijaNeuspesnaIme.driver;
import static projekat4.RegistracijaUspesna.baseUrl;
import static projekat4.RegistracijaUspesna.driver;

/**
 *
 * @author korisnik
 */
public class LoginUspesan {
    
    public static String baseUrl = "http://localhost/projekat4/ankete2/login.php";
    public static WebDriver driver;
    
    public LoginUspesan() {
    }


    @Parameters({"username", "lozinka"})
    @Test
    public void LoginUspesanChrome(@Optional("admin") String username,@Optional("Admin123.") String lozinka){
        
        try{
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\korisnik\\Desktop\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();
            
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/ul/li[1]/a")).click();

             driver.findElement(By.name("username1")).sendKeys(username);
             driver.findElement(By.name("password1")).sendKeys(lozinka);
             driver.findElement(By.name("logindugme")).click();

             String message = driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText();
         
         Assert.assertTrue(message.contains("Dobro došli na sajt!"));
        }catch(Throwable e){
            System.out.println("LOGIN ERROR" + e);
        }
         
        if(driver!=null) 
            driver.quit();
        
    }
    
    @Parameters({"username", "lozinka"})
    @Test
    public void LoginUspesanFirefox(@Optional("admin") String username,@Optional("Admin123.") String lozinka){
        
        try{
            
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\korisnik\\Desktop\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();
            
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/ul/li[1]/a")).click();

             driver.findElement(By.name("username1")).sendKeys(username);
             driver.findElement(By.name("password1")).sendKeys(lozinka);
             driver.findElement(By.name("logindugme")).click();

             String message = driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText();

             Assert.assertTrue(message.contains("Dobro došli na sajt!"));
             
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
