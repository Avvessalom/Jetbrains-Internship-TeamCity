package com.gmail.eugene.lazurin.jetBrainsInternship

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class LoginPage(driver: WebDriver) {
    @FindBy(xpath = "//div[@ng-show='federatedFirst']//a[@data-test='login-as-guest-button']")
    lateinit var guestButton: WebElement


    @FindBy(xpath = "//div[@ng-show='federatedFirst']//a[@data-test='login-via-JetBrains Account OAuth 2.0']")
    lateinit var jbLogin: WebElement

    @FindBy(xpath = "//div[@ng-show='federatedFirst']//a[@data-test='login-via-Google']")
    lateinit var googleLogin: WebElement

    @FindBy(xpath = "//div[@ng-show='federatedFirst']//a[@data-test='login-via-GitHub']")
    lateinit var gitHubLogin: WebElement

    @FindBy(xpath = "//div[@ng-show='federatedFirst']//a[@data-test='login-via-Bitbucket Cloud']")
    lateinit var bitbucketLogin: WebElement

    init {
        PageFactory.initElements(driver, this)
    }

}