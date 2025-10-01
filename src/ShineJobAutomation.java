import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShineJobAutomation {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunku\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();

        driver.get("https://www.shine.com/myshine/mydashboard/");
        System.out.println("🔗 Opened Shine dashboard");

        try {
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_email_login")));
            emailInput.sendKeys("sunkuyeshwanthkumar@gmail.com");

            WebElement passwordInput = driver.findElement(By.id("id_password"));
            passwordInput.sendKeys("Ts07gm@6321");

            WebElement loginBtn = driver.findElement(By.cssSelector("button.search-btn.submitred"));
            loginBtn.click();
            System.out.println("✅ Login submitted");

            Thread.sleep(5000); 

            WebElement searchInputDiv = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_searchBase_new")));
            searchInputDiv.click();
            System.out.println("🟦 Triggered search modal");

            WebElement jobTitleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_q")));
            jobTitleInput.click();
            Actions actions = new Actions(driver);
            actions.sendKeys("Software Tester").perform();
            Thread.sleep(1000);

            WebElement locationInput = driver.findElement(By.id("id_loc"));
            locationInput.clear();
            locationInput.sendKeys("Hyderabad");

            WebElement expInput = driver.findElement(By.id("searchBar_experience"));
            expInput.clear();
            expInput.sendKeys("2");

            WebElement modalSearchBtn = driver.findElement(By.id("id_new_search_submit_button"));
            modalSearchBtn.click();
            System.out.println("🔍 Submitted job search");

            Thread.sleep(5000); 

            WebElement applyBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.jobApplyBtnNova_bigCardBottomApply__z2n7R")));
            applyBtn.click();
            System.out.println("✅ Clicked Apply button on first job");

            Thread.sleep(3000);

            if (driver.getPageSource().toLowerCase().contains("applied") ||
                driver.getPageSource().toLowerCase().contains("application submitted")) {
                System.out.println("🎯 Application likely submitted successfully.");
            } else {
                System.out.println("⚠️ Could not confirm application.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            // Optional: driver.quit();
        }
    }
}

