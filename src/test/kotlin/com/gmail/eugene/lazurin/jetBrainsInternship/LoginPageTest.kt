package com.gmail.eugene.lazurin.jetBrainsInternship

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.util.concurrent.TimeUnit
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URI


class LoginPageTest {
    private lateinit var driver: RemoteWebDriver
    private lateinit var loginPage: LoginPage
    private lateinit var capabilities: DesiredCapabilities
    private val url = "https://teamcity.jetbrains.com/"

    @BeforeEach
    fun setUp() {
        capabilities = DesiredCapabilities()
        capabilities.setCapability("browserName", "chrome")
        capabilities.setCapability("browserVersion", "89.0")
        capabilities.setCapability("enableVNC", true)

        driver = RemoteWebDriver(
            URI.create("http://localhost:4444/wd/hub").toURL(),
            capabilities
        )
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
        assertTrue(driver.title.equals("Log in to continue - Log in with Atlassian account") || driver.title.equals("Войдите, чтобы продолжить - Войти с аккаунтом Atlassian"))
    }
}
