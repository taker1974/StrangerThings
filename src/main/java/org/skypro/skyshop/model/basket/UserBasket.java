// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Жизненный цикл компонентов Spring Boot приложения"

package org.skypro.skyshop.model.basket;

import java.util.Collection;

/**
 * Класс, представляющий собой корзину для пользователя.<br>
 * Этот класс должен содержать список из BasketItem, а также<br>
 * дополнительное поле total - общую стоимость корзины.
 * Класс также должен быть неизменяемым, а его конструктор должен<br>
 * принимать в себя только список BasketItem.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public final class UserBasket {
    private final Collection<BasketItem> items;

    /**
     * Конструктор класса UserBasket.
     *
     * @param items список из BasketItem
     */
    public UserBasket(Collection<BasketItem> items) {
        this.items = items;
    }

    /**
     * Получение общей стоимости корзины.
     *
     * @return общая стоимость корзины
     */
    public int getTotalPrice() {
        // TODO реализовать подсчёт общей цены корзины
        return 123;
    }
}
