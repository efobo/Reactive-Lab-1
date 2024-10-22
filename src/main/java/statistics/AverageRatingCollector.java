package statistics;

import entities.Manufacturer;
import entities.Product;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AverageRatingCollector implements Collector<Product, Map<Manufacturer, AverageRatingCollector.RatingAccumulator>, Map<Manufacturer, Double>> {

    @Override
    public Supplier<Map<Manufacturer, RatingAccumulator>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Manufacturer, RatingAccumulator>, Product> accumulator() {
        return (map, product) -> {
            Manufacturer manufacturer = product.getManufacturer();
            RatingAccumulator accumulator = map.computeIfAbsent(manufacturer, k -> new RatingAccumulator());

            product.getReviews().forEach(review -> accumulator.addRating(review.getRating()));
        };
    }

    @Override
    public BinaryOperator<Map<Manufacturer, RatingAccumulator>> combiner() {
        return (map1, map2) -> {
            map2.forEach((manufacturer, accumulator) ->
                    map1.merge(manufacturer, accumulator, RatingAccumulator::combine));
            return map1;
        };
    }

    @Override
    public Function<Map<Manufacturer, RatingAccumulator>, Map<Manufacturer, Double>> finisher() {
        return map -> map.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().getAverage()
                ));
    }


    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.UNORDERED);
    }

    // Вспомогательный класс для накопления рейтингов
    static class RatingAccumulator {
        private int totalRating = 0;
        private int reviewCount = 0;

        void addRating(int rating) {
            totalRating += rating;
            reviewCount++;
        }

        RatingAccumulator combine(RatingAccumulator other) {
            this.totalRating += other.totalRating;
            this.reviewCount += other.reviewCount;
            return this;
        }

        double getAverage() {
            return reviewCount > 0 ? (double) totalRating / reviewCount : 0.0;
        }
    }
}
