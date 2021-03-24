package Rucrtweb;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class Contacts {

    @Test
    public void contacts() {

        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();  // раскрываем окно браузера на весь экран
        driver.get("https://yandex.ru/"); // переходим на один из "известных" поисковиков в браузере
        driver.findElement(By.id("text")).sendKeys("crtweb.ru");   // Вводим в поиск искомый сайт "crtweb.ru"
        driver.findElement(By.xpath("//button[text()='Найти']")).click();  // Находим в поисковике сайт crtweb.ru
        driver.findElement(By.xpath("//div[text()='Аутсорсинг веб программистов и разработки мобильных...']")).click();  //совершаем переход на crtweb.ru
        // осуществляем переход на страницу crtweb.ru/contacts (для этого закрываем первую вкладку с поисковиком, оставляем вторую вкладку (уже единственную) и переходим в контакты
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
        driver.close();
        driver.switchTo().window(tabs2.get(1));
        driver.navigate().to("https://crtweb.ru/contacts");
        // проверяем на странице присутствие и отображение следующих данных:
        List<WebElement> txt = driver.findElements(By.xpath("//*[@class='tn-atom']"));
        driver.getPageSource().contains("Головной офис" + "Москва, Пресненская набережная, 12" + "Офис разработки" + "Тюмень, ул. Малыгина 84 к1, 7 этаж" + "+7 (499) 113-68-89" + "mail@crtweb.ru");
    }
}
