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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;
import static projekat4.LoginNeuspesan.driver;
import static projekat4.LoginUspesan.baseUrl;
import static projekat4.LoginUspesan.driver;

/**
 *
 * @author korisnik
 */
public class IzmeniAnketuUbaciPitanjeUspesno {
    
    public static String baseUrl = "http://localhost/projekat4/ankete2/login.php";
    public static WebDriver driver;
    
    public IzmeniAnketuUbaciPitanjeUspesno() {
    }
    
    @Parameters({"a", "p"})
    @Test
    public void IzmeniAnketuUbaciPitanjeUspesnoChrome(@Optional("Matematika") String a,@Optional("Sta je celija") String p){
         
        try{
            
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\korisnik\\Desktop\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();
            
            // Uloguj se
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/ul/li[1]/a")).click();

             driver.findElement(By.name("username1")).sendKeys("bojan7777");
             driver.findElement(By.name("password1")).sendKeys("Sifra1234$");
             driver.findElement(By.name("logindugme")).click();
            
            driver.findElement(By.xpath("/html/body/div/div[1]/nav/ul/li[4]/a")).click();
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/a[3]")).click();
            Select ankete = new Select(driver.findElement(By.id("ankselect")));
            ankete.selectByVisibleText(a);

            Select pitanja = new Select(driver.findElement(By.id("pitselect")));
            pitanja.selectByVisibleText(p);

            driver.findElement(By.xpath("/html/body/div/div[2]/button")).click();

            String message = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
         

            Assert.assertTrue(message.contains("Uspesno ubaceno pitanje"));
            
        }catch(Throwable e){
            System.out.println("ADD QUESTION ERROR " + e);
        }
        
                 
        if(driver!=null) 
            driver.quit();
         
     }
    
    @Parameters({"a", "p"})
    @Test
    public void IzmeniAnketuUbaciPitanjeUspesnoFirefox(@Optional("Matematika") String a,@Optional("Sta je celija") String p){
         
        try{
            
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\korisnik\\Desktop\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();
            
            // Uloguj se
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/ul/li[1]/a")).click();

             driver.findElement(By.name("username1")).sendKeys("bojan7777");
             driver.findElement(By.name("password1")).sendKeys("Sifra1234$");
             driver.findElement(By.name("logindugme")).click();
            
            driver.findElement(By.xpath("/html/body/div/div[1]/nav/ul/li[4]/a")).click();
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/a[3]")).click();
            Select ankete = new Select(driver.findElement(By.id("ankselect")));
            ankete.selectByVisibleText(a);

            Select pitanja = new Select(driver.findElement(By.id("pitselect")));
            pitanja.selectByVisibleText(p);

            driver.findElement(By.xpath("/html/body/div/div[2]/button")).click();

            String message = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
         

            Assert.assertTrue(message.contains("Uspesno ubaceno pitanje"));
            
        }catch(Throwable e){
            System.out.println("ADD QUESTION ERROR " + e);
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
