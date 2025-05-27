public class ZepterTestRunner {
    public static void main(String[] args) {
        System.out.println("🔵 Running popup verification test...");
        ZepterVerifyPopupElementsTest.main(null);  // call main() from first test

        System.out.println("🔵 Running login + logout test...");
        ZepterNavigationTest.main(null);  // call main() from second test
    }
}
