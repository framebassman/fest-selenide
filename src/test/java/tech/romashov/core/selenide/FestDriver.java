package tech.romashov.core.selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.Logs;

import java.util.List;
import java.util.Set;

public class FestDriver implements WebDriver {
    private Options options;

    public FestDriver() {
        options = new Options() {
            @Override
            public void addCookie(Cookie cookie) {

            }

            @Override
            public void deleteCookieNamed(String name) {

            }

            @Override
            public void deleteCookie(Cookie cookie) {

            }

            @Override
            public void deleteAllCookies() {

            }

            @Override
            public Set<Cookie> getCookies() {
                return null;
            }

            @Override
            public Cookie getCookieNamed(String name) {
                return null;
            }

            @Override
            public Timeouts timeouts() {
                return null;
            }

            @Override
            public ImeHandler ime() {
                return null;
            }

            @Override
            public Window window() {
                return null;
            }

            @Override
            public Logs logs() {
                return null;
            }
        };
    }

    @Override
    public void get(String url) {

    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return options;
    }
}
