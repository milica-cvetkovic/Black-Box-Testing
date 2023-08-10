/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package projekat4;

import static com.mycompany.projekat4.Projekat4.driver;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import static projekat4.IzmeniAnketuUbaciPitanjeUspesno.baseUrl;
import static projekat4.IzmeniAnketuUbaciPitanjeUspesno.driver;

/**
 *
 * @author korisnik
 */
public class AzurirajKorisnikaUspesno {
    
    public static String baseUrl = "http://localhost/projekat4/ankete2/login.php";
    public static WebDriver driver;
    
    public AzurirajKorisnikaUspesno() {
    }

    @Parameters({"username", "u", "l", "e", "t", "izaberi"})
    @Test
    public void AzurirajKorisnikaUspesnoChrome(@Optional("milica") String username,@Optional("milica1") String u,@Optional("") String l,@Optional("") String e,@Optional("") String t,@Optional("1") int izaberi){
         
         try{
             
             System.setProperty("webdriver.chrome.driver", "C:\\Users\\korisnik\\Desktop\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();
            
            // Uloguj se
            driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/ul/li[1]/a")).click();

             driver.findElement(By.name("username1")).sendKeys("admin");
             driver.findElement(By.name("password1")).sendKeys("Admin123.");
             driver.findElement(By.name("logindugme")).click();
             
             driver.findElement(By.xpath("/html/body/div/div[1]/nav/ul/li[5]/a")).click();
         
            WebElement tabela = driver.findElement(By.id("kortable"));
            List<WebElement> redovi = tabela.findElements(By.tagName("tr"));

            String user = null;
            WebElement r = null;
            
            int flag = 0;
            for(WebElement red: redovi){
                
                if(flag==0){
                    flag++;
                    continue;
                }
                
                List<WebElement> kolone = red.findElements(By.tagName("td"));
                user = kolone.get(0).getText();
                r = kolone.get(3).findElement(By.cssSelector(".ui.button"));
                if(user.equals(username)) break;

            }

            if(user == null) throw new Throwable("Greska");
            
            r.click();
            String message = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            
            if(izaberi == 1){
                driver.findElement(By.name("user")).sendKeys(u);
            }
            if(izaberi == 2){
                driver.findElement(By.name("pass")).sendKeys(l);
            }
            if(izaberi == 3){
                driver.findElement(By.name("email")).sendKeys(e);
            }
            if(izaberi == 4){
                driver.findElement(By.name("tip")).sendKeys(t);
            }
         
            driver.findElement(By.name("azurdugme")).click();

            tabela = driver.findElement(By.id("kortable"));
            redovi = tabela.findElements(By.tagName("tr"));
            
            WebElement element = driver.findElement(By.xpath("//*[@id=\"kortable\"]/thead/tr"));
            
            Assert.assertEquals(redovi.get(0), element);
           
         
         } catch(Throwable err){
             System.out.println("UPDATE FAILED " + err);
         }
         
                          
        if(driver!=null) 
            driver.quit();
         
     }
    
    @Parameters({"username", "u", "l", "e", "t", "izaberi"})
    @Test
    public void AzurirajKorisnikaUspesnoFirefox(@Optional("milica") String username,@Optional("milica1") String u,@Optional("") String l,@Optional("") String e,@Optional("") String t,@Optional("1") int izaberi){
         
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
             
             driver.findElement(By.xpath("/html/body/div/div[1]/nav/ul/li[5]/a")).click();
         
            WebElement tabela = driver.findElement(By.id("kortable"));
            List<WebElement> redovi = tabela.findElements(By.tagName("tr"));

            String user = null;
            WebElement r = null;
            
            int flag = 0;
            for(WebElement red: redovi){
                
                if(flag==0){
                    flag++;
                    continue;
                }
                
                List<WebElement> kolone = red.findElements(By.tagName("td"));
                user = kolone.get(0).getText();
                r = kolone.get(3).findElement(By.cssSelector(".ui.button"));
                if(user.equals(username)) break;

            }

            if(user == null) throw new Throwable("Greska");
            
            r.click();
            String message = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            
            if(izaberi == 1){
                driver.findElement(By.name("user")).sendKeys(u);
            }
            if(izaberi == 2){
                driver.findElement(By.name("pass")).sendKeys(l);
            }
            if(izaberi == 3){
                driver.findElement(By.name("email")).sendKeys(e);
            }
            if(izaberi == 4){
                driver.findElement(By.name("tip")).sendKeys(t);
            }
         
            driver.findElement(By.name("azurdugme")).click();

            tabela = driver.findElement(By.id("kortable"));
            redovi = tabela.findElements(By.tagName("tr"));
            
            WebElement element = driver.findElement(By.xpath("//*[@id=\"kortable\"]/thead/tr"));
            
            Assert.assertEquals(redovi.get(0), element);
           
         
         } catch(Throwable err){
             System.out.println("UPDATE FAILED " + err);
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
