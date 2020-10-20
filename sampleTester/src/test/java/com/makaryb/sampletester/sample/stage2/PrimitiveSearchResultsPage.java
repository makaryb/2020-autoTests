package com.makaryb.sampletester.sample.stage2;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PrimitiveSearchResultsPage {

    private final static String OZON_URL = "https://www.ozon.ru";

    @Step("Открыть главную страницу интернет-магазина OZON")
    public PrimitiveSearchResultsPage open() {
        Selenide.open(OZON_URL);
        return this;
    }

    @Step("Поиск товаров с ключевыми словами {0}")
    public void searchProduct(
            final String productName) {
        $(By.name("search"))
                .setValue(productName)
                .pressEnter();
    }

    @Step("Добавить первый найденный продукт в корзину")
    public void addProductToBasket() {
        $$(By.className("widget-search-result-container"))
                .first()
                .scrollTo()
                .$(withText("В корзину"))
                .click();
    }

    @Step("Проверить, что число тваров в корзине равно {1}")
    public String getInBasketItemsCount() {
        return Objects.requireNonNull(
                $(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[3]/div[4]/div[2]/div/section/div[2]/div[2]/div[1]/span/span"))
                        .getAttribute("textContent")
        ).substring(8, 9);
    }
}
