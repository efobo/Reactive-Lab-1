package statistics;

import entities.Manufacturer;
import entities.Product;
import entities.Review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Сalculation {

    // Итерация через цикл
    public double calculateAverageRatingWithLoop(List<Product> products) {
        int totalReviews = 0;
        int totalRating = 0;
        for (Product product : products) {
            for (Review review : product.getReviews()) {
                totalReviews++;
                totalRating += review.getRating();
            }
        }
        return totalReviews > 0 ? (double) totalRating / totalReviews : 0;
    }

    public Map<Manufacturer, Double> calculateAverageRatingWithLoop
            (List<Product> products, List<Manufacturer> manufacturers) {
        Map<Manufacturer, Double> averageRatings = new HashMap<>();

        for (Manufacturer manufacturer : manufacturers) {
            int totalReviews = 0;
            int totalRating = 0;

            for (Product product : products) {
                if (product.getManufacturer().equals(manufacturer)) {
                    for (Review review : product.getReviews()) {
                        totalRating += review.getRating();
                        totalReviews++;
                    }
                }
            }

            // Вычисляем средний рейтинг, если есть отзывы
            double averageRating = totalReviews > 0 ? (double) totalRating / totalReviews : 0.0;
            averageRatings.put(manufacturer, averageRating);
        }
        return averageRatings;
    }


    // Использование Stream API
    public double calculateAverageRatingWithStream(List<Product> products) {
        return products.stream()
                .flatMap(product -> product.getReviews().stream())
                .mapToInt(Review::getRating)
                .average()
                .orElse(0);
    }

    public Map<Manufacturer, Double> calculateAverageRatingWithStream(List<Product> products, List<Manufacturer> manufacturers) {
        return manufacturers.stream()
                .collect(Collectors.toMap(
                        manufacturer -> manufacturer,
                        manufacturer -> {

                            List<Review> reviews = products.stream()
                                    .filter(product -> product.getManufacturer().equals(manufacturer))
                                    .flatMap(product -> product.getReviews().stream())
                                    .collect(Collectors.toList());


                            return reviews.isEmpty() ? 0.0 : reviews.stream()
                                    .mapToInt(Review::getRating)
                                    .average()
                                    .orElse(0.0);
                        }
                ));
    }

    // использование своего коллектора
    public Map<Manufacturer, Double> calculateAverageRatingWithMyCollector(List<Product> products, List<Manufacturer> manufacturers) {
        return products.stream()
                .filter(product -> manufacturers.contains(product.getManufacturer()))
                .collect(new AverageRatingCollector());
    }

}
