package generators;

import entities.Product;
import enums.ProductType;

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
                    "Entities.Product" + (i + 1),
                    RANDOM.nextDouble() * 1000,  // цена
                    LocalDate.now().minusDays(RANDOM.nextInt(365)),  // дата выпуска
                    ProductType.values()[RANDOM.nextInt(ProductType.values().length)],  // тип продукта
                    ManufacturerGenerator.generateManufacturer(),  // производитель
                    ReviewGenerator.generateReviews(RANDOM.nextInt(10))  // отзывы
            ));
        }
        return products;
    }
}
