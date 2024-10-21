package entities;

import enums.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class Product {
    private int id;
    private double price; // примитив
    private String name; // строка
    private LocalDate releaseDate; // дата
    private Country country; // enum
    private Manufacturer manufacturer; // record
    private List<Review> reviews; // коллекция
}
