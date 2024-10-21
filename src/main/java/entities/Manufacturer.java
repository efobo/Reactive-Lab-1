package entities;

import enums.Country;

import java.time.LocalDate;

public record Manufacturer(int id, String name, LocalDate foundationDate, Country country) {
};
