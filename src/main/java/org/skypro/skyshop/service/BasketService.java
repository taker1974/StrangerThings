// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Жизненный цикл компонентов Spring Boot приложения"

package org.skypro.skyshop.service;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Сервис корзины товаров.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
@Service
public final class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    /**
     * Конструктор.
     *
     * @param storageService сервис хранения данных
     * @param productBasket  корзина товаров
     */
    public BasketService(StorageService storageService, ProductBasket productBasket) {
        this.storageService = storageService;
        this.productBasket = productBasket;
    }

    /**
     * Добавить товар в корзину.
     *
     * @param id идентификатор товара
     */
    public void addProduct(@NotNull UUID id) {
        var product = storageService.getProductById(id);
        if (product.isEmpty()) {
            throw new IllegalArgumentException("Продукт недоступен");
        }
        productBasket.addProduct(product.get().getId(), 1);
    }

    public UserBasket getUserBasket() {
        UserBasket userBasket = new UserBasket(null);
        // TODO
        return userBasket;
    }
}
