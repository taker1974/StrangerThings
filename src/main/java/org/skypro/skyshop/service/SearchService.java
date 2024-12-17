// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Введение в веб-программирование с Spring Boot"

package org.skypro.skyshop.service;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Сервис поиска.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
@Service
public final class SearchService {
    @NotNull
    private final StorageService storage;

    /**
     * Конструктор.
     *
     * @param storageService экземпляр StorageService
     */
    public SearchService(@NotNull StorageService storageService) {
        // почему здесь не получается использовать this?
        /*this.*/
        storage = storageService;
    }

    /**
     * Количество результатов поиска.
     */
    public static final int MAX_RESULTS = 10_000;

    @NotNull
    public Collection<SearchResult> search(@NotNull String pattern) {
        Function<Searchable, SearchResult> toResult = SearchResult::fromSearchable;

        // Была ошибка в storage.getSearchableItems: я пытался возвращать
        // TreeSet для Searchable, не озаботившись соответствующим компаратором.
        // На этом потерял много времени, пока не начал пошаговую отладку запроса поиска
        // и не увидел, что ошибка в .collect внутри storage.

        return storage.getSearchableItems().stream()
                .filter(searchable -> searchable.getSearchableTerm().contains(pattern))
                .distinct()
                .limit(MAX_RESULTS)
                .map(toResult)
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchResultComparator())));
    }

    /**
     * Компаратор
     * Статьи в результатах поиска должны выводиться, начиная от статьи с самым длинным именем и
     * заканчивая статьей с самым коротким именем.
     * Если длины имен одинаковые, то статьи должны сортироваться в натуральном порядке (для строк).
     */
    private static class SearchResultComparator implements Comparator<SearchResult> {
        @Override
        public int compare(SearchResult s1, SearchResult s2) {
            int compareLength = Integer.compare(s2.getName().length(), s1.getName().length());
            if (compareLength != 0) {
                return compareLength;
            }
            return Objects.compare(s1.getName(), s2.getName(), String::compareTo);
        }
    }
}
