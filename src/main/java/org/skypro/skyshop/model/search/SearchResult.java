// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Введение в веб-программирование с Spring Boot"

package org.skypro.skyshop.model.search;

import org.jetbrains.annotations.NotNull;

/**
 * Результат поиска.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public final class SearchResult {

    @NotNull
    private final String name;

    /**
     * Конструктор.
     *
     * @param name        имя
     */
    public SearchResult(@NotNull String name) {
        this.name = name;
    }

    /**
     * Фабричный метод, возвращающий SearchResult из Searchable.
     *
     * @param searchable экземпляр Searchable
     * @return экземпляр SearchResult
     */
    public static SearchResult fromSearchable(@NotNull Searchable searchable) {
        return new SearchResult(searchable.getSearchableName());
    }

    /**
     * @return имя результата поиска
     */
    @NotNull
    public String getName() {
        return name;
    }
}
