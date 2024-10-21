package generators;

import entities.Product;
import enums.Country;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductGenerator {

    private static final Random RANDOM = new Random();

    public static List<Product> generateProducts(int count) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            products.add(new Product(
                    i + 1,
                    RANDOM.nextDouble() * 1000,
                    "Entities.Product" + (i + 1),
                    LocalDate.now().minusDays(RANDOM.nextInt(365)),
                    Country.values()[RANDOM.nextInt(Country.values().length)],
                    ManufacturerGenerator.generateManufacturer(),
                    ReviewGenerator.generateReviews(RANDOM.nextInt(10))
            ));
        }
        return products;
    }
}
