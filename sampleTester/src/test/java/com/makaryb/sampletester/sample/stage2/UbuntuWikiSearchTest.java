package com.makaryb.sampletester.sample.stage2;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Tag("web")
public class UbuntuWikiSearchTest {

    private final static String UBUNTU_WIKI_URL = "https://wiki.ubuntu.com";

    @RegisterExtension
    static ScreenShooterExtension screenShooterExtension =
            new ScreenShooterExtension(true);

    @BeforeAll
    static void setup() {
        closeWebDriver();
        Configuration.baseUrl = UBUNTU_WIKI_URL;
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void beforeEach() {
        openMainPage();
    }

    private void openMainPage() {
        open("/");
    }

    @ParameterizedTest
    @ValueSource(strings = { "16.04", "18.04", "18.10", "20.04" })
    @DisplayName(
            "Открывается главная страница." +
            "Появятся результаты поиска по версии дистрибутива." +
            "Проверим, что первым результатом поиска всегда является ReleaseNotes")
    void checkResultsOfSearchByKey(String version) {
        searchByKey(version);

        shouldContainReleaseNotes();
    }

    private void searchByKey(final String version) {
        $(byId("searchinput"))
                .shouldBe(visible)
                .setValue(version)
                .submit();
    }

    private void shouldContainReleaseNotes() {
        $$(By.className("searchresults"))
                .first()
                .shouldHave(Condition.text("ReleaseNotes"));
    }
}
