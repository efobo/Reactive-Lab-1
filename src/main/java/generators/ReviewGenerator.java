package generators;

import entities.Review;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class ReviewGenerator extends AbstractGenerator<Review> {
    private final LocalDate releaseDate; // TODO: использовать для генерации времени написания отзыва

    @Override
    protected Review generate() {
        return new Review(
                id++,
                LocalDate.now().minusDays(faker.random().nextInt(365)),
                faker.internet().username(),
                faker.number().numberBetween(1, 6)
        );
    }
}
