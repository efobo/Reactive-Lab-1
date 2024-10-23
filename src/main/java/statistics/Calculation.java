package statistics;

import entities.Manufacturer;
import entities.Product;
import entities.Review;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculation {

    // Итерация через цикл
    public static Map<Manufacturer, Double> averageRatingWithLoop
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

            double averageRating = totalReviews > 0 ? (double) totalRating / totalReviews : 0.0;
            averageRatings.put(manufacturer, averageRating);
        }
        return averageRatings;
    }


    // Использование Stream API
    public static Map<Manufacturer, Double> averageRatingWithStream(List<Product> products, List<Manufacturer> manufacturers) {
        return manufacturers.stream()
                .collect(Collectors.toMap(
                        manufacturer -> manufacturer,
                        manufacturer -> {

                            List<Review> reviews = products.stream()
                                    .filter(product -> product.getManufacturer().equals(manufacturer))
                                    .flatMap(product -> product.getReviews().stream())
                                    .toList();


                            return reviews.isEmpty() ? 0.0 : reviews.stream()
                                    .mapToInt(Review::getRating)
                                    .average()
                                    .orElse(0.0);
                        }
                ));
    }

    // использование своего коллектора
//    public static Map<Manufacturer, Double> averageRatingWithMyCollector(List<Product> products, List<Manufacturer> manufacturers) {
//        return products.stream()
//                .filter(product -> manufacturers.contains(product.getManufacturer()))
//                .collect(new AverageRatingCollector());
//    }

    public static Map<Manufacturer, Double> averageRatingWithMyCollector(List<Product> products, List<Manufacturer> manufacturers) {
        return products.stream()
                .collect(new AverageRatingCollector(manufacturers));
    }


    public static void printCalculationResult (Map<Manufacturer, Double> averageRatings) {
        for (Manufacturer manufacturer : averageRatings.keySet()) {
            System.out.println("For manufacture \"" + manufacturer.getName() + "\" average Product Raiting is " + averageRatings.get(manufacturer));
        }
    }

}
