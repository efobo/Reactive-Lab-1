package generators;

import entities.Manufacturer;
import enums.Country;

import java.time.LocalDate;
import java.util.Random;

public class ManufacturerGenerator {

    private static final Random RANDOM = new Random();

    public static Manufacturer generateManufacturer() {
        return new Manufacturer(
                RANDOM.nextInt(1000),
                "Manufacturer" + RANDOM.nextInt(100),
                LocalDate.now().minusYears(RANDOM.nextInt(100)),
                Country.values()[RANDOM.nextInt(Country.values().length)]
        );
    }
}
