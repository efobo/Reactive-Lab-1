package generators;

import entities.Review;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReviewGenerator {

    private static final Random RANDOM = new Random();

    public static List<Review> generateReviews(int count) {
        List<Review> reviews = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            reviews.add(new Review(
                    i + 1,
                    LocalDate.now().minusDays(RANDOM.nextInt(365)),
                    "Reviewer" + (i + 1),
                    RANDOM.nextInt(5) + 1
            ));
        }
        return reviews;
    }
}
