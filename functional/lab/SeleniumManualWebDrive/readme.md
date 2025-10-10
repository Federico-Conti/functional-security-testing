### Download Selenium Library

You can download the Selenium library from the following link:

[Selenium Server Standalone 3.141.59](https://github.com/SeleniumHQ/selenium/releases/download/selenium-3.141.59/selenium-server-standalone-3.141.59.jar)

### Download Chrome Driver

To download the Chrome Driver, visit the link below:

Windows:
[Chrome Driver - Stable Version](https://googlechromelabs.github.io/chrome-for-testing/#stable)

Linux (or WSL2):
 sudo apt install -y chromium-browser chromium-chromedriver
- chromedriver --version


| Browser  | Browser Binary Path              | Executable Driver Path  | Java Property to Set        |
| -------- | -------------------------------- | ----------------------- | --------------------------- |
| Chromium | `/usr/bin/chromium-browser`      | `/usr/bin/chromedriver` | `webdriver.chrome.driver`   |
| Firefox  | `/usr/bin/firefox`               | `/usr/bin/geckodriver`  | `webdriver.gecko.driver`    |
| Edge     | `/usr/bin/microsoft-edge-stable` | `/usr/bin/msedgedriver` | `webdriver.edge.driver`     |