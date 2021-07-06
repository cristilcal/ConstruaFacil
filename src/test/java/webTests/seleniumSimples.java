package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class seleniumSimples {

    WebDriver driver;

    @Test
    public void consultarCurso(){
        System.setProperty("webdriver.chrome.driver", "drivers/Chrome/91/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.iterasys.com.br");
        driver.findElement(By.id("searchtext")).click();
        driver.findElement(By.id("searchtext")).clear();
        driver.findElement(By.id("searchtext")).sendKeys("mantis");

        driver.findElement(By.id("btn_form_search")).click();


        assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "Cursos › \"mantis\"");

        driver.findElement(By.cssSelector("span.comprar")).click();
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(),"Mantis");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(),"R$ 49,99");

        driver.quit();


    }

}
