// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Введение в веб-программирование с Spring Boot"

package org.skypro.skyshop.service;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Сервис хранения.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
@Service
public class StorageService {
    @NotNull
    private final Map<UUID, Product> products;
    @NotNull
    private final Map<UUID, Article> articles;

    /**
     * Начальная вместимость хранилища ассортимента товаров.
     */
    public final int INITIAL_CAPACITY_PRODUCTS = 100;
    /**
     * Начальная вместимость хранилища статей.
     */
    public final int INITIAL_CAPACITY_ARTICLES = 100;

    /**
     * Конструктор.
     */
    public StorageService() {
        products = new HashMap<>(INITIAL_CAPACITY_PRODUCTS);
        articles = new HashMap<>(INITIAL_CAPACITY_ARTICLES);
        InitializeWithSamples();
    }

    /**
     * @return коллекцию всего ассортимента продуктов
     */
    @NotNull
    public Map<UUID, Product> getProducts() {
        return products;
    }

    /**
     * @return коллекцию всех статей
     */
    @NotNull
    public Map<UUID, Article> getArticles() {
        return articles;
    }

    private void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    private void addArticle(Article article) {
        articles.put(article.getId(), article);
    }

    public void InitializeWithSamples() {
        Product product1 = new SimpleProduct("Молоко", 80);
        Product product2 = new FixPriceProduct("Хлеб");
        Product product3 = new FixPriceProduct("Сыр");
        Product product4 = new DiscountedProduct("Масло", 400, 20);
        Product product5 = new DiscountedProduct("Яйца", 140, 10);
        Product product6 = new SimpleProduct("Мясо", 900);
        Product product7 = new SimpleProduct("Бластер", 200);
        Product product8 = new SimpleProduct("Молоко \"Пискарёвское\" пастеризованное, 850 г", 80);
        products.clear();
        addProduct(product1);
        addProduct(product2);
        addProduct(product3);
        addProduct(product4);
        addProduct(product5);
        addProduct(product6);
        addProduct(product7);
        addProduct(product8);

        Article article1 = new Article("Хлеб и молоко - можно ли выжить?",
                "Выжить на хлебе и молоке невозможно, " +
                        "так как ни один продукт не способен дать человеку всё, " +
                        "что нужно для здорового образа жизни.");
        Article article2 = new Article("Что нужно есть время от времени",
                "При составлении рациона питания стоит учитывать " +
                        "индивидуальные особенности человека, " +
                        "в том числе биологические ритмы. " +
                        "Но мясо есть необходимо.");
        Article article3 = new Article("Lorem Ipsum,",
                "У меня когда-то давно был автомобиль Toyota Ipsum в 10-м кузове. " +
                        "Лучшая машина на планете Земля.");
        Article article4 = new Article("Lorem Ipsum про автомобиль Toyota Ipsum в 10-м кузове.",
                "У меня когда-то давно был автомобиль Toyota Ipsum в 10-м кузове. " +
                        "Лучшая машина на планете Земля - это минивэн Toyota Ipsum");
        articles.clear();
        addArticle(article1);
        addArticle(article2);
        addArticle(article3);
        addArticle(article4);
    }

    /**
     * Фабричный метод.
     *
     * @return сервис хранения.
     */
    public static StorageService CreateWithSamples() {
        var storage = new StorageService();
        storage.InitializeWithSamples();
        return storage;
    }
}
