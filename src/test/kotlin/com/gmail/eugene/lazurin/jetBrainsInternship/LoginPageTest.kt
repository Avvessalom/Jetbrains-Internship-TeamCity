package com.gmail.eugene.lazurin.jetBrainsInternship

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit

class LoginPageTest {
    private lateinit var driver: WebDriver
    private lateinit var loginPage: LoginPage
    private val url = "https://teamcity.jetbrains.com/"

    @BeforeEach
    fun setUp() {
        System.setProperty(
            "webdriver.chrome.driver",
            "src/main/kotlin/com/gmail/eugene/lazurin/jetBrainsInternship/drivers/chromedriver.exe"
        )
        driver = ChromeDriver()
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.get(url)

        loginPage = LoginPage(driver)
    }

    @AfterEach
    fun tearDown() {
        driver.quit()
    }

    @Test
    fun loginPageTest() {
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("Log in to TeamCity"))
    }

    @Test
    fun loginAsGuest() {
        WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("Log in to TeamCity"))
        loginPage.guestButton.click()
        assertEquals("Projects — TeamCity", driver.title)
    }

    @Test
    fun loginAsJB() {
        loginPage.jbLogin.click()
        assertEquals("JetBrains Account", driver.title)
    }

    @Test
    fun loginAsGoogle() {
        loginPage.googleLogin.click()
        assertEquals("Вход – Google Аккаунты", driver.title)
    }

    @Test
    fun loginAsGH() {
        loginPage.gitHubLogin.click()
        assertEquals("Sign in to GitHub · GitHub", driver.title)
    }

    @Test
    fun loginAsBb() {
        loginPage.bitbucketLogin.click()
        assertEquals("Войдите, чтобы продолжить - Войти с аккаунтом Atlassian", driver.title)
    }
}
