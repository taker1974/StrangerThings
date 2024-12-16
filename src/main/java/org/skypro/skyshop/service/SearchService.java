// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Введение в веб-программирование с Spring Boot"

package org.skypro.skyshop.service;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.model.search.SearchResult;
import org.springframework.stereotype.Service;

/**
 * Сервис поиска.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
@Service
public class SearchService {
    private final StorageService storageService;

    /**
     * Конструктор.
     *
     * @param storageService экземпляр StorageService
     */
    public SearchService(@NotNull StorageService storageService) {
        this.storageService = storageService;
    }
}
