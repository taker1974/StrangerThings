// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Жизненный цикл компонентов Spring Boot приложения"

package org.skypro.skyshop.model.basket;

import org.skypro.skyshop.model.product.Product;

/**
 * Неизменяемый класс с двумя полями - <br>
 * Product и его количество int.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public final class BasketItem {
    private final Product product;
    private final int count;

    /**
     * Конструктор.
     *
     * @param product продукт
     * @param count   количество
     */
    public BasketItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }

    /**
     * Возвращает продукт.
     *
     * @return продукт
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Возвращает количество.
     *
     * @return количество
     */
    public int getCount() {
        return count;
    }
}
