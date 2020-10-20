package com.makaryb.sampletester.sample.stage2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.RegisterExtension;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@Tag("web")
public class IMDbSearchTest {

    private final static String IMDB_URL = "https://imdb.com";
    private final static String SEARCH_KEY = "star trek";

    @RegisterExtension
    static ScreenShooterExtension screenShooterExtension =
            new ScreenShooterExtension(true);

    @BeforeAll
    static void setup() {
        closeWebDriver();
        Configuration.baseUrl = IMDB_URL;
        Configuration.startMaximized = true;
    }

    @BeforeEach
    void beforeEach() {
        openMainPage();
    }

    @Test
    @DisplayName(
            "Открывается главная страница." +
            "После того, как будут открыты результаты поиска по ключевым словам," +
            "справа появится возможность Category Search." +
            "После выбора категории появится искомый вариант заголовка.")
    void searchByKeyAndFilterByCategory() {
        searchByKey();
        filterByCategory();

        shouldHaveSearchByKeyHeader();
        shouldHaveFilterByCategoryHeader();
    }

    private void openMainPage() {
        open("/");
    }

    private void searchByKey() {
        $(byId("suggestion-search"))
                .shouldBe(visible)
                .setValue(
                        IMDbSearchTest.SEARCH_KEY)
                .submit();
    }

    private void filterByCategory() {
        $(byClassName("findFilterList"))
                .shouldBe(visible)
                .find(byLinkText(
                        SearchCategory.TV_SERIES
                                .getValue()
                        )
                )
                .click();
    }

    private void shouldHaveSearchByKeyHeader() {
        SelenideElement header = $(
                byClassName("findHeader"));

        header
                .shouldHave(
                        matchText("Displaying 149 results for")
                );
        header
                .find(
                        byClassName("findSearchTerm")
                )
                .shouldHave(
                        text(IMDbSearchTest.SEARCH_KEY)
                );
    }

    private void shouldHaveFilterByCategoryHeader() {
        $(byId("findSubHeader"))
                .shouldHave(
                        text(
                                SearchCategory.TV_SERIES
                                        .getValue()
                        )
                );
    }

    enum SearchCategory {
        TV_SERIES("TV");

        private final String value;

        SearchCategory(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
