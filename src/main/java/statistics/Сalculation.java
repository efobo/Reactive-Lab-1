package statistics;

import entities.Product;
import entities.Review;

import java.util.List;

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

    // Использование Stream API
    public double calculateAverageRatingWithStream(List<Product> products) {
        return products.stream()
                .flatMap(product -> product.getReviews().stream())
                .mapToInt(Review::getRating)
                .average()
                .orElse(0);
    }


}
