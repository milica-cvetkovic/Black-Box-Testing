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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static projekat4.RegistracijaNeuspesnaUsername.driver;
import static projekat4.RegistracijaNeuspesnaUsername.baseUrl;
import static projekat4.RegistracijaUspesna.baseUrl;
import static projekat4.RegistracijaUspesna.driver;

/**
 *
 * @author korisnik
 */
public class RegistracijaNeuspesnaKontakt {
    
    public static String baseUrl = "http://localhost/projekat4/ankete2/login.php";
    public static WebDriver driver;
    
    public RegistracijaNeuspesnaKontakt() {
    }

    @Parameters({"username", "lozinka", "potvrda", "ime", "prezime", "JMBG", "datum", "mesto", "kontakt", "mejl", "tip"})
    @Test
    public void RegistracijaNeuspesnaKontaktChrome(@Optional("milica") String username,@Optional("milica") String lozinka,@Optional("milica") String potvrda,@Optional("Milica") String ime, @Optional("Cvetkovic")String prezime, @Optional("1911001727814")String JMBG,@Optional("11192001") String datum, @Optional("Cuprija")String mesto,@Optional("38160123456") String kontakt,@Optional("milica@gmail.com") String mejl, @Optional("Ispitanik") String tip){
       
        try{
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\korisnik\\Desktop\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();
            
             driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/ul/li[2]/a")).click();
            driver.findElement(By.name("username2")).sendKeys(username);
            driver.findElement(By.name("password2")).sendKeys(lozinka);
            driver.findElement(By.name("password22")).sendKeys(potvrda);
            driver.findElement(By.name("ime")).sendKeys(ime);
            driver.findElement(By.name("prezime")).sendKeys(prezime);
            driver.findElement(By.name("jmbg")).sendKeys(JMBG);
            driver.findElement(By.name("datum")).sendKeys(datum);
            driver.findElement(By.name("mesto")).sendKeys(mesto);
            driver.findElement(By.name("telefon")).sendKeys(kontakt);
            driver.findElement(By.name("mejl")).sendKeys(mejl);
            Select tipkor = new Select(driver.findElement(By.name("tipkor")));
            tipkor.selectByVisibleText(tip);
            driver.findElement(By.name("regdugme")).click();

            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
            String message = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            
            Assert.assertTrue(message.contains("Telefon nije ispravno unet!"));
            
        } catch(Throwable e){
            System.out.println("REGISTRATION ERROR" + e);
        }
        
        if(driver!=null) 
            driver.quit();
        
    }
    
    @Parameters({"username", "lozinka", "potvrda", "ime", "prezime", "JMBG", "datum", "mesto", "kontakt", "mejl", "tip"})
    @Test
    public void RegistracijaNeuspesnaKontaktFirefox(@Optional("milica") String username,@Optional("milica") String lozinka,@Optional("milica") String potvrda,@Optional("Milica") String ime, @Optional("Cvetkovic")String prezime, @Optional("1911001727814")String JMBG,@Optional("11192001") String datum, @Optional("Cuprija")String mesto,@Optional("38160123456") String kontakt,@Optional("milica@gmail.com") String mejl, @Optional("Ispitanik") String tip){
       
        try{
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\korisnik\\Desktop\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();
            
             driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/ul/li[2]/a")).click();
            driver.findElement(By.name("username2")).sendKeys(username);
            driver.findElement(By.name("password2")).sendKeys(lozinka);
            driver.findElement(By.name("password22")).sendKeys(potvrda);
            driver.findElement(By.name("ime")).sendKeys(ime);
            driver.findElement(By.name("prezime")).sendKeys(prezime);
            driver.findElement(By.name("jmbg")).sendKeys(JMBG);
            driver.findElement(By.name("datum")).sendKeys(datum);
            driver.findElement(By.name("mesto")).sendKeys(mesto);
            driver.findElement(By.name("telefon")).sendKeys(kontakt);
            driver.findElement(By.name("mejl")).sendKeys(mejl);
            Select tipkor = new Select(driver.findElement(By.name("tipkor")));
            tipkor.selectByVisibleText(tip);
            driver.findElement(By.name("regdugme")).click();

            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
            String message = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            
            Assert.assertTrue(message.contains("Telefon nije ispravno unet!"));
            
        } catch(Throwable e){
            System.out.println("REGISTRATION ERROR" + e);
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
