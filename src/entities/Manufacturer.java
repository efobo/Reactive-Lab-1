package entities;

import enums.Country;

import java.time.LocalDate;

public class Manufacturer {
    private int id;
    private String name;
    private LocalDate foundationDate;
    private Country country;

    public Manufacturer(int id, String name, LocalDate foundationDate, Country country) {
        this.id = id;
        this.name = name;
        this.foundationDate = foundationDate;
        this.country = country;
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

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
