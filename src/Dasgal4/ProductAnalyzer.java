package Dasgal4;

import java.util.*;
import java.util.stream.Collectors;

public class ProductAnalyzer {

    public Map<String, List<Product>> analyze(List<Product> products) {
        return products.stream()
                .filter(p -> p.getPrice() > 1000)
                .sorted(Comparator.comparing(Product::getCategory)
                    .thenComparing(Product::getPrice).reversed())
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public static void main(String[] args) {
        List<Product> list = List.of(
            new Product("Гутал", "Хувцас", 1500),
            new Product("Цамц", "Хувцас", 1200),
            new Product("Гар утас", "Электрон", 999)
        );

        ProductAnalyzer analyzer = new ProductAnalyzer();
        Map<String, List<Product>> result = analyzer.analyze(list);

        result.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}

