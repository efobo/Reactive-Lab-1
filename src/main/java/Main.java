import entities.Manufacturer;
import entities.Product;
import generators.ManufacturerGenerator;
import generators.ProductGenerator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем пул компаний-производителей
        ManufacturerGenerator manufacturerGenerator = new ManufacturerGenerator();
        List<Manufacturer> manufacturers = manufacturerGenerator.generateList(1000);

        // Создаем продукты
        ProductGenerator productGenerator = new ProductGenerator(manufacturers, 100);
        List<Product> products = productGenerator.generateList(1000);

        products.forEach(System.out::println);
    }
}