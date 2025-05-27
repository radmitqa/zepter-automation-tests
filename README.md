
# Zepter Automation Tests

Automated UI tests for Zepter web application using Selenium WebDriver in Java.

There is no JUnit, TestNG, Maven or any other type of framework used here because the goal is to match with direct requirements from task.

## 📁 Project Structure

- `ZepterPopupTest.java` – Verifies login popup window and UI elements.
- `ZepterNavigationTest.java` – Tests login and logout functionalities.
- `ZepterTestRunner.java` – Executes both test classes.
- `chrome-win64/` – Folder containing Chrome browser and `chromedriver.exe`.

## ✅ Prerequisites

- Java 17+ (tested on Java 24.0.1)
- [Chrome browser](https://www.google.com/chrome/) installed
- Matching version of [ChromeDriver](https://chromedriver.chromium.org/downloads)
- IntelliJ IDEA or any preferred IDE

## 🚀 How to Run

1. Clone this repository or download the source code.
2. Ensure the path to `chromedriver.exe` is correctly set in each test class:
   ```java
   System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\chromedriver.exe");

Run the ZepterTestRunner class from your IDE or terminal.

🧪 Test Coverage
ZepterPopupTest
Checks for:

Login popup display

Logo presence

Email and password fields

Required field messages

Registration and forgot password links

ZepterNavigationTest
Verifies:

Login functionality

Logout link visibility

Successful logout

⚠️ Troubleshooting
SessionNotCreatedException: Make sure chromedriver.exe is correctly linked and compatible with your Chrome version.

Driver Port Timeout: Kill any existing chromedriver processes and restart the test.

Ensure popups are allowed in your browser if testing manually beforehand.

👨‍💻 Author
Radovan Mitrovic – FatCatQA.com
