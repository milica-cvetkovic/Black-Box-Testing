/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projekat4;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 *
 * @author korisnik
 */
public class Projekat4 {
        
    public static String baseUrl = "http://localhost/projekat4/ankete2/login.php";
    public static WebDriver driver;
    
    public static void main(String[] args){
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\korisnik\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();

        String username = "milica";
        String lozinka = "milica";
        String potvrda = "milica";
        String ime = "Milica";
        String prezime = "Cvetkovic";
        String JMBG = "11111111";
        String datum = "11192001";
        String mesto = "Beograd";
        String kontakt = "+38160123456";
        String mejl = "milica@gmail.com";
        String tip = "Sluzbenik";
        
        RegistracijaUspesna(username, lozinka, potvrda, ime, prezime, JMBG, datum, mesto, kontakt, mejl, tip);
	//LoginUspesan("milica", "milica");	
        //PromeniLozinkuUspesno("milica", "milica", "milica", "milica");
        //PromeniLozinkuNeuspesnoPogresno("milica", "milica123", "milica", "milica");
        //LoginUspesan("admin", "Admin123.");
        //AzurirajKorisnikaUspesno("milica", "milica1", "", "", "", 1);
        //IzmeniAnketuUbaciPitanjeUspesno("Matematika","Sta je celija");
        driver.quit();
    }
    
    public static void RegistracijaUspesna(String username, String lozinka, String potvrda, String ime, String prezime, String JMBG, String datum, String mesto, String kontakt, String mejl, String tip){
        
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

        try{
            Assert.assertTrue(message.contains("Uspešno ste se registrovali!"));
            System.out.println("REGISTRATION PASSED");
        }catch(Throwable e){
            System.out.println("REGISTRATION FAILED " + e);
        }
        
    }
    
    public static void RegistracijaNeuspesnaUsername(String username, String lozinka, String potvrda, String ime, String prezime, String JMBG, String datum, String mesto, String kontakt, String mejl, String tip){
        
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

        try{
            Assert.assertTrue(message.contains("Korisničko ime nije ispravno uneto!"));
            System.out.println("REGISTRATION FAILED - USERNAME");
        }catch(Throwable e){
            System.out.println("REGISTRATION ERROR" + e);
        }
        
    }
    
     public static void RegistracijaNeuspesnaIme(String username, String lozinka, String potvrda, String ime, String prezime, String JMBG, String datum, String mesto, String kontakt, String mejl, String tip){
        
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
        driver.switchTo().alert().accept();
        String message = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        try{
            Assert.assertTrue(message.contains("Ime nije ispravno uneto!"));
            System.out.println("REGISTRATION FAILED - IME");
        }catch(Throwable e){
            System.out.println("REGISTRATION ERROR" + e);
        }
        
    }

     public static void RegistracijaNeuspesnaPrezime(String username, String lozinka, String potvrda, String ime, String prezime, String JMBG, String datum, String mesto, String kontakt, String mejl, String tip){
        
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

        try{
            Assert.assertTrue(message.contains("Prezime nije ispravno uneto!"));
            System.out.println("REGISTRATION FAILED - USERNAME");
        }catch(Throwable e){
            System.out.println("REGISTRATION ERROR" + e);
        }
        
    }
     
     public static void RegistracijaNeuspesnaJMBG(String username, String lozinka, String potvrda, String ime, String prezime, String JMBG, String datum, String mesto, String kontakt, String mejl, String tip){
        
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
        String messageCheck = driver.switchTo().alert().getText();
        if(messageCheck.contains("JMBG nije ispravno unet!")){
            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
        }
        else{
            driver.switchTo().alert().accept();
            messageCheck = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
            driver.switchTo().alert().accept();
        }

        try{
            Assert.assertTrue(messageCheck.contains("JMBG nije ispravno unet!"));
            System.out.println("REGISTRATION FAILED - JMBG");
        }catch(Throwable e){
            System.out.println("REGISTRATION ERROR" + e);
        }
        
    }
     
     public static void RegistracijaNeuspesnaKontakt(String username, String lozinka, String potvrda, String ime, String prezime, String JMBG, String datum, String mesto, String kontakt, String mejl, String tip){
        
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

        try{
            Assert.assertTrue(message.contains("Telefon nije ispravno unet!"));
            System.out.println("REGISTRATION FAILED - TELEFON");
        }catch(Throwable e){
            System.out.println("REGISTRATION ERROR" + e);
        }
        
    }
     
     public static void LoginUspesan(String username, String lozinka){
         
         driver.findElement(By.name("username1")).sendKeys(username);
         driver.findElement(By.name("password1")).sendKeys(lozinka);
         driver.findElement(By.name("logindugme")).click();
         
         String message = driver.findElement(By.xpath("/html/body/div/div[2]/h1")).getText();
         
         try{
            Assert.assertTrue(message.contains("Dobro došli na sajt!"));
            System.out.println("LOGIN SUCCESSFUL");
        }catch(Throwable e){
            System.out.println("LOGIN FAILED" + e);
        }
         
     }
     
