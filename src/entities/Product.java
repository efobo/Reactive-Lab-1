package entities;

import enums.ProductType;

import java.time.LocalDate;
import java.util.List;

public class Product {
    private int id;  // примитив
    private String name;  // строка
    private double price;  // примитив
    private LocalDate releaseDate;  // дата/время
    private ProductType type;  // enum
    private Manufacturer manufacturer;  // дополнительный атрибут
    private List<Review> reviews;  // коллекция

    public Product(int id, String name, double price, LocalDate releaseDate, ProductType type, Manufacturer manufacturer, List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.type = type;
        this.manufacturer = manufacturer;
        this.reviews = reviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


}
