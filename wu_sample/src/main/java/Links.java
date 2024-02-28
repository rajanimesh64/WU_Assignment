import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import java.util.stream.Collectors;
public class Links {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/animesh/Downloads/chromedriver_linux64/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");

        // For each loop
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }
        
        //stream
        List<String> links1 = driver.findElements(By.tagName("a")).stream().map(element -> element.getAttribute("href")).filter(attr -> attr != null && !attr.isEmpty()).collect(Collectors.toList());

        links1.forEach(System.out::println);
        
        // Find all links on the webpage parallel stream and lambda expression
        List<String> links2 = driver.findElements(By.tagName("a")).parallelStream().map(element -> element.getAttribute("href")).filter(attr -> attr != null && !attr.isEmpty()).collect(Collectors.toList());

        links2.forEach(System.out::println);

        driver.quit();
    }
}
