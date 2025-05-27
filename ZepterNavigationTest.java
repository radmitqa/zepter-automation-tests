import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class ZepterNavigationTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        // Set path to ChromeDriver - edit to match your local PC
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\radmi\\IdeaProjects\\Z1\\chrome-win64\\chromedriver.exe");

        // Navigate to Google
        driver.get("https://www.zepter.rs");
        driver.manage().window().maximize();

        try {
            // Wait up to 10 seconds for the accept cookies button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));

            // Click the button
            acceptCookiesButton.click();

            System.out.println("Cookies accepted!");

        } catch (Exception e) {
            System.out.println("Cookie banner not found or already accepted.");
        }

        // Wait a bit then close
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Click "Uloguj se"
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"V2_TopNavigation_Wrapper\"]/div[2]/div/div[2]/button[2]/img"))
            );
            loginButton.click();
            System.out.println("✅ 'Uloguj se' clicked.");
        } catch (Exception e) {
            System.out.println("❌ Login button not found.");
        }

        // Wait to observe
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wait for popup and verify it's displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginPopup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login-modal']/div"))
        );

        if (loginPopup.isDisplayed()) {
            System.out.println("✅ Login popup is displayed.");
        } else {
            System.out.println("❌ Login popup is NOT displayed.");
        }

        // Set focus to popup (optional, for visual UI tests)
        loginPopup.click(); // sets focus

        // 1. Wait until element is visible
        WebElement emailInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginmode-identificator']"))
        );

        // Wait until it is enabled (clickable)
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));

        // Enter the email
        emailInput.sendKeys("radovanmitrovic.qa@gmail.com");

        WebElement passInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginmode-password"))
        );

        passInput.sendKeys("Akademija1234$");

        // Click Uloguj se button

        WebElement ulogujse_popup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpopup-loginform > div.d-flex.justify-content-between.align-items-center.flex-wrap.gap-2.mt-3 > button")));

        ulogujse_popup.click();

        // Wait to observe
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Wait until the logout button is visible
        WebElement logoutButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("#V2_TopNavigation_Wrapper > div.header-row2 > div > div.extra-menu > form > button > img")
                )
        );

        // Optional: check if it is displayed
        if (logoutButton.isDisplayed()) {
            System.out.println("Logout button is displayed. Login successful.");
        } else {
            System.out.println("Logout button is not visible. Login may have failed.");
        }


        // Close browser
        driver.quit();
}
}
