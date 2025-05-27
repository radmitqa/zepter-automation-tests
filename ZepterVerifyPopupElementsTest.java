import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ZepterVerifyPopupElementsTest {
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
            System.out.println("✅ Login popup window is displayed.");
        } else {
            System.out.println("❌ Login popup window is NOT displayed.");
        }

        // Set focus to popup (optional, for visual UI tests)
        loginPopup.click(); // sets focus

        // 1. Verify Logo  is visible
        WebElement logo_icon = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-modal > div > div > div.modal-header.gold-color > img"))
        );
        if (logo_icon.isDisplayed()) {
            System.out.println("✅ Logo on popup modal is displayed.");
        } else {
            System.out.println("❌ Logo on popup modal is NOT displayed.");
        }

        // 2. Verify Uloguj se text is visible
        WebElement ulogujse_txt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-modal > div > div > div.modal-header.gold-color > p"))
        );
        if (ulogujse_txt.isDisplayed()) {
            System.out.println("✅ Uloguj se popup text is displayed.");
        } else {
            System.out.println("❌ Uloguj se popup text is NOT displayed.");
        }

        // 3. Verify Email ili broj telefona text on email control
        WebElement email_or_phone_txt = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpopup-loginform > div.my-3 > div:nth-child(1) > label"))
        );
        if (email_or_phone_txt.isDisplayed()) {
            System.out.println("✅ Email ili br. telefona text is displayed.");
        } else {
            System.out.println("❌ Email ili br. telefona text is NOT displayed.");
        }

        // 4. Verify Email ili broj telefona control on email control
        WebElement email_or_phone_ctrl = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpopup-loginform > div.my-3 > div:nth-child(1) > label"))
        );
        if (email_or_phone_ctrl.isDisplayed()) {
            System.out.println("✅ Email ili br. telefona control is displayed.");
        } else {
            System.out.println("❌ Email ili br. telefona control is NOT displayed.");
        }

        // 5. Lozinka text on pass control
        WebElement text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpopup-loginform > div.my-3 > div:nth-child(1) > label"))
        );
        if (text.isDisplayed()) {
            System.out.println("✅ Lozinka text is displayed.");
        } else {
            System.out.println("❌ Lozinka text is NOT displayed.");
        }

        // 6. Lozinka ctrl on pass control
        WebElement lozinka_ctrl = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpopup-loginform > div.my-3 > div:nth-child(1) > label"))
        );
        if (lozinka_ctrl.isDisplayed()) {
            System.out.println("✅ Lozinka control is displayed.");
        } else {
            System.out.println("❌ Lozinka control is NOT displayed.");
        }

        // 7. Obavezna polja verification
        WebElement mandatory_text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpopup-loginform > div.my-3 > p > span"))
        );
        if (mandatory_text.isDisplayed()) {
            System.out.println("✅ Obavezna polja text is displayed.");
        } else {
            System.out.println("❌ Obavezna polja text control is NOT displayed.");
        }

        // 8. Uloguj se button verification
        WebElement login_button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpopup-loginform > div.d-flex.justify-content-between.align-items-center.flex-wrap.gap-2.mt-3 > button"))
        );
        if (login_button.isDisplayed()) {
            System.out.println("✅ Login button is displayed.");
        } else {
            System.out.println("❌ Login button control is NOT displayed.");
        };

        // 9. Forgot pass verification
        WebElement forgot_pass_link = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginpopup-loginform > div.d-flex.justify-content-between.align-items-center.flex-wrap.gap-2.mt-3 > a"))
        );
        if (forgot_pass_link.isDisplayed()) {
            System.out.println("✅ Zaboravljena lozinka link is displayed.");
        } else {
            System.out.println("❌ Zaboravljena lozinka link is NOT displayed.");
        }

        // 10. Nemas nalog text
        WebElement nemasnalog_text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-modal > div > div > div.modal-body > p:nth-child(3)"))
        );
        if (nemasnalog_text.isDisplayed()) {
            System.out.println("✅ Nemas nalog text is displayed.");
        } else {
            System.out.println("❌ Nemas nalog text is NOT displayed.");
        }

        //11. Registruj se text verification
        WebElement registrujse_text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-modal > div > div > div.modal-body > p.gold-color"))
        );
        if (registrujse_text.isDisplayed()) {
            System.out.println("✅ Registruj se text is displayed.");
        } else {
            System.out.println("❌ Registruj se text is NOT displayed.");
        }

        //12. Registruj se text 1 verification
        WebElement registrujse_text1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-modal > div > div > div.modal-body > div:nth-child(5) > div"))
        );
        if (registrujse_text1.isDisplayed()) {
            System.out.println("✅ Registruj se text 1 is displayed.");
        } else {
            System.out.println("❌ Registruj se text 1 is NOT displayed.");
        }

        //13. Registruj se text 2 verification
        WebElement registrujse_text2 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-modal > div > div > div.modal-body > div:nth-child(6) > div"))
        );
        if (registrujse_text2.isDisplayed()) {
            System.out.println("✅ Registruj se text 2 is displayed.");
        } else {
            System.out.println("❌ Registruj se text 2 is NOT displayed.");
        }

        //14. Registruj se text 3 verification
        WebElement registrujse_text3 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-modal > div > div > div.modal-body > div:nth-child(6) > div"))
        );
        if (registrujse_text3.isDisplayed()) {
            System.out.println("✅ Registruj se text 3 is displayed.");
        } else {
            System.out.println("❌ Registruj se text 3 is NOT displayed.");
        }

        //15. Become partner verification
        WebElement become_partner = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login-modal > div > div > div.modal-body > div:nth-child(6) > div"))
        );
        if (become_partner.isDisplayed()) {
            System.out.println("✅ Postani partner text is displayed.");
        } else {
            System.out.println("❌ Postani partner text is NOT displayed.");
        }

        //Close  popup modal
        WebElement close_popup_button = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("#login-modal > div > div > div.modal-header.gold-color > button > img"))
        );
        close_popup_button.click();
        System.out.println("Popup window closed.");


        driver.quit();
        System.out.println("Browser closed.");
    }
}


