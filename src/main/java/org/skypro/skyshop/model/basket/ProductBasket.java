// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Жизненный цикл компонентов Spring Boot приложения"

package org.skypro.skyshop.model.basket;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Корзина товаров.
 * Содержит информацию об UUID продукта о количестве каждого товара в корзине.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
@SessionScope
public final class ProductBasket {
    private final Map<UUID, Integer> basket;

    /**
     * Конструктор корзины.
     */
    public ProductBasket() {
        this.basket = new HashMap<>();
    }

    /**
     * Добавить товар в корзину.
     *
     * @param productId UUID продукта
     * @param quantity  количество добавляемых продуктов
     */
    public void addProduct(@NotNull UUID productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество добавляемых продуктов должно быть больше 0");
        }
        basket.put(productId, basket.getOrDefault(productId, 0) + quantity);
    }

    /**
     * Вернуть массив товаров в корзине.
     * @return массив товаров Map<UUID, Integer>, обёрнутый в Collections.unmodifiableMap
     */
    public Map<UUID, Integer> getProductsAll() {
        return Collections.unmodifiableMap(basket);
    }
}
