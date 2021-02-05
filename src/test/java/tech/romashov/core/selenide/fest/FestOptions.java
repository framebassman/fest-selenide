package tech.romashov.core.selenide.fest;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;

import java.util.Set;

public class FestOptions implements WebDriver.Options {
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
    public WebDriver.Timeouts timeouts() {
        return null;
    }

    @Override
    public WebDriver.ImeHandler ime() {
        return null;
    }

    @Override
    public WebDriver.Window window() {
        return new FestWindow();
    }

    @Override
    public Logs logs() {
        return null;
    }
}
