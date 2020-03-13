package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class teste1 {

    @Test
    public void desafio1(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\alexv\\Downloads\\chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--start-maximized");
        WebDriver navigator = new ChromeDriver(co);
        navigator.get("https://www.grocerycrud.com/demo/bootstrap_theme");
        navigator.findElement(By.id("switch-version-select")).sendKeys(Keys.DOWN);
        navigator.findElement(By.linkText("Add Customer")).click();

        navigator.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
        navigator.findElement(By.id("field-contactLastName")).sendKeys("Teste");
        navigator.findElement(By.id("field-contactFirstName")).sendKeys("seu nome");
        navigator.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
        navigator.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
        navigator.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
        navigator.findElement(By.id("field-city")).sendKeys("Porto Alegre");
        navigator.findElement(By.id("field-state")).sendKeys("RS");
        navigator.findElement(By.id("field-postalCode")).sendKeys("91000-000");
        navigator.findElement(By.id("field-country")).sendKeys("Brasil");
        navigator.findElement(By.linkText("Select from Employeer")).click();
        navigator.findElement(By.tagName("input")).sendKeys("Fixter");
        navigator.findElement(By.id("field-creditLimit")).sendKeys("200");
        navigator.findElement(By.id("form-button-save")).click();

        WebDriverWait wait = new WebDriverWait(navigator, 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-success")));

        WebElement msg = navigator.findElement(By.id("report-success"));
        String text = msg.getText();
        String expectedText = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
        Assert.assertEquals(text, expectedText);
        navigator.close();
    }

    @Test
    public void desafio2(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\alexv\\Downloads\\chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--start-maximized");
        WebDriver navigator = new ChromeDriver(co);
        navigator.get("https://www.grocerycrud.com/demo/bootstrap_theme");

        navigator.findElement(By.id("switch-version-select")).sendKeys(Keys.DOWN);
        navigator.findElement(By.linkText("Add Customer")).click();

        navigator.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
        navigator.findElement(By.id("field-contactLastName")).sendKeys("Teste");
        navigator.findElement(By.id("field-contactFirstName")).sendKeys("seu nome");
        navigator.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
        navigator.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
        navigator.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
        navigator.findElement(By.id("field-city")).sendKeys("Porto Alegre");
        navigator.findElement(By.id("field-state")).sendKeys("RS");
        navigator.findElement(By.id("field-postalCode")).sendKeys("91000-000");
        navigator.findElement(By.id("field-country")).sendKeys("Brasil");
        navigator.findElement(By.linkText("Select from Employeer")).click();
        navigator.findElement(By.tagName("input")).sendKeys("Fixter");
        navigator.findElement(By.id("field-creditLimit")).sendKeys("200");
        navigator.findElement(By.id("form-button-save")).click();

        WebDriverWait wait = new WebDriverWait(navigator, 1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-success")));

        WebElement msg = navigator.findElement(By.id("report-success"));
        String text = msg.getText();
        String expectedText = "Your data has been successfully stored into the database. Edit Customer or Go back to list";
        Assert.assertEquals(text, expectedText);

        navigator.findElement(By.id("save-and-go-back-button")).click();
        navigator.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        navigator.findElement(By.xpath("//div[1]/div[2]/a[3]")).click();

        navigator.findElement(By.name("search")).sendKeys("Teste Sicredi", Keys.ENTER);
        navigator.findElement(By.xpath("//div[2]/table/thead/tr[2]/td[1]/div/input")).click();
        navigator.findElement(By.xpath("//div[2]/table/thead/tr[2]/td[2]/div[1]/a/span")).click();
        msg = navigator.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]/p[2]"));
        text = msg.getText();
        expectedText = "Are you sure that you want to delete this 1 item?";
        Assert.assertEquals(text, expectedText);

        navigator.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")).click();

        msg = navigator.findElement(By.xpath("//div/span[3]/p"));

        text = msg.getText();

        expectedText = "Your data has been successfully deleted from the database.";
        Assert.assertEquals(text, expectedText);

        navigator.close();
    }
}
