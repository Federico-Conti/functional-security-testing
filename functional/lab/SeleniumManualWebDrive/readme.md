## Why Manual WebDriver?

Sometimes, you may want to use a specific version of a browser driver or have more control over the driver configuration. In such cases, you can manually download the browser driver and set it up in your Selenium project.
e.g.

```java
System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
```

After version 4.6 of Selenium WebDriver, it is no longer necessary to set the path of the driver manually if the driver is in your system PATH.

### Download Selenium Library (Mandatory)

You can download the Selenium library from the following link:

[Selenium Server Standalone 3.141.59](https://github.com/SeleniumHQ/selenium/releases/download/selenium-3.141.59/selenium-server-standalone-3.141.59.jar)

### Download Drivers (Optional)

> Note **(if Selenium lib (Selenium WebDriver) < 4.6 is used, it is not necessary to download the driver manually)**

To download the Chrome Driver, visit the link below:

For Windows:
[Chrome Driver - Stable Version](https://googlechromelabs.github.io/chrome-for-testing/#stable)

For Linux (or WSL2):
 sudo apt install -y chromium-browser chromium-chromedriver

- chromedriver --version

Other drivers can be installed as follows:

| Browser  | Browser Binary Path              | Executable Driver Path  | Java Property to Set        |
| -------- | -------------------------------- | ----------------------- | --------------------------- |
| Chromium | `/usr/bin/chromium-browser`      | `/usr/bin/chromedriver` | `webdriver.chrome.driver`   |
| Firefox  | `/usr/bin/firefox`               | `/usr/bin/geckodriver`  | `webdriver.gecko.driver`    |
| Edge     | `/usr/bin/microsoft-edge-stable` | `/usr/bin/msedgedriver` | `webdriver.edge.driver`     |