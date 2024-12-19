// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Введение в веб-программирование с Spring Boot"

package org.skypro.skyshop.controller;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.service.SearchService;
import org.skypro.skyshop.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Контроллер магазина.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;

    public ShopController(StorageService storageService, SearchService searchService) {
        this.storageService = storageService;
        this.searchService = searchService;
    }

    @GetMapping("/products")
    @NotNull
    public Collection<Product> getProductsAll() {
        return storageService.getProducts().values();
    }

    @GetMapping("/articles")
    @NotNull
    public Collection<Article> getArticlesAll() {
        return storageService.getArticles().values();
    }

    @GetMapping("/search")
    @NotNull
    public Collection<SearchResult> getSearchResultsAll(String pattern) {
        return searchService.search(pattern);
    }
}
