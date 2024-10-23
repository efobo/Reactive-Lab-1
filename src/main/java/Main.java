import entities.Manufacturer;
import entities.Product;
import generators.ManufacturerGenerator;
import generators.ProductGenerator;
import statistics.Calculation;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ManufacturerGenerator manufacturerGenerator = new ManufacturerGenerator();

        System.out.println("--------------Part 1--------------");
        System.out.println("-------------5000 Test------------");

        List<Manufacturer> manufacturers = manufacturerGenerator.generateList(12);

        ProductGenerator productGenerator = new ProductGenerator(manufacturers, 12);
        List<Product> products1 = productGenerator.generateList(5000);

        //products.forEach(System.out::println);
        long startTime = System.currentTimeMillis();
        Map<Manufacturer, Double> avgRatingByLoop1 = Calculation.averageRatingWithLoop(products1, manufacturers);
        long avgRatingByLoopTime1 = System.currentTimeMillis() - startTime;
        System.out.println("Results of calculations by iterative cycle on collection:");
        Calculation.printCalculationResult(avgRatingByLoop1);

        startTime = System.currentTimeMillis();
        Map<Manufacturer, Double> avgRatingByStream1  = Calculation.averageRatingWithStream(products1, manufacturers);
        long avgRatingByStreamTime1 = System.currentTimeMillis() - startTime;
        System.out.println("\nPipeline calculation results using Stream API based on collectors from the standard library:");
        Calculation.printCalculationResult(avgRatingByStream1);

        startTime = System.currentTimeMillis();
        Map<Manufacturer, Double> avgRatingByMyCollector1 = Calculation.averageRatingWithMyCollector(products1, manufacturers);
        long avgRatingByMyCollectorTime1 = System.currentTimeMillis() - startTime;
        System.out.println("\nResults of calculations by conveyor with the help of own collector:");
        Calculation.printCalculationResult(avgRatingByMyCollector1);
        System.out.println("\n- Time to perform an iterative loop calculation over a collection = "
                + avgRatingByLoopTime1 + " milliseconds");
        System.out.println("- Pipeline calculation execution Time using Stream API based on Standard Library collectors = "
                + avgRatingByStreamTime1 + " milliseconds");
        System.out.println("- Conveyor calculation execution Time using its own collector = "
                + avgRatingByMyCollectorTime1 + " milliseconds");

        System.out.println("\n--------------Part 2--------------");
        System.out.println("------------50000 Test------------");

        List<Product> products2 = productGenerator.generateList(50000);

        startTime = System.currentTimeMillis();
        Map<Manufacturer, Double> avgRatingByLoop2 = Calculation.averageRatingWithLoop(products2, manufacturers);
        long avgRatingByLoopTime2 = System.currentTimeMillis() - startTime;
        System.out.println("Results of calculations by iterative cycle on collection:");
        Calculation.printCalculationResult(avgRatingByLoop2);

        startTime = System.currentTimeMillis();
        Map<Manufacturer, Double> avgRatingByStream2  = Calculation.averageRatingWithStream(products2, manufacturers);
        long avgRatingByStreamTime2 = System.currentTimeMillis() - startTime;
        System.out.println("\nPipeline calculation results using Stream API based on collectors from the standard library:");
        Calculation.printCalculationResult(avgRatingByStream2);

        startTime = System.currentTimeMillis();
        Map<Manufacturer, Double> avgRatingByMyCollector2 = Calculation.averageRatingWithMyCollector(products2, manufacturers);
        long avgRatingByMyCollectorTime2 = System.currentTimeMillis() - startTime;
        System.out.println("\nResults of calculations by conveyor with the help of own collector:");
        Calculation.printCalculationResult(avgRatingByMyCollector2);
        System.out.println("\n- Time to perform an iterative loop calculation over a collection = "
                + avgRatingByLoopTime2 + " milliseconds");
        System.out.println("- Pipeline calculation execution Time using Stream API based on Standard Library collectors = "
                + avgRatingByStreamTime2 + " milliseconds");
        System.out.println("- Conveyor calculation execution Time using its own collector = "
                + avgRatingByMyCollectorTime2 + " milliseconds");

        System.out.println("\n--------------Part 3--------------");
        System.out.println("-----------250000 Test------------");

        List<Product> products3 = productGenerator.generateList(250000);

        startTime = System.currentTimeMillis();
        Map<Manufacturer, Double> avgRatingByLoop3 = Calculation.averageRatingWithLoop(products3, manufacturers);
        long avgRatingByLoopTime3 = System.currentTimeMillis() - startTime;
        System.out.println("Results of calculations by iterative cycle on collection:");
        Calculation.printCalculationResult(avgRatingByLoop3);

        startTime = System.currentTimeMillis();
        Map<Manufacturer, Double> avgRatingByStream3  = Calculation.averageRatingWithStream(products3, manufacturers);
        long avgRatingByStreamTime3 = System.currentTimeMillis() - startTime;
        System.out.println("\nPipeline calculation results using Stream API based on collectors from the standard library:");
        Calculation.printCalculationResult(avgRatingByStream3);

        startTime = System.currentTimeMillis();
        Map<Manufacturer, Double> avgRatingByMyCollector3 = Calculation.averageRatingWithMyCollector(products3, manufacturers);
        long avgRatingByMyCollectorTime3 = System.currentTimeMillis() - startTime;
        System.out.println("\nResults of calculations by conveyor with the help of own collector:");
        Calculation.printCalculationResult(avgRatingByMyCollector3);
        System.out.println("\n- Time to perform an iterative loop calculation over a collection = "
                + avgRatingByLoopTime3 + " milliseconds");
        System.out.println("- Pipeline calculation execution Time using Stream API based on Standard Library collectors = "
                + avgRatingByStreamTime3 + " milliseconds");
        System.out.println("- Conveyor calculation execution Time using its own collector = "
                + avgRatingByMyCollectorTime3 + " milliseconds");
    }
}