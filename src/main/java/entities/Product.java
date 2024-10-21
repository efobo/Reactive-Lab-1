package entities;

import enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class Product {
    private int id;  // примитив
    private String name;  // строка
    private double price;  // примитив
    private LocalDate releaseDate;  // дата/время
    private ProductType type;  // enum
    private Manufacturer manufacturer;  // дополнительный атрибут
    private List<Review> reviews;  // коллекция
}
