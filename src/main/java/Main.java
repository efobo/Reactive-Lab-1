import entities.Manufacturer;
import entities.Product;
import generators.ManufacturerGenerator;
import generators.ProductGenerator;
import statistics.Calculation;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Создаем пул компаний-производителей
        ManufacturerGenerator manufacturerGenerator = new ManufacturerGenerator();
        List<Manufacturer> manufacturers = manufacturerGenerator.generateList(2);

        // Создаем продукты
        ProductGenerator productGenerator = new ProductGenerator(manufacturers, 2);
        List<Product> products = productGenerator.generateList(3);

        //products.forEach(System.out::println);
        Map<Manufacturer, Double> avgRaitingByLoop = Calculation.averageRatingWithLoop(products, manufacturers);
        Map<Manufacturer, Double> avgRaitingByStream  = Calculation.averageRatingWithStream(products, manufacturers);
        Map<Manufacturer, Double> avgRaitingByMyCollector = Calculation.averageRatingWithMyCollector(products, manufacturers);
        System.out.println("Results of calculations by iterative cycle on collection:");
        Calculation.printCalculationResult(avgRaitingByLoop);
        System.out.println("\nPipeline calculation results using Stream API based on collectors from the standard library:");
        Calculation.printCalculationResult(avgRaitingByStream);
        System.out.println("\nResults of calculations by conveyor with the help of own collector:");
        Calculation.printCalculationResult(avgRaitingByMyCollector);
    }
}