     public static void LoginNeuspesan(String username, String lozinka){
         
         //Pogresan username ili password
         driver.findElement(By.name("username1")).sendKeys(username);
         driver.findElement(By.name("password1")).sendKeys(lozinka);
         driver.findElement(By.name("logindugme")).click();
         
         String message = driver.switchTo().alert().getText();
         driver.switchTo().alert().accept();
         
         try{
            Assert.assertTrue(message.contains("Pogresan username ili password"));
            System.out.println("LOGIN FAILED");
        }catch(Throwable e){
            System.out.println("LOGIN ERROR" + e);
        }
         
     }
     
     public static void PromeniLozinkuUspesno(String username, String stara, String nova, String potvrdi){
         
         driver.findElement(By.xpath("//*[@id=\"log\"]/a")).click();
         driver.findElement(By.name("username3")).sendKeys(username);
         driver.findElement(By.name("password3")).sendKeys(stara);
         driver.findElement(By.name("newpass")).sendKeys(nova);
         driver.findElement(By.name("newpass1")).sendKeys(potvrdi);
         driver.findElement(By.name("novalozdugme")).click();
         
         //Uspesno promenjena lozinka!
         String message = driver.switchTo().alert().getText();
         driver.switchTo().alert().accept();
         
         try{
            Assert.assertTrue(message.contains("Uspesno promenjena lozinka!"));
            System.out.println("CHANGE PASSWORD SUCCESSFUL");
        }catch(Throwable e){
            System.out.println("CHANGE PASSWORD FAILED" + e);
        }
         
     }
     
     
     public static void PromeniLozinkuNeuspesnoNeslaganje(String username, String stara, String nova, String potvrdi){
         
         driver.findElement(By.xpath("//*[@id=\"log\"]/a")).click();
         driver.findElement(By.name("username3")).sendKeys(username);
         driver.findElement(By.name("password3")).sendKeys(stara);
         driver.findElement(By.name("newpass")).sendKeys(nova);
         driver.findElement(By.name("newpass1")).sendKeys(potvrdi);
         driver.findElement(By.name("novalozdugme")).click();
         
         //Lozinke se moraju slagati!
         String message = driver.switchTo().alert().getText();
         driver.switchTo().alert().accept();
         
        try{
            Assert.assertTrue(message.contains("Lozinke se moraju slagati!"));
            System.out.println("CHANGE PASSWORD FAILED");
        }catch(Throwable e){
            System.out.println("CHANGE PASSWORD ERROR" + e);
        }
         
     }
     
     public static void PromeniLozinkuNeuspesnoPogresno(String username, String stara, String nova, String potvrdi){
         
         //Pogresan username ili lozinka!
         driver.findElement(By.xpath("//*[@id=\"log\"]/a")).click();
         driver.findElement(By.name("username3")).sendKeys(username);
         driver.findElement(By.name("password3")).sendKeys(stara);
         driver.findElement(By.name("newpass")).sendKeys(nova);
         driver.findElement(By.name("newpass1")).sendKeys(potvrdi);
         driver.findElement(By.name("novalozdugme")).click();
         
         //Lozinke se moraju slagati!
         String message = driver.switchTo().alert().getText();
         driver.switchTo().alert().accept();
         
        try{
            Assert.assertTrue(message.contains("Pogresan username ili lozinka!"));
            System.out.println("CHANGE PASSWORD FAILED");
        }catch(Throwable e){
            System.out.println("CHANGE PASSWORD ERROR" + e);
        }
         
     }
     
     public static void IzmeniAnketuUbaciPitanjeUspesno(String a, String p){
         
         driver.findElement(By.xpath("/html/body/div/div[1]/nav/ul/li[4]/a")).click();
         driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/a[3]")).click();
         Select ankete = new Select(driver.findElement(By.id("ankselect")));
         ankete.selectByVisibleText(a);
         
         Select pitanja = new Select(driver.findElement(By.id("pitselect")));
         pitanja.selectByVisibleText(p);
         
         driver.findElement(By.xpath("/html/body/div/div[2]/button")).click();
         
         String message = driver.switchTo().alert().getText();
         driver.switchTo().alert().accept();
         
         try{
            Assert.assertTrue(message.contains("Uspesno ubaceno pitanje"));
            System.out.println("ADD QUESTION SUCCESSFUL");
        }catch(Throwable e){
            System.out.println("ADD QUESTION FAILED " + e);
        }
         
     }
     
     public static void AzurirajKorisnikaUspesno(String username, String u, String l, String e, String t, int izaberi){
         
         try{
             
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
           
            System.out.println("UPDATE SUCCESSFUL");
         
         } catch(Throwable err){
             System.out.println("UPDATE FAILED " + err);
         }
         
         
         
     }
     
            
}
