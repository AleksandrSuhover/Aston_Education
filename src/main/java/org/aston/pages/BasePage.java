package org.aston.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class BasePage {
    protected AndroidDriver<AndroidElement> driver = DriverInstance.getDriver();
}