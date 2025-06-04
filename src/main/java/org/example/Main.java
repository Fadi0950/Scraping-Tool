package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open YouTube and search for "java tutorials"
//            https://www.youtube.com/results?search_query=java
            driver.get("https://www.youtube.com/results?search_query=java+tutorials");

            // Wait for the search results to load and first video to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            WebElement firstVideo = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//ytd-video-renderer[1]//a[@id='thumbnail']")
            ));

            // Click on the first video
            firstVideo.click();

            // Let the video play for 20 seconds
            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
