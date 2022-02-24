package tests.browserstack;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

    @Test
    @Tag("browserstack")
    @DisplayName("Search Wikipedia app")
    void searchTest() {

        step("Click on the Search field", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();});

        step("Type 'Browserstack' in the Search field", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");});

        step("Verify search results are not empty", () -> {
            $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));});
    }

    @Test
    @Tag("browserstack")
    @DisplayName("Open Settings screen")
    void openSettingsTest() {

        step("Click on the menu button", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();});

        step("Click on the Settings in Dropdownlist", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click();});

        step("Verify Settings screen is opened", () -> {
            $(byClassName("android.widget.TextView")).shouldHave(text("Settings"));});
    }

}