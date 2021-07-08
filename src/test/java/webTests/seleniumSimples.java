package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class seleniumSimples {

    WebDriver driver;

    @BeforeMethod
    public void iniciar() {
        System.setProperty("webdriver.chrome.driver", "drivers/Chrome/91/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
        driver.get("https://www.iterasys.com.br");
    }
    @AfterMethod
    public void finalizar() {
        driver.quit();
    }

    @Test
    public void consultarCurso(){
        driver.findElement(By.id("searchtext")).click();
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys("mantis");
        driver.findElement(By.id("btn_form_search")).click();
        assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "Cursos › \"mantis\"");
        driver.findElement(By.cssSelector("span.comprar")).click();
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(),"Mantis");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(),"R$ 49,99");
    }

    @Test
    public void consultarCursoPreparatorioCTFL(){
        driver.findElement(By.id("searchtext")).click();
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys("Preparatório CTFL");
        driver.findElement(By.id("btn_form_search")).click();
        assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "Cursos › \"Preparatório CTFL\"");
        driver.findElement(By.cssSelector("span.comprar")).click();
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(),"Preparatório CTFL");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(),"R$ 169,00");
    }

}
