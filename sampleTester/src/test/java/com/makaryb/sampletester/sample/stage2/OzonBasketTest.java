package com.makaryb.sampletester.sample.stage2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.ScreenShooterExtension;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("web")
public class OzonBasketTest {

    private final String PRODUCT_NAME = "star trek";

    @RegisterExtension
    static ScreenShooterExtension screenShooterExtension =
            new ScreenShooterExtension(true);

    private final PrimitiveSearchResultsPage psrp =
            new PrimitiveSearchResultsPage();

    @BeforeEach
    public void setup() {
        closeWebDriver();
        Configuration.startMaximized = true;
    }

    @Test
    @DisplayName("Добавить товар в корзину")
    @Description("Тест добавления товара в корзину на OZON")
    public void addProductToBasket() throws IOException {
        psrp
                .open();
        psrp
                .searchProduct(PRODUCT_NAME);
        psrp.addProductToBasket();

        WebDriverRunner
                .getWebDriver()
                .navigate()
                .to("https://ozon.ru/cart");

        assertEquals("1", psrp.getInBasketItemsCount());
    }
}
