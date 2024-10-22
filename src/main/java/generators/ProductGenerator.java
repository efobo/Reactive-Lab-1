package generators;

import entities.Manufacturer;
import entities.Product;
import enums.Country;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class ProductGenerator extends AbstractGenerator<Product> {
    private final List<Manufacturer> manufacturers;
    private final int reviewCount;

    @Override
    protected Product generate() {
        // faker.timeAndDate().past(365, TimeUnit.DAYS) TODO: использовать это или нет?
        LocalDate releaseDate = LocalDate.now().minusDays(faker.random().nextInt(365));
        ReviewGenerator reviewGenerator = new ReviewGenerator(releaseDate);

        return new Product(
                id++,
                faker.number().randomDouble(2, 1, 100000),
                faker.commerce().productName(),
                releaseDate,
                Country.values()[faker.random().nextInt(Country.values().length)],
                manufacturers.get(faker.random().nextInt(manufacturers.size())),
                reviewGenerator.generateList(reviewCount)
        );
    }
}
